package pieces;

import java.util.ArrayList;

import chess.Position;
import chess.Position.Move;

public class Pawn extends Piece {	
	
	private Pawn(Piece.Color color) {
		super(Piece.Type.PAWN, color, null);
	}
	
	public static Pawn white() {
		
		return new Pawn(Piece.Color.WHITE);
	}
	
	public static Pawn black() {
		
		return new Pawn(Piece.Color.BLACK);
	}

	@Override
	public ArrayList<Position> getPossibleMoves() { 
		possibleMoves = new ArrayList<Position>();
		int newY;
		
		if (getColor() == Piece.Color.BLACK)
			newY = getPosition().getY() + Move.N.getY();
		else
			newY = getPosition().getY() - Move.N.getY();
		
		if (newY < 0 || 7 < newY)
			return possibleMoves;
		
		possibleMoves.add(new Position(getPosition().getX(), newY));	
		return possibleMoves;
	}
	
}