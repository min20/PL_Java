package abstractex;

public class RiverBarge extends Vehicle {
	
	public RiverBarge(double distance, double fuelEfficiency) {
		this.distance = distance;
		this.fuelEfficiency = fuelEfficiency;
		
	}
	
	@Override
	public double clacFuelEfficiency() {
		return this.fuelEfficiency;
	}

	@Override
	public double clacTripDistance() {
		return this.distance;
	}

}
