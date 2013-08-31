package map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map {
	
	private static final int NUM_CITY = 7;
	
	private static int[][] graph = getShortestDistance();

	private static int[][] initGraph() {
		int[][] graph = new int[7][7];
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("./data/map.txt"));
			String line;
			String[] parser;

			for (int row = 0 ; row < 7 ; row++) {
				line = br.readLine();
				if (line == null) {
					continue;
				}
				parser = line.split("\\	");
				for (int col = 0 ; col < 7 ; col++) {
					graph[row][col] = Integer.parseInt(parser[col]);
				}
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (br != null) {
					br.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}

		return graph;
	}
	
	private static int[][] getShortestDistance() {
		int[][] graph = initGraph();
		
		for(int v = 0; v < NUM_CITY; v++) {
			for(int r = 0; r < NUM_CITY; r++) {
				for(int s = 0; s < NUM_CITY; s++) {
					if (graph[r][v] + graph[v][s] < graph[r][s]) {
						graph[r][s] = graph[r][v] + graph[v][s];
					}
				}
			}
		}
		
		return graph;
	}
	
	public static int[][] getGraph() {
		return graph;
	}

}
