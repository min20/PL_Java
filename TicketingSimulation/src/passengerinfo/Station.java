package passengerinfo;

import static util.TimeStream.time;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import map.Map;
import util.PassengerQueue;

public class Station {
	
	public static enum StnName {
		Asan(0, "Asan"),
		Chuncheon(1, "Chuncheon"),
		Daejeon(2, "Daejeon"),
		Gyeongju(3, "Gyeongju"),
		Gwangju(4, "Gwangju"),
		Seoul(5, "Seoul"),
		Wonju(6, "Wonju");
		
		private int idx;
		private String strName;
		
		StnName(int idx, String strName) {
			this.idx = idx;
			this.strName = strName;
		}
		
		public int getShortestDistance(StnName stnName) {
			return Map.getGraph()[getIdx()][stnName.getIdx()];
		}
		
		public String toString() {
			return this.strName;
		}
		
		private int getIdx() {
			return idx;
		}
	}

	private static PassengerQueue allPassengerQueue = getAllPassengerQueue();
	private static PassengerQueue arrivedPassengerQueue = new PassengerQueue();
	private static int allPassengersNum = allPassengerQueue.getList().size();
	private static int arrivedPassengersNum;

	private Station() {	}

	public static PassengerQueue getArrivedPassengers() {
		PassengerQueue arrivedPassengerQueue = new PassengerQueue();
		
		Passenger passenger = allPassengerQueue.getFront();
		
		if (passenger == null) {
			return null;
		}
		
		while (allPassengerQueue.getFront().getArrivalTime() <= time
				& allPassengerQueue.getFront() != Passenger.nobody) {
			arrivedPassengerQueue.enqueue(allPassengerQueue.dequeue());
		}
		
		return arrivedPassengerQueue;
	}
	
	private static PassengerQueue getAllPassengerQueue() {
		PassengerQueue allPassengerQueue = new PassengerQueue();
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("./data/Passengers.txt"));
			String line;
			String[] parser;
			while ((line = br.readLine()) != null) {
				parser = line.split("\\	");
				allPassengerQueue.enqueue(createPassenger(parser));
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (br != null) {
					br.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return allPassengerQueue;
	}
	
	private static Passenger createPassenger(String[] parser) {
		int id = Integer.parseInt(parser[0]);
		String name = parser[1];
		int arrivalTime = Integer.parseInt(parser[2]);
		int ticketingTime = Integer.parseInt(parser[3]);
		StnName departureStation = StnName.valueOf(parser[4]);
		StnName arrivalStation = StnName.valueOf(parser[5]);
		
		Passenger passenger = Passenger.create(id, name, arrivalTime, ticketingTime,
				departureStation, arrivalStation);
		
		return passenger;
	}
	
	public static PassengerQueue getArrivedPassengerQueue() {
		sortArrivedPassengerQueue();
		return arrivedPassengerQueue;
	}
	
	public static void setArrivedPassengerQueue(PassengerQueue arrived) {
		arrivedPassengerQueue.enqueueAll(arrived);
		setArrivedPassengersNum();
	}
	
	private static void sortArrivedPassengerQueue() {
		arrivedPassengerQueue.sort();
	}

	private static void setArrivedPassengersNum() {
		arrivedPassengersNum = arrivedPassengerQueue.getList().size();
	}
	
	public static boolean isFinish() {
		return (allPassengersNum == arrivedPassengersNum);
	}
	
}
