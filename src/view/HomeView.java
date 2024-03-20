package view;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HomeView extends JFrame{
	
	private static final long serialVersionUID = -6961589024995658110L;
	
	private JButton driverManageButton, routeManageButton, stopStationManageButton, licenseManageButton;
	
	public HomeView() {
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle("Phần mềm quản lý lái xe bus");
		this.setSize(600, 400);
		this.setLocation(400, 200);
		
		this.driverManageButton = new JButton("Danh sách tài xế");
		this.driverManageButton.setSize(250, 40);
		this.driverManageButton.setLocation(175, 100);
		this.add(this.driverManageButton);
		
		this.routeManageButton = new JButton("Danh sách tuyến");
		this.routeManageButton.setSize(250, 40);
		this.routeManageButton.setLocation(175, 150);
		this.add(this.routeManageButton);
		
		this.stopStationManageButton = new JButton("Danh sách điểm dừng");
		this.stopStationManageButton.setSize(250, 40);
		this.stopStationManageButton.setLocation(175, 200);
		this.add(this.stopStationManageButton);
		
		this.licenseManageButton = new JButton("Danh sách bằng lái");
		this.licenseManageButton.setSize(250, 40);
		this.licenseManageButton.setLocation(175, 250);
		this.add(this.licenseManageButton);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	public JButton getDriverManageButton() {
		return driverManageButton;
	}

	public JButton getRouteManageButton() {
		return routeManageButton;
	}

	public JButton getStopStationManageButton() {
		return stopStationManageButton;
	}

	public JButton getLicenseManageButton() {
		return licenseManageButton;
	}
	
}
