import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import processing.core.PApplet;
import processing.event.MouseEvent;


public class DrawingSurface extends PApplet {

	private KochCurve curve;
	private KochSnowflake snowflake;
	private PythagorasTree tree;
	private int level, length, x, y;
	
	public DrawingSurface() {
		level = 1;
		length = 100;
		x = 200;
		y = 500;
		curve = new KochCurve (level,length);
		snowflake = new KochSnowflake(x, y, level, length);
		tree = new PythagorasTree(level, length, x , y);
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background
		
		textSize(12);
		fill(0);
		text("Use the mouse wheel to change length, left click to change location, and UP/DOWN keys to change level.",0,15);
		
		stroke(0);
		//curve.draw(this);
		//snowflake.draw(this);
		tree.draw(this);
	}
	
	
	public void mouseWheel(MouseEvent event) {
		  int num = event.getCount();
		  length -= num*10;
		  curve = new KochCurve(level, length);
		  snowflake = new KochSnowflake(x, y, level, length);
		  tree = new PythagorasTree(level, length, x , y);
		  
	}
	
	public void keyPressed() {
		if (keyCode == KeyEvent.VK_UP) {
			level++;
			curve = new KochCurve(level,length);
			snowflake = new KochSnowflake(x, y, level, length);
			tree = new PythagorasTree(level, length, x , y);
		} else if (keyCode == KeyEvent.VK_DOWN) {
			level--;
			curve = new KochCurve(level,length);
			snowflake = new KochSnowflake(x, y, level, length);
			tree = new PythagorasTree(level, length, x , y);

		}
	}
	
	public void mousePressed() {
			if (mouseButton == LEFT) {
				x = mouseX;
				y = mouseY;
				tree = new PythagorasTree(level, length, x , y);
			}
	}
	
	
}










