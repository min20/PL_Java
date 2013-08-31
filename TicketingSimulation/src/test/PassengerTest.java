package test;

import junit.framework.TestCase;
import passengerinfo.Passenger;
import passengerinfo.Station;

public class PassengerTest extends TestCase {
	
	public void testGetTravelTime() {
		Passenger passenger = Passenger.create(1, "testTravelTime",
 				0, 0, Station.StnName.Gwangju, Station.StnName.Seoul);
		
		assertEquals(41, passenger.getTravelTime());
	}

}
