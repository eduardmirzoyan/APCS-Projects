

import edboy.shapes.*;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
//	public void draw() {
//		background(255);
//		for(int count = 500; count > 50; count = count - 25) {
//			Circle c = new Circle(250, 250, count, 10, 1);
//			if(count % 2 == 0) {
//				c.fillColor(0, 0, 0);
//				c.draw(this);
//			}
//			else {
//				c.fillColor(255,255,255);
//				c.draw(this);
//			}
//		}
//		Rectangle rect = new Rectangle(50, 50, 400, 400, 150, 15);
//		rect.draw(this);
//	}
	
	public void draw() {
		background(150);
		for(int count = 10; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 0, 50, 50);
			r.fillColor(0, 160, 0);
			r.draw(this);
		}
		for(int count = 60; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 0, 50, 50);
			r.fillColor(255, 255, 255);
			r.draw(this);
		}
		
		
		
		for(int count = 0; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 50, 50, 50);
			r.fillColor(0, 160, 0);
			r.draw(this);
		}
		for(int count = 50; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 50, 50, 50);
			r.fillColor(255, 255, 255);
			r.draw(this);
		}
		
		
		
		for(int count = 10; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 100, 50, 50);
			r.fillColor(0, 160, 0);
			r.draw(this);
		}
		for(int count = 60; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 100, 50, 50);
			r.fillColor(255, 255, 255);
			r.draw(this);
		}
		
		
		
		for(int count = 0; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 150, 50, 50);
			r.fillColor(0, 160, 0);
			r.draw(this);
		}
		for(int count = 50; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 150, 50, 50);
			r.fillColor(255, 255, 255);
			r.draw(this);
		}
		
		
		
		
		
		for(int count = 10; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 200, 50, 50);
			r.fillColor(0, 160, 0);
			r.draw(this);
		}
		for(int count = 60; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 200, 50, 50);
			r.fillColor(255, 255, 255);
			r.draw(this);
		}
		
		
		
		for(int count = 0; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 250, 50, 50);
			r.fillColor(0, 160, 0);
			r.draw(this);
		}
		for(int count = 50; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 250, 50, 50);
			r.fillColor(255, 255, 255);
			r.draw(this);
		}
		
		
		
		
		
		for(int count = 10; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 300, 50, 50);
			r.fillColor(0, 160, 0);
			r.draw(this);
		}
		for(int count = 60; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 300, 50, 50);
			r.fillColor(255, 255, 255);
			r.draw(this);
		}
		
		
		
		for(int count = 0; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 350, 50, 50);
			r.fillColor(0, 160, 0);
			r.draw(this);
		}
		for(int count = 50; count < 500; count = count + 100) {
			Rectangle r = new Rectangle(count, 350, 50, 50);
			r.fillColor(255, 255, 255);
			r.draw(this);
		}
		
	}
}
