package handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Driver;
import model.Route;

public class DriverHandler {
	
	public static ArrayList<Driver> getList() {
		ArrayList<Driver> res = new ArrayList<Driver>();
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM driver ORDER BY id");
			while(rs.next()) {
				Driver item = new Driver(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4)
				);
				res.add(item);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static boolean add(Driver driver) {
		boolean check = true;
		
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(String.format("INSERT INTO driver (name,phone,license_id) VALUES "
					+ "('%s','%s',%d)", 
					driver.getName(), driver.getPhone(), driver.getLicenseId())
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
			stmt.execute(String.format("DELETE FROM driver WHERE id=%d", id));

		} catch (SQLException e) {
			check = false;
			e.printStackTrace();
		}
		
		return check;
	}

	public static boolean update(Driver driver) {
		boolean check = true;
		
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(String.format("UPDATE driver SET name='%s',phone='%s',license_id=%d WHERE id=%d",
					driver.getName(),
					driver.getPhone(),
					driver.getLicenseId(),
					driver.getId())
			);

		} catch (SQLException e) {
			check = false;
			e.printStackTrace();
		}
		
		return check;
	}
	
	public static ArrayList<Driver> search(String keyword) {
		ArrayList<Driver> res = new ArrayList<Driver>();
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
				String.format("SELECT * FROM driver WHERE name LIKE '%%%s%%' OR phone LIKE '%%%s%%' ORDER BY id",
						keyword, keyword)
			);
			while(rs.next()) {
				Driver item = new Driver(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4)
				);
				res.add(item);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static boolean addRoute(int driverId, int routeId, int turnNumber) {
		boolean check = true;
		
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(String.format("INSERT INTO driver_map_route (driver_id,route_id,turn_number) VALUES (%d,%d,%d)", 
					driverId, routeId, turnNumber));

		} catch (SQLException e) {
			check = false;
			e.printStackTrace();
		}
		
		return check;
	}
	
	public static boolean deleteRoute(int driverId, int routeId) {
		boolean check = true;
		
		Connection conn = DatabaseHandler.getConnection();
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(String.format("DELETE FROM driver_map_route WHERE driver_id=%d AND route_id=%d", 
					driverId, routeId));

		} catch (SQLException e) {
			check = false;
			e.printStackTrace();
		}
		
		return check;
	}
	
}
