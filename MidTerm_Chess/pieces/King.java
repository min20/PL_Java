package pieces;

import java.util.ArrayList;

import chess.Position;
import chess.Position.Move;

public class King extends Piece {
	
	private static final Position.Move[] moves = {Move.S, Move.N, Move.E, Move.SW, Move.SE, Move.NW, Move.NE};	
	
	private King(Piece.Color color) {
		super(Piece.Type.KING, color, moves);
	}
	
	public static King white() {
		
		return new King(Piece.Color.WHITE);
	}
	
	public static King black() {
		
		return new King(Piece.Color.BLACK);
	}
	
	public ArrayList<Position> getPossibleMoves() {
		possibleMoves = new ArrayList<Position>();
		
		for (Move move : moves) {
			int newX = getPosition().getX() + move.getX();
			int newY = getPosition().getY() + move.getY();
			
			if (newX < 0 || 7 < newX)
				continue;
			if (newY < 0 || 7 < newY)
				continue;
			
			possibleMoves.add(new Position(newX, newY));
		}
		
		return possibleMoves;
	}


}
