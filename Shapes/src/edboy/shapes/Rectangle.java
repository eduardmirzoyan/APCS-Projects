package edboy.shapes;
import processing.core.PApplet;

/**
 * Creates a rectangle object that can be manipulated or checked if something is inside of it
 * 
 * @author Eduard Mirzoyan
 * @version 9/26/18
 *
 */
public class Rectangle extends Shape2D {
	private double width, height;

	/**
	 * Creates a rectangle object
	 * Sets all fields to zero, makes an empty rectangle.
	 */
	public Rectangle() {
		super(0, 0);
		this.width = 0;
		this.height = 0;
	}

	/**
	 * Creates a rectangle object
	 * @param x x-cord of top left corner
	 * @param y y-cord of top left corner
	 * @param width width of rectangle
	 * @param height height of rectangle
	 */
	public Rectangle(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Creates a rectangle object
	 * @param x x-cord of top left corner
	 * @param y y-cord of top left corner
	 * @param width width of rectangle
	 * @param height height of rectangle
	 * @param stroke sets the stroke color on a gray scale
	 * @param strokeWeight the thickness of the lines
	 */
	public Rectangle(double x, double y, double width, double height, int stroke, int strokeWeight) {
		super(x, y, stroke, strokeWeight);
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Calculates and returns the perimeter of the rectangle
	 * @return the perimeter of the rectangle
	 */
	public double getPerimeter() {
		return width * 2 + height * 2;
	}

	/**
	 * Calculates and returns the area of the rectangle
	 * @return the area of the rectangle
	 */
	public double getArea() {
		return width * height;
	}

	/**
	 * Determines whether the point x,y is contained inside this rectangle
	 * @param x x-cord of the test point
	 * @param y y-cord of the test point
	 * @return true or false depending if point is inside the rectangle
	 */
	public boolean isPointInside(double x, double y) {
		if(this.x < x && this.x + width > x) {
			if(this.y < y && this.y + height > y) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Dilates the rectangle an input amount from its top left corner point
	 * @param value the factor of dilation
	 */
	public void scale(int value) {
		width *= value;
		height *= value;
	}
	
	/**
	 * Relocates the rectangle to input point
	 * @param x x-cord of new point
	 * @param y y-cord of new point
	 */
	public void translate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Draws a new instance of a Rectangle object with the left and right
	 * edges of the rectangle at x and x + width. The top and bottom edges
	 * are at y and y + height.
	 * @param drawer the PApplet used to draw the rectangle
	 * @pre marker cannot be null
	 * @post marker modified to PApplet.CORNER
	 * @post marker fill is changed to either fill or noFill
	 * @post strokeWeight value is changed
	 * @post stroke value is changed
	 */ 
	public void draw(PApplet drawer) {                                                                                                 
		drawer.pushStyle();
		if(fill) {
			drawer.fill(R,G,B);
		}
		else {
			drawer.noFill();
		}
		drawer.stroke(stroke); //150
		drawer.strokeWeight(strokeWeight); //15
		drawer.rect((float)x, (float)y, (float)width, (float)height);
		drawer.popStyle();
	}

	
}
