package pieces;

import java.util.ArrayList;

import chess.Position;
import chess.Position.Move;

public class Queen extends Piece {
	
	private static final Position.Move[] moves = {Move.S, Move.N, Move.W, Move.E, Move.SW, Move.SE, Move.NW, Move.NE};	
	
	private Queen(Piece.Color color) {
		super(Piece.Type.QUEEN, color, moves);
	}
	
	public static Queen white() {
		
		return new Queen(Piece.Color.WHITE);
	}
	
	public static Queen black() {
		
		return new Queen(Piece.Color.BLACK);
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