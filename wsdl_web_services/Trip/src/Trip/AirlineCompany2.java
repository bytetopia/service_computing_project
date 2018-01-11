package Trip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AirlineCompany2 {
	public ArrayList<String> getAirline(String flightdate, String departcity, String arrivecity) {
		ArrayList<String> list = new ArrayList<>();
		String tmp = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "abc", "123456");
			String opt = "SELECT * FROM airline2 "
					+ "WHERE flightdate='" + flightdate
					+ "' AND departcity='" + departcity
					+ "' AND arrivecity='" + arrivecity + "'";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(opt);
			
			while (rs.next()) {
				String flightno = rs.getString(2);
				String company = rs.getString(3);
				String departtime = rs.getString(5);
				String arrivetime = rs.getString(6);
				Integer price = rs.getInt(9);
				tmp = flightno + " " + company + " " + flightdate + " " + departtime + " " + arrivetime 
						+ " " + departcity + " " + arrivecity + " " + price.toString();
				list.add(tmp);
			}
			connect.close();
		} catch (Exception e) {
		}
		return list;
	}
	
	public String setOrder(String orderno, String flightno) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // 加载MYSQL JDBC驱动程序
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "abc", "123456");
			String opt = "INSERT INTO orders2 (orderno,flightno) "
					+ "VALUES ('" + orderno + "','" + flightno + "')";
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
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "abc", "123456");
			String opt = "SELECT flightno FROM orders2 WHERE orderno='" + orderno + "'";
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(opt);
			while (rs.next()) {
				String flightno = rs.getString(1);
				opt = "SELECT * FROM airline2 WHERE flightno='" + flightno + "'";
				stmt = connect.createStatement();
				ResultSet rs2 = stmt.executeQuery(opt);
				while (rs2.next()) {
					String company = rs2.getString(3);
					String flight_date = rs2.getString(4);
					String departtime = rs2.getString(5);
					String arrivetime = rs2.getString(6);
					String depart_city = rs2.getString(7);
					String arrive_city = rs2.getString(8);
					Integer price = rs2.getInt(9);
					order = orderno + " " + flightno + " " + company + " " + flight_date + " " + departtime 
							+ " " + arrivetime + " " + depart_city + " " + arrive_city + " " + price.toString();
				}
			}
			connect.close();
		} catch (Exception e) {
		}
		return order;
	}
}

