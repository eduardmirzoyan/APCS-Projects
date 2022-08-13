package edboy.shapedemo;

import java.awt.geom.Point2D;
import irauenzahn053.shapes.*;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {

	private PhysicsShape object1;
	private PhysicsShape object2;
	
	private boolean object = true;
	private String text = "Rectangle";
	
	public DrawingSurface() {
		object1 = new PhysicsShape(new Rectangle(0,50,50,50));   // -------STEP 1-------
		object2 = new PhysicsShape(new Circle(250,50,25), true);
	}
	
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background
		fill(0);
		text("Use right click to change shapes and drag with left to fling:", 10, 20);
		text(text, 10, 40);
		
		object1.draw(this);
		object2.draw(this);

		object1.act();
		object2.act();
		
		
	}
	
	
	public void mouseDragged() {  // -------STEP 4------- (try dragging with the mouse after this step)
		int currentMouseX = super.mouseX;
		int currentMouseY = super.mouseY;
		
		int previousMouseX = super.pmouseX;
		int previousMouseY = super.pmouseY;
		
		int amountMovedX = currentMouseX-previousMouseX;
		int amountMovedY = currentMouseY-previousMouseY;
		
		if (mouseButton == LEFT) {
			if(object == true) {
				if(object1.isInside(currentMouseX, currentMouseY)) {
					object1.accelerate(amountMovedX, amountMovedY);
				}
			}
				if(object == false) {
					if(object2.isInside(currentMouseX, currentMouseY)) {
						object2.accelerate(Math.abs(amountMovedX), amountMovedY);
					}
			}
		}
		
		// Use any of the values above to move around the PhysicsShape in some way
	}
	
	public void mouseClicked() {
		if (mouseButton == RIGHT) {
			if(object == false) {
				object = true;
				text = "Rectangle";
				
			}
			else if(object == true) {
				object = false;
				text = "Circle";
			}
			
		}
	}
	

	
}










