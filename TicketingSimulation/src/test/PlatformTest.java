package test;

import static passengerinfo.Platform.getTrainWatingQueue;
import static passengerinfo.TicketOffice.handlePassengers;
import static util.TimeStream.incrementTime;
import static util.TimeStream.time;
import junit.framework.TestCase;
import passengerinfo.Platform;
import passengerinfo.TicketOffice;

public class PlatformTest extends TestCase {
	
	public void testTrainWatingQueue() {
		while (time <= 5) {
			Platform.refresh();
			TicketOffice.refresh();
			handlePassengers();
			
			if (time == 0) assertEquals(0, getTrainWatingQueue().getList().size());
			else if (time == 1) assertEquals(1, getTrainWatingQueue().getList().size());
			else if (time == 2) assertEquals(2, getTrainWatingQueue().getList().size());
			else if (time == 3) assertEquals(4, getTrainWatingQueue().getList().size());
			else if (time == 4) assertEquals(5, getTrainWatingQueue().getList().size());
			else assertEquals(0, getTrainWatingQueue().getList().size());
			
			incrementTime();
		}
	}

}
