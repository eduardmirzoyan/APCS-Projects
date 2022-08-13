import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import processing.core.PApplet;

/*

	Minesweeper Game

	Coded by: Eduard Mirzoyan
	Modified on: Today

  ~~~Planned Features~~~
  -Icons for mines and flags
  Highlight hovered tiles*
  -Menu Screen + Difficulty selection*
  Nicer UI?**
*/

public class MineSweeper {

	private int[][] grid;
	private int[][] view;
	private final int gameSize;
	private int bombs;
	private boolean gameOver;

	// A minesweeper game
	public MineSweeper(int mines) {
		gameSize = 10;
		bombs = mines;
		grid = new int[gameSize][gameSize];
		view = new int[gameSize][gameSize];
		setField();
	}

	public MineSweeper(int size, int mines) {
		gameSize = size;
		bombs = mines;
		grid = new int[gameSize][gameSize];
		view = new int[gameSize][gameSize];
		setField();
	}

	public MineSweeper(String filename) {
		gameSize = 10;
		grid = new int[gameSize][gameSize];
		view = new int[gameSize][gameSize];
		readData(filename, grid);
		setField();
	}

	public MineSweeper(String filename, int size) {
		gameSize = size;
		grid = new int[gameSize][gameSize];
		view = new int[gameSize][gameSize];
		readData(filename, grid);
		setField();
	}

