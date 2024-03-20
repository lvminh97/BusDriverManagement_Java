package handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import model.StopStation;

public class StopStationHandler {

	public static ArrayList<StopStation> getList() {
		ArrayList<StopStation> res = new ArrayList<StopStation>();
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM stop_station ORDER BY id");
			while(rs.next()) {
				res.add(new StopStation(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static HashMap<Integer, StopStation> getMap() {
		ArrayList<StopStation> list = getList();
		HashMap<Integer, StopStation> map = new HashMap<Integer, StopStation>();
		for(StopStation x: list) {
			map.put(x.getId(), x);
		}
		return map;
	}
	
	public static boolean add(StopStation station) {
		boolean check = true;
		
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(String.format("INSERT INTO stop_station (name,address) VALUES "
					+ "('%s','%s')", 
					station.getName(), station.getAddress())
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
			stmt.execute(String.format("DELETE FROM stop_station WHERE id=%d", id));

		} catch (SQLException e) {
			check = false;
			e.printStackTrace();
		}
		
		return check;
	}

	public static boolean update(StopStation station) {
		boolean check = true;
		
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(String.format("UPDATE stop_station SET name='%s',address='%s' WHERE id=%d",
					station.getName(),
					station.getAddress(),
					station.getId())
			);

		} catch (SQLException e) {
			check = false;
			e.printStackTrace();
		}
		
		return check;
	}
	
	public static ArrayList<StopStation> getListByRoute(int id) {
		ArrayList<StopStation> res = new ArrayList<StopStation>();
		Connection conn = DatabaseHandler.getConnection();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT stop_station.id,stop_station.name,stop_station.address FROM route JOIN stop_station JOIN route_map_stopstation "
					+ "ON route.id=" + id + " AND route.id=route_map_stopstation.route_id AND "
					+ "stop_station.id=route_map_stopstation.stop_station_id "
					+ "ORDER BY stop_station.id");
			while(rs.next()) {
				res.add(new StopStation(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	public static ArrayList<StopStation> search(String keyword) {
		ArrayList<StopStation> res = new ArrayList<StopStation>();
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
				String.format("SELECT * FROM stop_station WHERE name LIKE '%%%s%%' OR address LIKE '%%%s%%' ORDER BY id",
						keyword, keyword)
			);
			while(rs.next()) {
				StopStation item = new StopStation(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3)
				);
				res.add(item);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
