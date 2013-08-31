package test;

import junit.framework.TestCase;
import map.Map;

public class MapTest extends TestCase {

	public void testGetGraph() {
		int[][] graph = Map.getGraph();
		
		for (int row = 0 ; row < 7 ; row++) {
			for (int col = 0 ; col < 7 ; col++) {
				System.out.printf("%d ", graph[row][col]);
			}
			System.out.println();
		}
	}
	
}
