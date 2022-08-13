import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;

/*

	Represents a Game Of Life grid.

	Coded by:
	Modified on:

*/

public class Life {

	private boolean[][] grid;
	private int generation;
	
	// Constructs an empty grid
	public Life() {
		grid = new boolean[20][20];
		generation = 0;
	}

	// Constructs the grid defined in the file specified
	public Life(String filename) {
		grid = new boolean[20][20];
		readData(filename, grid);
	}

	public int neighbors(int i, int j) {
		int n = 0;
		//Sides
		if(!(j + 1 > 19)) {
			if(grid[i][j + 1]) {
				n++;
			}
		}
		if(!(j - 1 < 0)) {
			if(grid[i][j - 1]) {
				n++;
			}
		}
		if(!(i + 1 > 19)) {
			if(grid[i + 1][j]) {
				n++;
			}
		}
		if(!(i - 1 < 0)) {
			if(grid[i - 1][j]) {
				n++;
			}
		}
		
		
		//Corners
		if(!(i - 1 < 0 || j - 1 < 0)) {
			if(grid[i - 1][j - 1]) {
				n++;
			}
		}
		if(!(i + 1 > 19 || j - 1 < 0)) {
			if(grid[i + 1][j - 1]) {
				n++;
			}
		}
		if(!(i + 1 > 19 || j + 1 > 19)) {
			if(grid[i + 1][j + 1]) {
				n++;
			}
		}
		if(!(i - 1 < 0 || j + 1 > 19)) {
			if(grid[i - 1][j + 1]) {
				n++;
			}
		}
		
		return n;
	}
	
	
	
	// Runs a single turn of the Game Of Life
	public void step() {
		boolean[][] nextGen = new boolean[20][20];
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				nextGen[i][j] = grid[i][j];
			}
		}
		
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				if(neighbors(i, j) == 3) {
					nextGen[i][j] = true;
				}
				else if(neighbors(i, j) == 2) {
					//Do Nothing
				}
				else {
					nextGen[i][j] = false;
				}
				
			}
		}
		generation++;
		grid = nextGen;
	}

	// Runs n turns of the Game Of Life
	public void step(int n) {
		for(int i = 0; i < n; i++) {
			step();
		}
	}
	
	// Formats this Life grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String s = "";
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				if(grid[i][j]) {
					s += "*";
				}
				else {
					s += " ";
				}
			}
			s += "\n";
		}
		return s;
	}

	// Reads in array data from a simple text file containing asterisks (*)
	public void readData (String filename, boolean[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
					reader = new FileReader(dataFile);
					in = new Scanner(reader);

					while (in.hasNext()) {
						String line = in.nextLine();
						for(int i = 0; i < line.length(); i++)
							if (count < gameData.length && i < gameData[count].length && line.charAt(i)=='*')
								gameData[count][i] = true;

						count++;
					}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}
			
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
    }
	
	
	
	
	
	
	
	/**
	 * Optionally, complete this method to draw the grid on a PApplet.
	 * 
	 * @param marker The PApplet used for drawing.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 */
	public void draw(PApplet marker, float x, float y, float width, float height) {
		float cellWidth = width/ grid[0].length;
		float cellHeight = height/ grid.length;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]) {
					marker.fill(0);
				}
				else {
					marker.fill(255);
				}
				marker.rect(x + j * cellWidth, y + i * cellWidth, cellHeight, cellWidth);
			}
		}
	}
	
	/**
	 * Optionally, complete this method to determine which element of the grid matches with a
	 * particular pixel coordinate.
	 * 
	 * @param p A Point object representing a graphical pixel coordinate.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 * @return A Point object representing a coordinate within the game of life grid.
	 */
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		if(p.getX() > width || p.getY() > height) {
			//System.out.println("null");
			return null;
		}
		float cellWidth = (width / grid[0].length);
		float cellHeight = (height / grid.length);
		//System.out.println("Point at: " + (p.getY() + y) / cellHeight + " , " + (p.getX() + x) / cellWidth);
		return new Point((int)((p.getY() + y) / cellHeight), (int)((p.getX() + x) / cellWidth));
	}
	
	/**
	 * Optionally, complete this method to toggle a cell in the game of life grid
	 * between alive and dead.
	 * 
	 * @param i The x coordinate of the cell in the grid.
	 * @param j The y coordinate of the cell in the grid.
	 */
	public void toggleCell(int i, int j) {
		grid[i][j] = !grid[i][j];
	}

	
	public int getGen() {
		return generation;
	}
	
	public int getLive() {
		int live = 0;
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				if(grid[i][j]) {
					live++;
				}
			}
		}
		return live;
	}
	
	public int getRow(int rowNum) {
		int num = 0;
		for(int j = 0; j < 20; j++) {
			if(grid[rowNum - 1][j]) {
				num++;
			}
		}
		return num;
	}
	
	public int getColumn(int colNum) {
		int num = 0;
		for(int i = 0; i < 20; i++) {
			if(grid[i][colNum - 1]) {
				num++;
			}
		}
		return num;
	}
	
	
}