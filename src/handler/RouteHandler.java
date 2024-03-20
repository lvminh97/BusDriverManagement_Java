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
	
	public static boolean add(Route route) {
		boolean check = true;
		
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(String.format("INSERT INTO route (name,description) VALUES "
					+ "('%s','%s')", 
					route.getName(), route.getDescription())
			);

		} catch (SQLException e) {
			check = false;
			e.printStackTrace();
		}
		
		return check;
	}
	
	public static boolean delete(int id) {
		boolean check = true;
		
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(String.format("DELETE FROM route WHERE id=%d", id));

		} catch (SQLException e) {
			check = false;
			e.printStackTrace();
		}
		
		return check;
	}

	public static boolean update(Route route) {
		boolean check = true;
		
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(String.format("UPDATE route SET name='%s',description='%s' WHERE id=%d",
					route.getName(),
					route.getDescription(),
					route.getId())
			);

		} catch (SQLException e) {
			check = false;
			e.printStackTrace();
		}
		
		return check;
	}
}