	public void setField() {
		for (int i = 0; i < bombs;) {
			int x = (int) (Math.random() * gameSize);
			int y = (int) (Math.random() * gameSize);
			if (grid[x][y] != -1) {
				grid[x][y] = -1;
				i++;
			}
		}

		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				if (grid[i][j] == 0) {
					grid[i][j] = neighbors(i, j);
				}

			}
		}
		gameOver = false;
	}

	public int neighbors(int i, int j) {
		int n = 0;
		// Sides
		if (!(j + 1 > gameSize - 1)) {
			if (grid[i][j + 1] == -1) {
				n++;
			}
		}
		if (!(j - 1 < 0)) {
			if (grid[i][j - 1] == -1) {
				n++;
			}
		}
		if (!(i + 1 > gameSize - 1)) {
			if (grid[i + 1][j] == -1) {
				n++;
			}
		}
		if (!(i - 1 < 0)) {
			if (grid[i - 1][j] == -1) {
				n++;
			}
		}

		// Corners
		if (!(i - 1 < 0 || j - 1 < 0)) {
			if (grid[i - 1][j - 1] == -1) {
				n++;
			}
		}
		if (!(i + 1 > gameSize - 1 || j - 1 < 0)) {
			if (grid[i + 1][j - 1] == -1) {
				n++;
			}
		}
		if (!(i + 1 > gameSize - 1 || j + 1 > gameSize - 1)) {
			if (grid[i + 1][j + 1] == -1) {
				n++;
			}
		}
		if (!(i - 1 < 0 || j + 1 > gameSize - 1)) {
			if (grid[i - 1][j + 1] == -1) {
				n++;
			}
		}

		return n;
	}

	private void fillEmpty(int i, int j) {
		if (i < 0 || i >= gameSize || j < 0 || j >= gameSize) {
			// Do nothing
		} else if(view[i][j] == -1) {
			
		} else if (view[i][j] != 1) {
			view[i][j] = 1;
			if (grid[i][j] == 0) {
				fillEmpty(i + 1, j);
				fillEmpty(i, j + 1);
				fillEmpty(i - 1, j);
				fillEmpty(i, j - 1);
				fillEmpty(i + 1, j + 1);
				fillEmpty(i + 1, j - 1);
				fillEmpty(i - 1, j + 1);
				fillEmpty(i - 1, j - 1);
			}
		}

	}

	public void turn(int i, int j) {
		fillEmpty(i, j);
		checkStatus();
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				if (grid[i][j] == -1) {
					s += "*";
				} else {
					s += " ";
				}
			}
			s += "\n";
		}
		return s;
	}

	// Reads in array data from a simple text file containing asterisks (*)
	public void readData(String filename, int[][] gameData) {
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
					for (int i = 0; i < line.length(); i++)
						if (count < gameData.length && i < gameData[count].length && line.charAt(i) == '*')
							gameData[count][i] = -1;

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

	/*
	 * Grid Value Key: -1 - Bomb 0 - Blank
	 * 
	 * 1 - Blue 2 - Green 3 - Red 4 - Purple 5 - Black 6 - Maroon 7 - Gray 8 -
	 * Turquoise 9 - marked
	 * 
	 * 
	 * View Value Key: 1 - Visible 0 - Covered -1 - Marked
	 */
	public void draw(PApplet marker, float x, float y, float width, float height) {
		float cellWidth = width / gameSize;
		float cellHeight = height / gameSize;
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {

				char c = 0;
				if (gameOver) {
					view[i][j] = 1;
				}
				if (view[i][j] == 1) {
					marker.fill(255);
					marker.rect(x + j * cellWidth, y + i * cellWidth, cellHeight, cellWidth);
					if (grid[i][j] == -1) {
						marker.image(marker.loadImage("mine.png"), x + j * cellWidth, y + i * cellWidth, cellWidth,
								cellWidth);
					}
					if (grid[i][j] == 0) {
						marker.fill(255);
					}
					if (grid[i][j] == 1) {
						marker.fill(0, 0, 255);
						c = '1';
					}
					if (grid[i][j] == 2) {
						marker.fill(0, 255, 0);
						c = '2';
					}
					if (grid[i][j] == 3) {
						marker.fill(255, 0, 0);
						c = '3';
					}
					if (grid[i][j] == 4) {
						marker.fill(255, 0, 255);
						c = '4';
					}
					if (grid[i][j] == 5) {
						marker.fill(185);
						c = '5';
					}
					if (grid[i][j] == 6) {
						marker.fill(128, 0, 0);
						c = '6';
					}
					if (grid[i][j] == 7) {
						marker.fill(80);
						c = '7';
					}
					if (grid[i][j] == 8) {
						marker.fill(64, 224, 208);
						c = '8';
					}
				} else {
					marker.fill(140);
					marker.rect(x + j * cellWidth, y + i * cellWidth, cellHeight, cellWidth);
				}
				if (view[i][j] == 1 && grid[i][j] != 0 && grid[i][j] != -1) {
					marker.text(c, x + j * cellWidth + (cellWidth / 2), y + (i + 1) * cellWidth - (cellWidth / 2));
				}

				if (view[i][j] == -1) {
					marker.image(marker.loadImage("flag.png"), x + j * cellWidth, y + i * cellWidth, cellWidth,
							cellWidth);
				}
			}
		}
	}

	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		if (p.getX() > width || p.getY() > height) {
			return null;
		}
		float cellWidth = (width / gameSize);
		float cellHeight = (height / gameSize);
		return new Point((int) ((p.getY() + y) / cellHeight), (int) ((p.getX() + x) / cellWidth));
	}

	public int getTotalBombs() {
		return bombs;
	}

	public int getRemainingBombs() {
		int bomb = getTotalBombs();
		for (int i = 0; i < gameSize; i++) {
			for (int j = 0; j < gameSize; j++) {
				if (view[i][j] == -1) {
					bomb--;
				}
			}
		}
		return bomb;
	}

	public void toggleMark(int i, int j) {
		if (view[i][j] == 0) {
			if (getRemainingBombs() > 0) {
				view[i][j] = -1;
			} else {
				JOptionPane.showMessageDialog(null, "You are out of flags!");
			}
		} else if (view[i][j] == -1) {
			view[i][j] = 0;
		}
		checkStatus();
	}

	public void checkStatus() {
		int point = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (view[i][j] == 1 && grid[i][j] == -1) {
					JOptionPane.showMessageDialog(null, "You landed on a mine!");
					gameOver = true;
				}
				if (view[i][j] == -1 && grid[i][j] == -1) {
					point++;
				}
			}
		}
		if (point == getTotalBombs()) {
			JOptionPane.showMessageDialog(null, "You located all the mines!");
			gameOver = true;

		}

	}

	public boolean gameOver() {
		return gameOver;
	}
}