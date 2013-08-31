package util;

public class TimeStream {
	
	public static final int MAX_TIME = 1000;
	public static int time;

	private TimeStream() { }
	
	public static void incrementTime() {
		time++;
	}
	
}
