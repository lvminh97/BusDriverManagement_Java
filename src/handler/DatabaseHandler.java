package handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler {
	
	private static final int DB_PORT = 3306;
	private static final String DB_NAME = "bus_driver_management";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "";
	
	private static Connection connection = null;
	
	public static void initialize() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:" + DB_PORT + "/" + DB_NAME,
					DB_USER, DB_PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
	
}
