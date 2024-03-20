package handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import model.License;

public class LicenseHandler {

	public static ArrayList<License> getList() {
		ArrayList<License> res = new ArrayList<License>();
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM license ORDER BY id");
			while(rs.next()) {
				res.add(new License(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static HashMap<Integer, License> getMap() {
		ArrayList<License> list = getList();
		HashMap<Integer, License> map = new HashMap<Integer, License>();
		for(License x: list) {
			map.put(x.getId(), x);
		}
		return map;
	}
}
