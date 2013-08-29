package abstractex;

import java.util.ArrayList;

public class Company {
	public ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private static Company theCompany;
	
	private Company() {
		
	}
	
	public static Company getInstance() {
		if (theCompany == null) {
			theCompany = new Company();
		}
		return theCompany;
	}
	
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);	
	}
	
}
