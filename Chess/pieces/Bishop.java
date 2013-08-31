package pieces;

import java.util.ArrayList;

import chess.Position;
import chess.Position.Move;

public class Bishop extends Piece {
	private static final Position.Move[] moves = {Move.SW, Move.SE, Move.NW, Move.NE};	
	
	private Bishop(Piece.Color color) {
		super(Piece.Type.BISHOP, color, moves);
	}
	
	public static Bishop white() {
		
		return new Bishop(Piece.Color.WHITE);
	}
	
	public static Bishop black() {
		
		return new Bishop(Piece.Color.BLACK);
	}
	
	public ArrayList<Position> getPossibleMoves() {
		possibleMoves = new ArrayList<Position>();
		for (Move move : moves) {
			getPossibleMoves(getPosition(), move);
		}
		
		return possibleMoves;
	}
	
	private void getPossibleMoves(Position position, Move move) {
		int newX = position.getX() + move.getX();
		int newY = position.getY() + move.getY();
		
		if (newX < 0 || 7 < newX)
			return ;
		if (newY < 0 || 7 < newY)
			return ;
		
		Position newPosition = new Position(newX, newY);
		possibleMoves.add(newPosition);
		getPossibleMoves(newPosition, move);
	}
	
}