package edboy.shapes;

import processing.core.PApplet;

/**
 * Creates a circle object that can be manipulated or checked if something is inside of it
 * 
 * @author Eduard Mirzoyan
 * @version 9/26/18
 *
 */
public class Circle extends Shape2D {
	private double radius;

	/**
	 * Creates a circle object
	 * Sets all fields to zero, makes an empty circle.
	 */
	public Circle() {
		super(0, 0);
		radius = 0;
	}

	/**
	 * Creates a circle object
	 * @param x x-cord of the center of the circle
	 * @param y y-cord of the center of the circle
	 * @param radius the radius of the circle from center
	 */
	public Circle(double x, double y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	
	public Circle(double x, double y, double radius, int stroke, int strokeWeight) {
		super(x, y, stroke, strokeWeight);
		this.radius = radius;
	}
	
	/**
	 * Calculates and returns the circumference of the circle
	 * @return the circumference of the circle
	 */
	public double getPerimeter() { 
		return 2 * radius * Math.PI;
	}

	/**
	 * Calculates and returns the area of the circle
	 * @return the area of the circle
	 */
	public double getArea() {
		return Math.PI * (radius * radius);
	}

	/**
	 * Determines whether the point x,y is contained inside this circle
	 * @param x x-cord of the test point
	 * @param y y-cord of the test point
	 * @return true or false depending if point is inside the circle
	 */
	public boolean isPointInside(double x, double y) {
		if(Math.pow(x - (this.x + radius / 2), 2) + Math.pow(y - (this.y + radius / 2), 2)  < (radius / 2)*(radius / 2)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Dilates the circle an input amount
	 * @param value the factor of dilation
	 */
	public void scale(int value) {
		radius *= value;
	}
	
	/**
	 * Relocates the circle to input point
	 * @param x x-cord of new point
	 * @param y y-cord of new point
	 */
	public void translate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Draws a new instance of a Circle object with x and y as the center
	 * and using the radius as radius of the circle
	 * @param marker the PApplet used to draw the circle
	 * @pre marker cannot be null
	 * @post marker modified to PApplet.CORNER
	 * @post marker is set to fill
	 * @post strokeWeight value is changed
	 */ 
	public void draw(PApplet drawer) {
		drawer.pushStyle();
		fillShape(false);
		if(fill) {
			drawer.fill(R,G,B);
		}
		else {
			drawer.noFill();
		}
		drawer.strokeWeight(strokeWeight); //1
		drawer.ellipseMode(2);
		drawer.ellipse((float)x, (float)y, (float)radius, (float)radius);
		drawer.popStyle();
	}




}
