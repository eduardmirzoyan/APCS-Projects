package edboy.drawings.tester;

import edboy.shapes.*;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	RegularPolygon r;
	int x = 8;
	
	public void draw() {
		background(255);
		
		r = new RegularPolygon(200,200,x,50);
		r.draw(this);
		
		System.out.println(r.getArea());
		System.out.println(r.getPerimeter());
	}
	
	public void mouseClicked() {
		if(mouseButton == LEFT) {
			x++;
		}
		if(mouseButton == RIGHT) {
			x--;
		}
	}
}
