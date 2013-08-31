package chess;

import java.util.ArrayList;

import junit.framework.TestCase;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class BoardTest extends TestCase {
	
	public void setUp() {
		Board board = Board.createBoard();
		
		board = Board.createBoard();
		board.initialize();
	}
	
	public void testBoard() {
		Board board = Board.createBoard();
		
		board.initialize();
		
		Piece wPawn = Pawn.white();
		board.addPiece(wPawn, "a1");
		
		Piece bPawn = Pawn.black();
		board.addPiece(bPawn, "a2");
		
	}	
	
	public void testCreate() {
		Board board = Board.createBoard();
		
		board.initialize();
		board.printBoard();
		
	}
	
	public void testLine() {
		Board board = Board.createBoard();
		
		board.initialize();
		
		board.addPiece(King.black(), "a2");
		board.addPiece(Rook.black(), "a3");
		board.addPiece(Pawn.black(), "b1");
		board.addPiece(Pawn.black(), "b3");
		board.addPiece(Bishop.black(), "b4");
		board.addPiece(Pawn.black(), "c2");
		board.addPiece(Queen.black(), "c5");
		
		board.addPiece(Knight.white(), "e6");
		board.addPiece(Queen.white(), "e7");
		board.addPiece(Pawn.white(), "f6");
		board.addPiece(Pawn.white(), "f8");
		board.addPiece(Pawn.white(), "g6");
		board.addPiece(Pawn.white(), "g7");
		board.addPiece(Rook.white(), "h5");
		board.addPiece(King.white(), "h6");
	}
	
	public void testPieceCount() {
		Board board = Board.createBoard();
		testLine();
		
		System.out.println(board.countPiece(Piece.Type.PAWN, Piece.Color.WHITE));
		System.out.println(board.countPiece(Piece.Type.KING, Piece.Color.WHITE));

	}
	
	public void testGetPiece() {
		Board board = Board.createBoard();
		testLine();
		
		Piece piece = board.getPiece("b4");
		System.out.println("Type: " + piece.getType() + ", Color: " + piece.getColor()); 
	}
	
	public void testLineUp() {
		Board board = Board.createBoard();
		board.initialize();
		board.lineUp();
		board.printBoard();
		
	}
	
	public void testGetScore() {
		Board board = Board.createBoard();
		testLine();
		
		board.printBoard();
		
		System.out.println("BLACK: " + board.getScore(Piece.Color.BLACK) + ", WHITE: " + board.getScore(Piece.Color.WHITE));
		
	}
	
	public void testSortPieceList() {
		Board board = Board.createBoard();
		testLine();
		
		ArrayList<Piece> sorted = board.sortPieceList(Piece.Color.WHITE);
		for (Piece piece : sorted) {
			System.out.println(piece.getRepresentation());
		}
	}
	
	public void testGetPossibleMoves() {
		Board board = Board.createBoard();
		testLine();
		
		System.out.println("Bishop: " + board.getPiece("b4").getPossibleMoves());
		System.out.println("Queen : " + board.getPiece("c5").getPossibleMoves());
		System.out.println(" Rook : " + board.getPiece("a3").getPossibleMoves());
		System.out.println(" King : " + board.getPiece("a2").getPossibleMoves());
		System.out.println(" Pawn : " + board.getPiece("b1").getPossibleMoves());
		System.out.println("Knight: " + board.getPiece("e6").getPossibleMoves());
	}


}
