package pieces;

import java.util.ArrayList;

import chess.Position;
import chess.Position.Move;

/**
 * Provides rules of Pawn
 *  
 * @author Mint
 * 
 */
public abstract class Piece implements Comparable<Piece> {
	private Position position;
	private double point;
	private char representation;
	private Piece.Type type;
	private Piece.Color color;
	protected Position.Move[] moves;
	protected ArrayList<Position> possibleMoves;
	
	public enum Type {
		PAWN(0.5, 'p'), KNIGHT(2.5, 'n'), ROOK(5.0, 'r'), BISHOP(3.0, 'b'), QUEEN(9.0, 'q'), KING(10.0, 'k'), NONE(0.0, '-');
		
		private double point;
		private char representation;
		
		Type(double d, char c) {
			this.point = d;
			this.representation = c;
		}
		
		public double getPoint() {
			return point;
		}
		
		public char getRepresentation() {
			return representation;
		}
	}
	
	public enum Color {
		WHITE, BLACK, NONE;
	}

	protected Piece(Piece.Type type, Piece.Color color, Move[] moves) {
		this.type = type;
		this.color = color;
		this.representation = setRepresentation(type, color);
		this.point = type.getPoint();
		this.moves = moves;
	}
	
	public boolean isWhite(Piece piece) {
		
		return this.color.equals(Piece.Color.WHITE);
	}
	
	public boolean isBlack(Piece piece) {

		return this.color.equals(Piece.Color.BLACK);
	}

	public Piece.Type getType() {
		return type;
	}

	public Piece.Color getColor() {
		return color;
	}
		
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public char getRepresentation() {
		return representation;
	}
	
	private char setRepresentation(Piece.Type type, Piece.Color color) {
		if (color == Piece.Color.BLACK)
			return Character.toUpperCase(type.getRepresentation());
		
		return type.getRepresentation();
	}
	
	public double getPoint() {
		return point;
	}

	@Override
	public int compareTo(Piece that) {
		if (this.getPoint() > that.getPoint())
			return -1;
		else if (this.getPoint() == that.getPoint())
			return 0;
		else
			return 1;
	}
	
	public abstract ArrayList<Position> getPossibleMoves();
	
}
	
