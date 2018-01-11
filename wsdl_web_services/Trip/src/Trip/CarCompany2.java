package Trip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CarCompany2 {
	public ArrayList<String> getCar(String city, String type, String drivemode) {
		ArrayList<String> list = new ArrayList<>();
		String tmp = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/carRent", "abc", "123456");
			String opt = "SELECT * FROM carRent2 " + "WHERE city='" + city + "'";
			if (type != null)
				opt += " AND type='" + type + "'";
			if (drivemode != null)
				opt += " AND drivemode='" + drivemode + "'";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(opt);
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String company = rs.getString(2);
				if (type == null)
					type = rs.getString(4);
				if (drivemode == null)
					drivemode = rs.getString(5);
				Integer price = rs.getInt(6);
				tmp = id.toString() + " " + company + " " + city + " " + type + " " + drivemode  + " " + price.toString();
				list.add(tmp);
			}
			connect.close();
		} catch (Exception e) {
		}
		return list;
	}
	
	public String setOrder(String orderno, Integer c_id) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/carRent", "abc", "123456");
			String opt = "INSERT INTO orders2 (orderno, c_id) "
					+ "VALUES ('" + orderno + "'," + c_id + ")";
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
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/carRent", "abc", "123456");
			String opt = "SELECT company,city,type,drivemode,price FROM carRent2,orders2 "
					+ "WHERE orderno='" + orderno + "'";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(opt);
			while (rs.next()) {
				String company = rs.getString(1);
				String city = rs.getString(2);
				String type = rs.getString(3);
				String drivemode = rs.getString(4);
				Integer price = rs.getInt(5);
				order = orderno + " " + company + " " + city + " " + type + " " + drivemode + " " + price.toString();
			}
			connect.close();
		} catch (Exception e) {
		}
		return order;
	}
}

