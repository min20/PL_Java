package test;

import passengerinfo.Station;
import junit.framework.TestCase;
import util.PassengerQueue;

public class StationTest extends TestCase {
	
	public void testGetArrivedPassengerQueue() {
		PassengerQueue arrived = new PassengerQueue();
		arrived.enqueueAll(Station.getArrivedPassengers());
		
		for (int idx = 1 ; idx <= 5 ; idx++) {
			assertEquals(idx, arrived.dequeue().getId());
		}
		assertEquals(null, arrived.dequeue());
		
		arrived.enqueueAll(Station.getArrivedPassengers());
		assertEquals(null, arrived.dequeue());
	}

}
