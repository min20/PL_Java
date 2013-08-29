package abstractex;

public class Truck extends Vehicle {
	
	public Truck(double distance, double fuelEfficiency) {
		this.distance = distance;
		this.fuelEfficiency = fuelEfficiency;
		
	}
	
	@Override
	public double clacFuelEfficiency() {
		return this.fuelEfficiency;
	}

	@Override
	public double clacTripDistance() {
		return distance;
	}

}
