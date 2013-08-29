package pieces;

import java.util.ArrayList;

import chess.Position;
import chess.Position.Move;

public class Knight extends Piece {
	
	private static final Position.Move[] moves = {Move.SW, Move.SE, Move.NW, Move.NE};	
	
	private Knight(Piece.Color color) {
		super(Piece.Type.KNIGHT, color, moves);
	}
	
	public static Knight white() {
		
		return new Knight(Piece.Color.WHITE);
	}
	
	public static Knight black() {
		
		return new Knight(Piece.Color.BLACK);
	}

	@Override
	public ArrayList<Position> getPossibleMoves() {
		possibleMoves = new ArrayList<Position>();
		
		for (Move move : moves) {
			int newX = getPosition().getX() + move.getX();
			int newY = getPosition().getY() + move.getY();
			
			newX = newX + move.getX();
			
			if (newX < 0 || 7 < newX)
				continue;
			if (newY < 0 || 7 < newY)
				continue;
		
			possibleMoves.add(new Position(newX, newY));
		
			newY = newY + move.getY();
			
			if (newX < 0 || 7 < newX)
				continue;
			if (newY < 0 || 7 < newY)
				continue;
			
			possibleMoves.add(new Position(newX, newY));
		}
		
		return possibleMoves;
	}
	
}