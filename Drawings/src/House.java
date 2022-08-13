import java.awt.Color;

import processing.core.PApplet;


public class House {
	
	private int xloc, yloc;
	private float size;	
	private Line ldoor;
	private Line tdoor;
	private Line rdoor;
	private boolean highlight;
	private boolean indoors;
	
	public House() {
		xloc = 0;
		yloc =  0;
		size = 1;
		
		ldoor = new Line(175 + xloc, 175 + yloc, 175 + xloc, 250 + yloc);
		rdoor = new Line(225 + xloc, 175 + yloc, 225 + xloc, 250 + yloc);
		tdoor = new Line(175 + xloc, 175 + yloc, 225 + xloc, 175 + yloc);
	}
	
	public House(int x, int y, float size) {
		xloc = x;
		yloc =  y;
		this.size = size;
		
		ldoor = new Line(175, 175, 175, 225);
	}
	
	public void moveHouse(int x, int y) {
		xloc = x;
		yloc = y;
		
		ldoor = new Line(xloc - 25, 50 + yloc ,  xloc - 25, yloc + 125);
		rdoor = new Line(xloc + 25, 50 + yloc ,  xloc + 25 , yloc + 125);
		tdoor = new Line(xloc - 25, 50 + yloc, xloc + 25, 50 + yloc);
	}
	
	public void bigger(PApplet drawer) {
		this.size += .1;
	}
	
	public void smaller(PApplet drawer) {
		this.size -= .1;
		if(size <= .1) {
			size = (float) .1;
		}
	}
	
	public void center() {
		xloc = 200;
		yloc = 125;
	}
	
	public Line getLdoor() {
		return ldoor;
	}
	
	public Line getRdoor() {
		return rdoor;
	}
	
	public Line getTdoor() {
		return tdoor;
	}
	
	public void touch(boolean touch) {
		highlight = touch;
	}
	
	public void setIndoors(boolean state) {
		indoors = state;
	}
	
	public boolean getIndoors() {
		return indoors;
	}
	
	public void drawHouse(PApplet drawer) {
		drawer.pushMatrix();
		drawer.translate(xloc, yloc);
		drawer.scale(size);
		drawer.translate(-200, -125);
		drawer.rect(50, 100, 300, 150); //house base
		drawer.triangle(50, 100, 200, 50, 350, 100); //roof
		
		if(highlight == true) {
			drawer.fill(125);
			drawer.stroke(125);
		}
		else {
			drawer.stroke(0);
		}
		drawer.rect(175, 175, 50, 75); //door
		drawer.noFill();
		drawer.stroke(0);
		
		if(indoors) {
			drawer.stroke(0);
		}
		else {
			drawer.stroke(255);
		}
		drawer.ellipse(100, 150, 50, 50); //Head in window
		drawer.stroke(0);
		
		drawer.rect(75, 125, 50, 50); //left window
		drawer.rect(275, 125, 50, 50); //right window
		
		drawer.popMatrix();
		
//		drawer.stroke(125);
//		ldoor.draw(drawer);
//		rdoor.draw(drawer); //Not used
//		tdoor.draw(drawer); //Not used
//		drawer.stroke(0);
		
	}

}
