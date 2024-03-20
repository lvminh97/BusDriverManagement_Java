package handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import model.Route;

public class RouteHandler {

	public static ArrayList<Route> getList() {
		ArrayList<Route> res = new ArrayList<Route>();
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM route ORDER BY id");
			while(rs.next()) {
				res.add(new Route(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static HashMap<Integer, Route> getMap() {
		ArrayList<Route> list = getList();
		HashMap<Integer, Route> map = new HashMap<Integer, Route>();
		for(Route x: list) {
			map.put(x.getId(), x);
		}
		return map;
	}
}
