package pieces;

import junit.framework.TestCase;

public class PieceTest extends TestCase {
	
	public void testCreate() {

		Piece pawn1 = Pawn.white();
		assertEquals(Piece.Color.WHITE, pawn1.getColor());
		
		Piece pawn2 = Pawn.black();
		assertEquals(Piece.Color.BLACK, pawn2.getColor());
		
		System.out.println (Piece.Type.PAWN.getRepresentation());
	}
	
	public void testGetPoint() {
		Piece piece = King.white();
		
		System.out.println(piece.getPoint());
		
	}

}
