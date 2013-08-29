package pieces;

import java.util.ArrayList;

import chess.Position;

public class None extends Piece {
	
	public static None none = None.none(); 
	
	private None(Piece.Color color) {
		super(Piece.Type.NONE, color, null);
	}
	
	public static None none() {
		
		return new None(Piece.Color.NONE);
	}
	
	public static None getNone() {
		
		return none;
	}

	@Override
	public ArrayList<Position> getPossibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}
}
