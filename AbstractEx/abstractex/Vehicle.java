package abstractex;

public abstract class Vehicle {
	public double distance;
	public double fuelEfficiency;
	
	public abstract double clacFuelEfficiency();
	public abstract double clacTripDistance();
	
	public final double calFuelNeeds()
	{
		return clacTripDistance() / clacFuelEfficiency();
	}
	
}
