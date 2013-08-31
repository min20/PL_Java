package chess;

import junit.framework.TestCase;

public class PositionTest extends TestCase {
	
	public void testPosition() {
		Position position = new Position("a8");
		
		System.out.println("X: " + position.getX() + ", Y: " + position.getY());
	}
	
	

}
