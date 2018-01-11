package Trip;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

public class SightCompany {
	public ArrayList<String> getSight(String city, Boolean needGuide, Boolean isAll) {
		ArrayList<String> list = new ArrayList<>();
		String tmp = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sight", "abc", "123456");
			String opt = null;
			if (needGuide) {
				if (isAll) {
						opt = "SELECT v_name,v_county,v_price,g_name,company,price FROM views,guides,gv"
								+ " WHERE views.v_id=gv.v_id"
								+ " AND guides.g_id=gv.g_id"
								+ " AND guides.g_id IN ("
								+ "SELECT g_id FROM views,gv"
								+ " WHERE views.v_city='" + city
								+ "' AND views.v_id=gv.v_id"
								+ " GROUP BY g_id"
								+ " HAVING count(gv.v_id) = "
								+ "(SELECT count(v_id) FROM views WHERE v_city='" + city + "'))";
					} else {
						opt = "SELECT v_name,v_county,v_price,g_name,company,price FROM views,guides,gv" 
								+ " WHERE views.v_city='" + city
								+ "' AND views.v_id=gv.v_id" 
								+ " AND guides.g_id=gv.g_id";					
					}
			} else {
				opt = "SELECT v_name,v_county,v_price FROM views WHERE v_city='" + city + "'";
			}
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(opt);
			String v_name;
			String v_county;
			Integer v_price;
			String g_name;
			String company;
			Integer price;
			while (rs.next()) {
				v_name = rs.getString(1);
				v_county = rs.getString(2);
				v_price = rs.getInt(3);
				if (needGuide) {
					g_name = rs.getString(4);
					company = rs.getString(5);
					price = rs.getInt(6);
					tmp = v_name + " " + city + " " + v_county + " " + v_price + " " + g_name + " " + company + " " + price.toString();
				} else {
					tmp = v_name + " " + city + " " + v_county + " " + v_price;
				}
				list.add(tmp);
			}
			connect.close();
		} catch (Exception e) {
		}
		return list;
	}
	
	public String setOrder(String orderno, String v_name, String g_name) {
		Base64.Decoder decoder = Base64.getDecoder();
		try {
			String v_name_d = new String(decoder.decode(v_name),"UTF-8");
			String g_name_d = new String(decoder.decode(g_name),"UTF-8");
		
			String content = "";
			String[] views = v_name_d.split("#");
			String[] guides = g_name_d.split("#");
		
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序

			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sight", "abc", "123456");
			String opt = "INSERT INTO orders (orderno,content) ";
			for (int i = 0; i < views.length; i++) {
				content += views[i];
				if (guides[i].equals("null"))
					content += "-无导游#";
				else
					content += "-" + guides[i] + "#";
			}
			opt += "VALUES ('" + orderno + "','" + content + "')";
			Statement stmt = connect.createStatement();
			stmt.executeUpdate(opt);
			connect.close();
			return "ok";
		} catch (Exception e) {
			return "false";
		}
	}
	
	public String getOrder(String orderno) {
		String order = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sight", "abc", "123456");
			String opt = "SELECT content FROM orders WHERE orderno='" + orderno + "'";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(opt);
			while (rs.next())
				order = orderno + " " + rs.getString(1);
			connect.close();
		} catch (Exception e) {
		}
		return order;
	}
}

