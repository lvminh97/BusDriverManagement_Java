package handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Auth;

public class AuthHandler {
	
	public static boolean authorize = false;
	
	public static boolean login(Auth auth) {
		authorize = false;
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(String.format(
					"SELECT id,username FROM auth WHERE username='%s' AND password='%s'",
					auth.getUsername(), auth.getPassword())
			);
			if(rs.next()) {
				authorize = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authorize;
	}
	
}
