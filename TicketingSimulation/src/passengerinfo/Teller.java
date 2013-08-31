package passengerinfo;

import static util.TimeStream.time;

public class Teller {
	
	private Passenger currentPassenger;
	
	private Teller() { }
	
	public static Teller getInstance() {
		return new Teller();
	}
	
	public void work() {
		if (currentPassenger == null) {
			receivePassenger(TicketOffice.getTicketWatingQueue().dequeue());
		}
		
		else if (currentPassenger.getTicketingTime() <= time - currentPassenger.getArrivalTime() - currentPassenger.getTicketingWating()) {
			Platform.getTrainWatingQueue().enqueue(complete());
			receivePassenger(TicketOffice.getTicketWatingQueue().dequeue());
		}
	}
	
	public Passenger getCurrentPassenger() {
		return currentPassenger;
	}
	
	private void receivePassenger(Passenger passenger) {
		currentPassenger = passenger;
	}
	
	private Passenger complete() {
		Passenger completed = currentPassenger;
		currentPassenger = null;
		
		return completed;
	}
}
