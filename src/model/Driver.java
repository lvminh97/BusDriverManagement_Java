package model;

public class Driver {
	private int id;
	private String name;
	private String phone;
	private int routeId;
	private int licenseId;
	
	public Driver(int id, String name, String phone, int routeId, int licenseId) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.routeId = routeId;
		this.licenseId = licenseId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public int getLicenseId() {
		return licenseId;
	}

	public void setLicense(int licenseId) {
		this.licenseId = licenseId;
	}
	
}
