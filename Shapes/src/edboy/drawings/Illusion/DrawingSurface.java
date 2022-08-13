package edboy.drawings.Illusion;
import edboy.shapes.*;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{

//	public DrawingSurface(){
//		//nothing
//	}
	
	public void draw() {
		background(255);
		for(int count = 500; count > 50; count = count - 25) {
			Circle c = new Circle(250, 250, count);
			if(count % 2 == 0) {
				c.fillColor(0, 0, 0);
				c.draw(this);
			}
			else {
				c.fillColor(255, 255, 255);
				c.draw(this);
			}
		}
		Rectangle rect = new Rectangle(50,50,400,400,150,15);
		rect.fillShape(false);
		rect.draw(this);
	}
}
