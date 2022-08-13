package edboy.shapes;

/*
 * + cohesive, only has things all shapes have
 * + adding Shape2D makes inheritance better
 * 
 * - draw() doesn't use the stroke and strokeWeight fields
 * - Line doesn't extend anything
 * 
 * delta make draw not abstract, use stroke and strokeWeight in it
 * delta make Line extend Shape
 */

import processing.core.PApplet;

/**
 * A superclass for all shape objects
 */
public abstract class Shape {

	/**
	 * X cord of the shape's creation point
	 */
	protected double x;
	
	/**
	 * Y cord of the shape's creation point
	 */
	protected double y;
	
	/**
	 * The stroke color on a gray scale
	 */
	protected int stroke;
	
	/**
	 * The thickness of the lines drawn
	 */
	protected int strokeWeight;
	
	/**
	 * Creates a shape object along with setting its thickness and outline color
	 * @param x x the starting x cord of the shape
	 * @param y y the starting x cord of the shape
	 * @param stroke sets the stroke color on a gray scale
	 * @param strokeWeight the thickness of the lines
	 */
	public Shape(double x, double y, int stroke, int strokeWeight) {
		this.x = x;
		this.y = y;
		this.stroke = stroke;
		this.strokeWeight = strokeWeight;
	}
	
	/**
	 * Creates a shape object abd sets thickness and outline color to 0
	 * @param x x the starting x cord of the shape
	 * @param y y the starting x cord of the shape
	 */
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
		stroke = 0;
		strokeWeight = 0;
	}
	
	/**
	 * Changes the starting point coordinates
	 * @param x the new x cord of the shape you want to set
	 * @param y the new y cord of the shape you want to set
	 */
	public void move(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return Returns the x field
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * @return Returns the y field
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * @return Sets the x field
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * @return Sets the y field
	 */
	public void setX(double x) {
		this.y = x;
	}
	
	/**
	 * Draws the object using the PApplet drawer object
	 * @param drawer the PApplet used to draw the shape
	 */
	public abstract void draw(PApplet drawer);
	
}
