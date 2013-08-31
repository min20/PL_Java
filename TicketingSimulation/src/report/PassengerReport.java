package report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import passengerinfo.Passenger;
import passengerinfo.Station;

public class PassengerReport {

	public String topSeperator = "+-----------------------------------------------+--------------+------------------------+\n";
	public String midSeperator = "+----+---------+-----------+-----------+--------+------+-------+------+--------+--------+\n";
	public String header1 = "|                Passenger Info                 | TicketOffice |     Platform & Train   |\n";
	public String header2 = "| ID |   NAME  | Departure |  Arrival  |Arv.Time| Wait | Spent | Wait |Dep.Tiem|Arv.Time|\n";
	public String formatter = "| %2d | %6s | %9s | %9s | %6d | %4d | %5d | %4d | %6d | %6d |\n";
	
	public void printReport() {
		System.out.print(topSeperator);
		System.out.print(header1);
		System.out.print(midSeperator);
		System.out.print(header2);
		System.out.print(midSeperator);
		for (Passenger passenger : Station.getArrivedPassengerQueue().getList()) {
			System.out.print(String.format(formatter,
					passenger.getId(), passenger.getName(), passenger.getDepartureStation().toString(),
					passenger.getArrivalStation().toString(), passenger.getArrivalTime(),
					passenger.getTicketingWating(), passenger.getTicketingTime(), passenger.getTrainWating(),
					passenger.getTrainRiding(), passenger.getTotalSpentTime() + passenger.getArrivalTime()));
		}
		System.out.print(midSeperator);
	}
	
	public void fprintReport() {
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("./data/report.txt"));
			
			bw.write(topSeperator);
			bw.write(header1);
			bw.write(midSeperator);
			bw.write(header2);
			bw.write(midSeperator);
			for (Passenger passenger : Station.getArrivedPassengerQueue().getList()) {
				bw.write(String.format(formatter,
						passenger.getId(), passenger.getName(), passenger.getDepartureStation().toString(),
						passenger.getArrivalStation().toString(), passenger.getArrivalTime(),
						passenger.getTicketingWating(), passenger.getTicketingTime(), passenger.getTrainWating(),
						passenger.getTrainRiding(), passenger.getTotalSpentTime() + passenger.getArrivalTime()));
				bw.flush();
			}
			bw.write(midSeperator);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
