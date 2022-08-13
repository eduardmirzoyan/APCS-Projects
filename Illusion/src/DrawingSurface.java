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
				c.draw(this, 0, 1);
			}
			else {
				c.draw(this, 255, 1);
			}
		}
		Rectangle rect = new Rectangle(50,50,400,400);
		rect.draw(this, false, 150, 15);
	}
}
