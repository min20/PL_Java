package pieces;

import java.util.ArrayList;

import chess.Position;
import chess.Position.Move;

public class Rook extends Piece {
	
	private static final Position.Move[] moves = {Move.S, Move.N, Move.W, Move.E};	
	
	private Rook(Piece.Color color) {
		super(Piece.Type.ROOK, color, moves);
	}
	
	public static Rook white() {
		
		return new Rook(Piece.Color.WHITE);
	}
	
	public static Rook black() {
		
		return new Rook(Piece.Color.BLACK);
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