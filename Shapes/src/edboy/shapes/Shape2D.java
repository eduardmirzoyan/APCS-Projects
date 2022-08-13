package edboy.shapes;

import java.awt.Color;

import processing.core.PApplet;

/**
 * A shape superclass for only 2D shapes
 */
public abstract class Shape2D extends Shape {

	/**
	 * True or false depending on if you want to fill the object
	 */
	protected boolean fill;
	
	/**
	 * The RGB values for coloring shapes
	 */
	protected int R, G, B;
	
	/**
	 * Creates a 2D shape while setting all its fields to 0 and fill is set to true
	 * @param x the starting x cord of the shape
	 * @param y the starting y cord of the shape
	 */
	public Shape2D(double x, double y) {
		super(x, y);
		fill = true;
		R = 0;
		G = 0;
		B = 0;
	}
	
	/**
	 * Creates a 2D shape while setting all its fields to 0 and fill is set to true
	 * @param x the starting x cord of the shape
	 * @param y the starting y cord of the shape
	 * @param stroke sets the stroke color on a gray scale
	 * @param strokeWeight the thickness of the lines
	 */
	public Shape2D(double x, double y, int stroke, int strokeWeight) {
		super(x, y, stroke, strokeWeight);
		fill = true;
		R = 0;
		G = 0;
		B = 0;
	}

	/**
	 * Sets the object's fill field
	 * @param fill true or false depending if you want to fill in the shape
	 */
	public void fillShape(boolean fill) {
		this.fill = fill;
	}
	
	/**
	 * Sets the fill color of the object
	 * @param red sets the rgb value of red
	 * @param green sets the rgb value of green
	 * @param blue sets the rgb value of blue
	 * @pre fill field has to be true to see
	 */
	public void fillColor(int red, int green, int blue) {
			R = red;
			G = green;
			B = blue;
	}
	
	/**
	 * @return Returns the perimeter of the shape
	 */
	public abstract double getPerimeter();
	  
	/**
	 * @return Returns the area of the shape
	 */
	public abstract double getArea();
	
	/**
	 * Checks if input point is inside the shape
	 * @param x the x cord of the check point
	 * @param y the y cord of the check point
	 * @return true or false depending on if the point is inside the shape
	 */
	public abstract boolean isPointInside(double x, double y);
	 
	/**
	 * Scales the object from its top left corner
	 * @param value the multiplier of scaling
	 */
	public abstract void scale(int value);
	
}
