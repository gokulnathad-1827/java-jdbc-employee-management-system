package in.kce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() {
		//1. Load JDBC Driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@172.16.100.14:1521:orcll";
			String user="i717824215";
			String pass="i717824215";
			Connection connection=DriverManager.getConnection(url,user,pass);
			return connection; 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
