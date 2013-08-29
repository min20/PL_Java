package abstractex;


public class ShippingMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Company c = Company.getInstance();
		
		c.addVehicle( new Truck(100.0, 10.0));
		c.addVehicle( new Truck(100.0, 10.0));
		c.addVehicle( new RiverBarge(200.0, 10.0));
		c.addVehicle( new Truck(500.0, 25.0));
		c.addVehicle( new RiverBarge(300.0, 30.0));
		
		FuelNeedsReport report = new FuelNeedsReport();
		report.generateText(System.out);
		
	}

}
	