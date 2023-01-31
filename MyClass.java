package project;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyClass {
	static Connection con;
	public static Connection createConnection() {
		
		try {
		    Class.forName("com.mysql.jdbc.Driver"); //loading the driver
		
		String url="jdbc:mysql://localhost:3306/munirajproject";
		String username="root";
		String password="Root";
		//create the connection....
		con=DriverManager.getConnection(url, username, password); //creating connection from DriverManager
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
