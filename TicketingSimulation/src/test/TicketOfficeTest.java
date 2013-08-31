package test;

import static passengerinfo.TicketOffice.getTicketWatingQueue;
import static passengerinfo.TicketOffice.handlePassengers;
import static util.TimeStream.incrementTime;
import static util.TimeStream.time;
import passengerinfo.TicketOffice;
import junit.framework.TestCase;

public class TicketOfficeTest extends TestCase {
	
	public void testHandlePassengers() {
		while (time <= 5) {
			TicketOffice.refresh();
			handlePassengers();
			
			if (time == 0) assertEquals(2, getTicketWatingQueue().getList().size());
			else if (time == 1) assertEquals(4, getTicketWatingQueue().getList().size());
			else if (time == 2) assertEquals(3, getTicketWatingQueue().getList().size());
			else if (time == 3) assertEquals(3, getTicketWatingQueue().getList().size());
			else if (time == 4) assertEquals(2, getTicketWatingQueue().getList().size());
			else assertEquals(4, getTicketWatingQueue().getList().size());
			
			incrementTime();
		}
	}

}
