package edboy.shapes;

import processing.core.PApplet;

/**
 * Creates a polygon object that can be manipulated or checked if something is inside of it
 */
public class RegularPolygon extends Shape2D{

	private int vertices;
	private double sideLength;
	
	/**
	 * Creates a polygon object at point 200,200 with 3 sides and a side length of 100 px
	 */
	public RegularPolygon() {
		super(200,200);
		vertices = 3;
		sideLength = 100;
	}
	
	/**
	 * Creates a polygon object
	 * @param x x-cord of center
	 * @param y y-cord of center
	 * @param numSides number of vertices or sides of the polygon
	 * @param sideLength the length of each side
	 */
	public RegularPolygon(double x, double y, int numSides, double sideLength) {
		super(x,y);
		vertices = numSides;
		this.sideLength = sideLength;
	}

	/**
	 * @return returns the radius of the interior of the polygon
	 */
	public double getr() {
		return .5 * sideLength * (1 / Math.tan(Math.PI/vertices));
	}
	
	/**
	 * @return returns the radius of the exterior of the polygon
	 */
	public double getR() {
		return .5 * sideLength * (1 / Math.sin(Math.PI/vertices));
	}
	
	/**
	 * @return returns the interior angle at each vertex
	 */
	public double getVertexAngle() {
		return ((vertices - 2)/(double)vertices) * 180;
	}
	
	/**
	 * @return returns the number of sides
	 */
	public int getNumSides() {
		return vertices;
	}

	/**
	 * @return returns the perimeter of the polygon
	 */
	public double getPerimeter() {
		return vertices*sideLength;
	}

	/**
	 * @return returns the area of the polygon
	 */
	public double getArea() {
		return .5 * vertices * (getR()*getR()) * Math.sin((2 * Math.PI) / vertices);
	}

	/**
	 * Converts degrees to radians
	 * @param angdeg degree amount
	 * @return returns the degrees converted to radians
	 */
	public static double toRadians(double angdeg) {
		return Math.toRadians(angdeg);
	}
	
	/**
	 * @param x x-cord of test point
 	 * @param y y-cord of test point
	 * @return returns true or false depending on if the point is inside a circle made with the interior radius
	 */
	public boolean isPointInside(double x, double y) {
		if(Math.pow(x - (this.x + getr() / 2), 2) + Math.pow(y - (this.y + getr() / 2), 2)  < (getr() / 2)*(getr() / 2)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Scales the polygon, changes size
	 * @param value the value of dilation
	 */
	public void scale(int value) {
		sideLength *= value;
	}

	/**
	 * Draws polygon shape
	 * @param drawer the PApplet which the polygon is drawn on
	 */
	public void draw(PApplet drawer) {
	
		double prevx = x + getR();
		double prevy = y;
		
		for(int count = 0;count < vertices; count++) {
			Line l = new Line(prevx, prevy, (180 - getVertexAngle()/2) + count*(180 - getVertexAngle()), sideLength, true);
			prevx = l.getX2();
			prevy = l.getY2();
			l.draw(drawer);
		}
		//Gets center point of polygon
//		drawer.stroke(255,0,0);
//		drawer.point((float)x,(float)y);
//		drawer.stroke(0);
		
	}

	/**
	 * Draws a circle around the polygon using exterior radius
	 * @param drawer the PApplet which the circle is drawn on
	 */
	public void drawBoundingCircles(PApplet drawer) {
		Circle c = new Circle(x, y, getr(),10,1);
		c.fillShape(false);
		c.draw(drawer);
	}

}
