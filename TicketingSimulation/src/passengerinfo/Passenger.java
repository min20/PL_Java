package passengerinfo;

import passengerinfo.Station.StnName;

public class Passenger implements Comparable<Passenger> {
	
	public static final Passenger nobody = new Passenger(-1, "null");

	private int id;
	private String name;
	private int arrivalTime;
	private int ticketingTime;
	private int ticketingWating;
	private int trainWating;
	private int trainRiding;
	private StnName departureStation;
	private StnName arrivalStation;
	private int travelTime;
	
	private int totalSpentTime;
	
	private Passenger(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	private Passenger(int id, String name, int arrivalTime, int ticketingTime,
			StnName departureStation, StnName arrivalStation) {
		this.id = id;
		this.name = name;
		this.arrivalTime = arrivalTime;
		this.ticketingTime = ticketingTime;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		setTravelTime();
	}
	
	public static Passenger create(int id, String name) {
		return new Passenger(id, name);
	}
	
	public static Passenger create(int id, String name, int arrivalTime, int ticketingTime,
			StnName departureStation, StnName arrivalStation) {
		return new Passenger(id, name, arrivalTime, ticketingTime, departureStation, arrivalStation);
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public int getTicketingTime() {
		return ticketingTime;
	}
	
	public int getTicketingWating() {
		return ticketingWating;
	}
	
	public void increaseTicketWating() {
		ticketingWating++;
	}
	
	public int getTrainWating() {
		return trainWating;
	}
	
	public void increaseTrainWating() {
		trainWating++;
	}
	
	public int getTrainRiding() {
		return trainRiding;
	}
	
	public void setTrainRiding(int time) {
		this.trainRiding = time;
	}

	public StnName getDepartureStation() {
		return departureStation;
	}

	public StnName getArrivalStation() {
		return arrivalStation;
	}

	public int getTravelTime() {
		return travelTime;
	}
	
	private void setTravelTime() {
		travelTime = getDepartureStation().getShortestDistance(getArrivalStation());
	}

	public int getTotalSpentTime() {
		return totalSpentTime;
	}
	
	public void setTotalSpentTime() {
		int totalSpent;
		totalSpent = ticketingTime + ticketingWating + trainWating + travelTime;
		
		totalSpentTime = totalSpent;
	}

	@Override
	public int compareTo(Passenger passenger) {
		if (this.getId() < passenger.getId()) return -1; 
		else if (this.getId() == passenger.getId()) return 0;
		else return 1;
	}
	
}
