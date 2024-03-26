package model;

public class Driver {
	private int id;
	private String name;
	private String phone;
	private int licenseId;
	
	public Driver(int id, String name, String phone, int licenseId) {
		this.id = id;
		this.name = name;
		this.phone = phone;
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

	public int getLicenseId() {
		return licenseId;
	}

	public void setLicense(int licenseId) {
		this.licenseId = licenseId;
	}
	
}
