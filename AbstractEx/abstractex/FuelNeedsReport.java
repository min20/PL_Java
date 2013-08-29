package abstractex;

import java.io.PrintStream;

public class FuelNeedsReport {

	public void generateText(PrintStream out) {
		Company c = Company.getInstance();
		for (Vehicle vehicle : c.vehicles)
			out.println(vehicle.calFuelNeeds());
		
	}

}
