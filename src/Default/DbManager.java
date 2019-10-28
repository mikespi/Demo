package Default;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
	
	public static void main(String[] args) {
		DbManager db = new DbManager();
		db.getConnection(); 
	}

		public static Connection getConnection() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Root@123");
				Statement stmt = conn.createStatement();
				return conn;
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Connection failed");
				e.printStackTrace();
				return null;
			}
		}
}
