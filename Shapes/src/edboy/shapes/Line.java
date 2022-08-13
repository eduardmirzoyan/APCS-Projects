package edboy.shapes;

import processing.core.PApplet;
/**
 * Creates a line object that can be manipulated and checked if it intersects another line
 * 
 * @author Eduard Mirzoyan
 * @version 9/26/18
 *
 */
public class Line extends Shape{
	private float x2, y2;  
	private float px;
	private int R, G, B;
	
	/**
	 * Creates a line object by using 2 points
	 * @param x1 x-cord of first point
	 * @param y1 y-cord of first point
	 * @param x2 x-cord of second point
	 * @param y2 y-cord of second point
	 */
	public Line(double x1, double y1, double x2, double y2) {
		super(x1, x2);
		this.x2 = (float) x2;
		this.y2 = (float) y2;
	}
	
	/**
	 * Creates a line object using a point, angle and line length
	 * @param x the x-cord of the start point
	 * @param y the y-cord of the start point
	 * @param angle the angle from the positive horizontal
	 * @param distance length of line from point in pixels
	 * @param type true if it is a degree/distance line
	 */
	public Line(double x, double y, double angle, double distance, boolean type) {
		super(x, y);
		if(type) {
			angle = Math.toRadians(angle);
			y2 = ((float)this.y - (float)(Math.sin(angle)*distance));
			x2 = (float)(Math.cos(angle)*distance) + (float)this.x;
		}
		else {
			//Do nothing
		}
		
	}
	
	/**
	 * Creates a line object by connecting 2 points and changes its color on a gray scale and width
	 * @param x1 x-cord of first point
	 * @param y1 y-cord of first point
	 * @param x2 x-cord of second point
	 * @param y2 y-cord of second point
	 */
	public Line(double x1, double y1, double x2, double y2, int stroke, int strokeWeight) {
		super(x1, x2, stroke, strokeWeight);
		this.x2 = (float) x2;
		this.y2 = (float) y2;
	}
	
	/**
	 * Sets one of the line's points
	 * @param x2 x-cord of new point
	 * @param y2 y-cord of new point
	 */
	public void setPoint2(double x2, double y2) {
		this.x2 = (float) x2;
		this.y2 = (float) y2;
	}

	/**
	 * Checks if 2 lines intersect by checking by creating and checking if a intersection 
	 * point is on a line object
	 * @param other the line object that is being checked if there is an intersection
	 * @return returns true or false depending if there's an intersection
	 */
	public boolean intersects(Line other) {
		px = (float) (((x*y2 - y*x2)*(other.x - other.x2) - (x - x2)*(other.x*other.y2 - other.y*other.x2)) / ((x - x2)*(other.y - other.y2) - (y - y2)*(other.x - other.x2)));
		//py = ((x1*y2 - y1*x2)*(other.y1 - other.y2) - (y1 - y2)*(other.x1*other.y2 - other.y1*other.x2)) / ((x1 - x2)*(other.y1 - other.y2) - (y1 - y2)*(other.x1 - other.x2));
		
		
		if(px >= Math.min(x,x2) && px <= Math.max(x, x2)) {
			if(px >= Math.min(other.x,other.x2) && px <= Math.max(other.x2, other.x)) {
				return true;
			}
			else {}
		}
		return false;
		
		//CHEATS
//		if(Line2D.linesIntersect(x1,y1,x2,y2,other.x1,other.y1,other.x2,other.y2)) {
//			return true;
//		}
//		else {
//			return false;
//		}
	}
	
	/**
	 * 
	 * @return Returns the x-cord of end point
	 */
	public double getX2() {
		return x2;
	}
	
	/**
	 * 
	 * @return Returns the y-cord of end point
	 */
	public double getY2() {
		return y2;
	}
	
	/**
	 * Sets the color of the line using RGB values
	 * @param r sets the rgb value of red
	 * @param g sets the rgb value of green
	 * @param b sets the rgb value of blue
	 */
	public void lineColor(int r, int g, int b) {
		R = r;
		G = g;
		B = b;
	}
	
	/**
	 * Sets the color of the line
	 * @param drawer the PApplet used to draw the line
	 */
	public void colorLine(PApplet drawer) {
		drawer.stroke(R, G, B);
	}
	
	/**
	 * Draws the line object on PApplet
	 * @param drawer the PApplet used to draw the line
	 * @pre drawer cannot be null
	 */
	public void draw(PApplet drawer){
		drawer.line((float)x, (float)y, x2, y2);
	}

}
