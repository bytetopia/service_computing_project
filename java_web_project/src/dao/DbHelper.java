package dao;

import java.sql.Connection;
import java.sql.DriverManager;


//数据库连接类
public class DbHelper {


	public static Connection getConnection(){
		  String driver = "com.mysql.jdbc.Driver";
		  String url = "jdbc:mysql://localhost:3306/travel_agent";
		  String user = "webadmin";
		  String password = "qwertyuiop#1";
		  try {
			  Class.forName(driver);
				  Connection conn = DriverManager.getConnection(url, user, password);
			  if(!conn.isClosed())
				  return conn;
		  } 
		  catch(Exception e){
			  e.printStackTrace();
		  }
		  return null;
  }  
}
