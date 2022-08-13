import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/*

	Coded by:
	Modified on:

*/

public class Labyrinth {

	private static final int rows = 20;
	private static final int cols = 20;
	private static int steps = 0;
	private static boolean cloaked = false;
	
	private int startX;
	private int startY;
	private char[][] data;

	// Constructs an empty grid
	public Labyrinth() {
		data = new char[rows][cols];
	}

	// Constructs the grid defined in the file specified
	public Labyrinth(String filename) {
		data = new char[rows][cols];
		readData(filename, data);
	}

	// Finds a path through the labyrinth and returns the number of moves required to exit
	public boolean findPath() {
		return findPath(startX, startY);
	}

	// Private recursive version of findPath()
	private boolean findPath(int x, int y) {
		if(x < 0 || y < 0 || x >= rows || y >= cols) {
			return false;
		}
		if(data[x][y] == '\u0000') {
			return false;
		}
		if (data[x][y] == '#') {
			return false;
		}
		if (data[x][y] == '!') {
			return false;
		}
		if(data[x][y] == 'X') {
			return true;
		}
		if(data[x][y] == '@') {
			cloaked = true;
			data[x][y] = '!';
			return false;
		}
		if(data[x][y] == 'A') {
			if(cloaked) {
				return true;
			}
			return false;
		}
		data[x][y] = '!';
		if(!findPath(x - 1, y) && !findPath(x, y + 1) && !findPath(x + 1, y) && !findPath(x, y - 1)) {
			data[x][y] = '.';
			return false;
		}
		return true;
		
	}
	
	public int getSteps() {
		return steps;
	}

	// Formats this grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String s = "";
		for(int y = 0; y < cols; y++) {
			for(int x = 0; x < rows; x++) {
				s += data[x][y];
			}
			s += "\n";
		}
		return s;
	}

	public void readData (String filename, char[][] gameData) {
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
							if (i < gameData.length && count < gameData[i].length) {
								gameData[i][count] = line.charAt(i);
								if(gameData[i][count] == 'C') {
									startX = i;
									startY = count;
								}
							}

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

}