package chess;

public class Position {
	
	public int x;
	public int y;
	
	public enum Move {
		N(0, 1), S(0, -1), W(-1, 0), E(1, 0), NW(-1, 1), NE(1, 1), SW(-1, -1), SE(1, -1);
		
		private int mx;
		private int my;
		
		Move(int mx, int my) {
			this.mx += mx;
			this.my += my;
		}
		
		public int getX() {
			return this.mx;
		}
		
		public int getY() {
			return this.my;
		}
	}
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public Position(String stringPosition) {
		this.convert(stringPosition);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void convert(String stringPosition) {
		this.x = stringPosition.charAt(0) - 'a';
		this.y = stringPosition.charAt(1) - '1';
	}
	
	public String toString() {
		return "(" + this.x + ", " + this.y + ")"; 
		
	}

}
