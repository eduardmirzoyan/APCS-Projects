package edboy.shapedemo;

import irauenzahn053.shapes.*;
import processing.core.PApplet;

public class PhysicsShape {

	private AreaShape s;   // If your library has 2 levels of inheritance, could change this to be 1 level down (A 2D Shape rather than a Shape)
	
	private double vx, vy;
	
	private int height;
	private int width;
	
	private boolean circle;
	
	public PhysicsShape(AreaShape s) {
		this.s = s;
		circle = false;
		vx = 2;
		vy = 2;
		
	}
	
	public PhysicsShape(AreaShape s, boolean circle) {
		this.s = s;
		this.circle = circle;
		vx = -2;
		vy = 2;
	}
	
	
	public void draw(PApplet drawer) {   // -------STEP 2-------   (after this, see if your shape is visible)
		// Add code to call draw on your Shape s. Probably like this:
		height = drawer.height;
		width = drawer.width;
		s.setFill(true);
		if(circle) {
			s.setStrokeWeight(3);
			s.setFill(255, 255, 255);
		}
		else {
			s.setFill(0, 0, 0);
		}
		
		s.draw(drawer);
		
	}
	
	
	// Call this method at the end of your draw() method in DrawingSurface to make your PhysicsShapes move.
	public void act() {  // -------STEP 3-------
		
		//Gravity
		vy += 0.1;

		//Friction
		vx /= 1.01;
		
		//Checks bounds to make sure its in window, and slows down if bounce
		if(circle) {
			if(s.getY1() + 25 + vy > height) {
				
				vy = -(vy / 1.5);
			}
			
			if(s.getY1() - 25 + vy < 0) {
				
				vy = -(vy);
			}
			
			if(s.getX1() + 25 + vx > width) {
				
				vx = -(vx);
			}
			
			if(s.getX1() - 25 + vx < 0) {
				
				vx = -(vx);
			}
		}
		else {
			if(s.getY1() + 50 + vy > height) {
				
				vy = -(vy / 1.5);
			}
			
			if(s.getY1() + vy < 0) {
				
				vy = -(vy);
			}
			
			if(s.getX1() + vx + 50 > width) {
				
				vx = -(vx);
			}
			
			if(s.getX1() + vx < 0) {
				
				vx = -(vx);
			}
		}
		
		
		//Moves object and stops it if its going too slow
		if(Math.abs(vy) < 0.05) {
			vy = 0;
			
		}
		if(Math.abs(vx) < 0.05) {
			vx = 0;
			
		}
		moveBy(vx,vy);
		
//		Testers:
//		if(!circle) {
//			System.out.println("vy =" + vy);
//			System.out.println("vx =" + vx);
//			System.out.println();
//			System.out.println(s.getY1() + 50);
//		}
		
	}
	
	
	public void moveBy(double x, double y) {
		s.moveBy(x, y);
		
	}
	
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	public void accelerate(double ax, double ay) {
		vx += ax;
		vy += ay;
	}
	
	public void isCircle(boolean answer) {
		circle = answer;
	}
	
	public double getX() {
		return s.getX1();
	}
	
	public double getY() {
		return s.getY1();
	}
	
	public boolean isInside(int x, int y) {
		return s.isPointInside(x, y);
	}
	
	
}
