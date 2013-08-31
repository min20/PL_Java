package passengerinfo;

import static util.TimeStream.*;
import util.PassengerQueue;

public class Platform {
	
	private static PassengerQueue trainWationQueue = new PassengerQueue();
	
	private static Platform platform;
	
	private Platform() { }
	
	public static void refresh() {
		if (platform == null) {
			platform = new Platform();
		}
		
		Station.setArrivedPassengerQueue(train());
	}

	public static PassengerQueue getTrainWatingQueue() {
		return trainWationQueue;
	}
	
	private static PassengerQueue train() {
		for (Passenger passenger : trainWationQueue.getList()) {
			passenger.increaseTrainWating();
		}
		
		if (time % 5 == 0) {
			PassengerQueue inTrain = new PassengerQueue();
			
			for (Passenger passenger : getTrainWatingQueue().getList()) {
				passenger.setTrainRiding(time);
				passenger.setTotalSpentTime();
			}
			
			inTrain.enqueueAll(trainWationQueue);
			trainWationQueue.dequeueAll();
			return inTrain;
		}
		
		return null;
	}
}
