package util;

import java.util.ArrayList;
import java.util.Collections;

import passengerinfo.Passenger;

public class PassengerQueue {
	
	protected ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
	
	public void enqueue(Passenger passenger) {
		if (passenger == Passenger.nobody) {
			return;
		}
		
		passengerList.add(passenger);
	}
	
	public void enqueueAll(PassengerQueue passengerQueue) {
		if (passengerQueue == null) {
			return;
		}
		this.getList().addAll(passengerQueue.getList());
	}

	public Passenger dequeue() {
		if (isEmpty()) {
			return Passenger.nobody;
		}
	
		return passengerList.remove(0);
	}
	
	public void dequeueAll() {
		passengerList = new ArrayList<Passenger>();
	}

	public boolean isEmpty() {
		if (passengerList.size() <= 0) {
			return true;
		}
		
		return false;
	}
	
	public Passenger getFront() {
		if (isEmpty()) {
			return Passenger.nobody;
		}
		
		return passengerList.get(0);
	}
	
	public ArrayList<Passenger> getList() {
		return passengerList;
	}
	
	public void sort() {
		Collections.sort(passengerList);
	}

	
}
