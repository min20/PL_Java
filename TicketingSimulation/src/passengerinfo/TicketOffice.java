package passengerinfo;

import java.util.ArrayList;

import util.PassengerQueue;

public class TicketOffice {
	
	private static final int MAX_TELLERS = 3;
	
	private static PassengerQueue ticketWatingQueue = new PassengerQueue();
	private static ArrayList<Teller> tellers = new ArrayList<Teller>();
	
	private static TicketOffice ticketOffice;
	
	private TicketOffice() {
		for (int idx =  0; idx < MAX_TELLERS ; idx++) {
			tellers.add(Teller.getInstance());
		}
	}
	
	public static void refresh() {
		if (ticketOffice == null) {
			ticketOffice = new TicketOffice();
		}
		addArrivedPassengers();
	}
	
	private static void addArrivedPassengers() {
		ticketWatingQueue.enqueueAll(Station.getArrivedPassengers());
	}
	
	public static PassengerQueue getTicketWatingQueue() {
		return ticketWatingQueue;
	}
	
	public static void handlePassengers() {
		for (int idx = 0 ; idx < MAX_TELLERS ; idx++) {
			tellers.get(idx).work();
		}
		
		for (Passenger passenger : ticketWatingQueue.getList()) {
			passenger.increaseTicketWating();
		}
	}
	
}
