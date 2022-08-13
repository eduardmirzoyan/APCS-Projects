import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet {

	private MineSweeper board;
	private int gameSize;
	private int mines;

	public DrawingSurface() {
		setField();
	}

	public void setField() {
		Object[] options = { "Easy", "Medium", "Hard" };
		int choice = JOptionPane.showOptionDialog(frame, "What difficulty would you like?", "Main Menu",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
		if (choice == JOptionPane.CLOSED_OPTION) {
			System.exit(0);
		}
		if (choice == 0) {
			gameSize = 10;
			mines = 10;
		} else if (choice == 1) {
			gameSize = 15;
			mines = 15;
		} else {
			gameSize = 20;
			mines = 50;
		}
		board = new MineSweeper(gameSize, mines);
	}

	public void draw() {
		background(255);
		fill(0);
		textAlign(LEFT);
		textSize(12);

		text("Welcome to Minesweeper!\nBombs Left: " + board.getRemainingBombs()
				+ "\nLeft click to reveal tiles\nRight click to un/mark tiles\nPress R to reset", height + 20, 30);

		if (board != null) {
			textAlign(CENTER, CENTER);
			textSize(20);
			board.draw(this, 0, 0, height, height);
		}

	}

	public void mousePressed() {
		if (!board.gameOver()) {
			if (mouseButton == LEFT) {
				Point click = new Point(mouseX, mouseY);
				float dimension = height;
				Point cellCoord = board.clickToIndex(click, 0, 0, dimension, dimension);
				if (cellCoord != null) {
					board.turn(cellCoord.x, cellCoord.y);

				}
			}
			if (mouseButton == RIGHT) {
				Point click = new Point(mouseX, mouseY);
				float dimension = height;
				Point cellCoord = board.clickToIndex(click, 0, 0, dimension, dimension);
				if (cellCoord != null) {
					board.toggleMark(cellCoord.x, cellCoord.y);

				}
			}

		}
	}

	public void keyPressed() {
		if (keyCode == KeyEvent.VK_R) {
			int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset the game?", "Confirmation",
					JOptionPane.OK_CANCEL_OPTION);
			if (i == 0)
				setField();
		}
	}
}
