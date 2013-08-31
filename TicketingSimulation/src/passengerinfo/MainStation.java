package passengerinfo;

import static util.TimeStream.MAX_TIME;
import static util.TimeStream.incrementTime;
import static util.TimeStream.time;
import report.PassengerReport;

public class MainStation {

	public static void main(String[] args) {
		PassengerReport report = new PassengerReport();
		
		while (time <= MAX_TIME & !Station.isFinish()) {
			Platform.refresh();
			TicketOffice.refresh();
			TicketOffice.handlePassengers();
			
			incrementTime();
		}
		
		report.printReport();
		report.fprintReport();
	}

}
