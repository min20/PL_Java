package chess;

import java.util.ArrayList;
import java.util.Collections;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.None;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

/**
 * Provides rules of Board
 * 
 * @author Mint
 */
public class Board {
	
	/**
	 * set Board Size
	 */
	static final int ROW_SIZE = 8;
	static final int COL_SIZE = 8;
	
	private static Board theBoard;
	
	/**
	 * Array List for memorize pieces' position.
	 */
	private ArrayList<Piece> pieceList;

	private Board() { }
	
	/**
	 * Create a Chess Board
	 * 
	 * @return new Board address
	 */
	public static Board createBoard() {
		if (theBoard == null) { 
			theBoard = new Board();
		}
		
		theBoard.pieceList = new ArrayList<Piece>();
	
		return theBoard;
	}
	
	/**
	 * initialize to none Piece 
	 */
	public void initialize() {
		for (int idx = 0 ; idx < ROW_SIZE * COL_SIZE ; idx++) {
			pieceList.add(None.getNone());
		}
	}
	
	public void lineUp() {
		int idx = 0;
		
		for (int col = 0 ; col < ROW_SIZE ; col++) {
			idx = 1 * ROW_SIZE + col;
			pieceList.set(idx, Pawn.black());
			
			idx = 6 * ROW_SIZE + col;
			pieceList.set(idx, Pawn.white());

		}
		
		addPiece(Rook.black(), "a1");
		addPiece(Rook.black(), "a8");
		addPiece(Knight.black(), "a2");
		addPiece(Knight.black(), "a7");
		addPiece(Bishop.black(), "a3");
		addPiece(Bishop.black(), "a6");
		addPiece(Queen.black(), "a4");
		addPiece(King.black(), "a5");

		addPiece(Rook.white(), "h1");
		addPiece(Rook.white(), "h8");
		addPiece(Knight.white(), "h2");
		addPiece(Knight.white(), "h7");
		addPiece(Bishop.white(), "h3");
		addPiece(Bishop.white(), "h6");
		addPiece(Queen.white(), "h4");
		addPiece(King.white(), "h5");
		
		
	}
	
	/**
	 * Print Board on console
	 */
	public void printBoard() {
		int idx = 0;
		StringBuilder line = new StringBuilder();
		Piece piece;
		
		for (int row = 0 ; row < ROW_SIZE ; row++) {
			for (int col = 0 ; col < COL_SIZE ; col++) {
				idx = row * ROW_SIZE + col;
				piece = pieceList.get(idx);

				line.append(piece.getRepresentation());
			}
			line.append("\n");
		}	
		System.out.println(line);
	}
	
	/**
	 * add Piece to pieceList
	 * @param piece : piece to add
	 * @param stringPosition : position to put (ex "a8")
	 */
	public void addPiece(Piece piece, String stringPosition) {
		int idx = 0;
		Position position = new Position(stringPosition);
		piece.setPosition(position);
		
		idx = position.getX() * 8 + position.getY();
		
		pieceList.set(idx, piece);
	}
	
	/**
	 * get piece in positin("a8" -> convert to int index) 
	 * @param stringPosition : position to get (ex "a8")
	 * @return
	 */
	public Piece getPiece(String stringPosition) {
		Position position = new Position(stringPosition);
		
		return getPiece(position.getX(), position.getY());
	}
	
	/**
	 * get piece in position(x, y)
	 * @param x
	 * @param y
	 * @return
	 */
	public Piece getPiece(int x, int y) {
		int idx = x * 8 + y;
		
		return pieceList.get(idx);
	}
	
	public int countPiece(Piece.Type type, Piece.Color color) {
		int total = 0;
		for (Piece piece : pieceList) {
			if (piece.getType() == type && piece.getColor() == color) {
				total = total + 1;
			}
		}
		
		return total;
	}
	
	public double getScore(Piece.Color color) {
		double score = 0;
		
		score =
			getPawnScore(color) +
			getScore(Piece.Type.KNIGHT, color) +
			getScore(Piece.Type.ROOK, color) +
			getScore(Piece.Type.BISHOP, color) +
			getScore(Piece.Type.QUEEN, color);
		
		return score;
	}
	
	private double getScore(Piece.Type type, Piece.Color color) {
		
		return countPiece(type, color) * type.getPoint();
	}
	
	private double getPawnScore(Piece.Color color) {
		double score = 0;
		int idx;
		Piece piece;
		
		for (int col = 0 ; col < COL_SIZE ; col++) {
			int numberOfPawns = 0;
			for (int row = 0 ; row < ROW_SIZE ; row++) {
				idx = row * ROW_SIZE + col;
				piece = pieceList.get(idx);
				
				if (piece.getType() == Piece.Type.PAWN && piece.getColor() == color) {
					numberOfPawns++;
				}
			}
				
			if (numberOfPawns <= 1)
		 		score = score + numberOfPawns * 1.0;
			else
				score = score + numberOfPawns * Piece.Type.PAWN.getPoint();
		}
		
		return score;
	}

	/**
	 * Sorting the pieceList ordered by Pieces' point.
	 * @param color : indicate the color that you want to sort
	 * @return : sorted PieceList
	 */
	public ArrayList<Piece> sortPieceList(Piece.Color color) {
		ArrayList<Piece> sortedPieceList = new ArrayList<Piece>();

		for (Piece piece : pieceList) {
			if (piece.getColor() == color) {
				sortedPieceList.add(piece);
			}
		}
		
		Collections.sort(sortedPieceList);
		
		return sortedPieceList;
	}

		
}
