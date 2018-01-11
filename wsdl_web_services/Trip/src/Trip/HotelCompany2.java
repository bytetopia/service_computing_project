package Trip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class HotelCompany2 {
	public ArrayList<String> getHotelRoom(String checkindate, String checkoutdate, String city, String type) {
		ArrayList<String> list = new ArrayList<>();
		String tmp = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "abc", "123456");
			String opt = "SELECT * FROM hotel2 "
					+ "WHERE checkindate<='" + checkindate
					+ "' AND checkoutdate>='" + checkoutdate
					+ "' AND city='" + city +"'";
			if (type != null)
				opt += " AND type='" + type + "'";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(opt);
			
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String company = rs.getString(2);
				if (type == null)
					type = rs.getString(6);
				Integer price = rs.getInt(7);
				tmp = id.toString() + " " + company + " " + checkindate + " " + checkoutdate + " " + city + " " + type + " " + price.toString();
				list.add(tmp);
			}
			connect.close();
		} catch (Exception e) {
		}
		return list;
	}
	
	public String setOrder(String orderno, Integer h_id, String checkindate, String checkoutdate) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "abc", "123456");
			String opt = "INSERT INTO orders2 (orderno,h_id,checkindate,checkoutdate) "
					+ "VALUES ('" + orderno + "'," + h_id + ",'" + checkindate + "','" + checkoutdate + "')";
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
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "abc", "123456");
			String opt = "SELECT company,orders2.checkindate,orders2.checkoutdate,city,type,price FROM hotel2,orders2 "
					+ "WHERE orderno='" + orderno + "'";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(opt);
			while (rs.next()) {
				String company = rs.getString(1);
				String checkindate = rs.getString(2);
				String checkoutdate = rs.getString(3);
				String city = rs.getString(4);
				String type = rs.getString(5);
				Integer price = rs.getInt(6);
				order = orderno + " " + company + " " + checkindate + " " + checkoutdate + " " + city + " " + type + " " + price.toString();
			}
			connect.close();
		} catch (Exception e) {
		}
		return order;
	}
}

