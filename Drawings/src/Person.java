import processing.core.PApplet;

public class Person {

	private int xloc;
	private int yloc;
	private float size;
	
	private Line hitbox1;
	private Line hitbox2;

	public Person() {
		xloc = 0;
		yloc =  0;
		size = 1;
		
		hitbox1 = new Line(20, 270, 70, 95);
		hitbox2 = new Line(20, 95, 70 , 270);
	}
	
	public void bigger(PApplet drawer) {
		size += .1;
	}
	
	public void smaller(PApplet drawer) {
		size -= .1;
		if(size <= .1) {
			size = (float) .1;
		}
	}
	
	public void moveRight() {
		xloc += 10;
		hitbox1 = new Line(xloc - 30, 270, 70 + xloc - 50, 95);
		hitbox2 = new Line(xloc - 30, 95, 70 + xloc - 50, 270);
	}
	
	public void moveLeft() {
		xloc -= 10;
		if(xloc <= 0) {
			xloc = 0;
		}
		hitbox1 = new Line(xloc - 30, 270, 70 + xloc - 50, 95);
		hitbox2 = new Line(xloc - 30, 95, 70 + xloc - 50, 270);
	}
	
	public void center() {
		xloc = 50;
		yloc = 175;
	}
	
	public void center(int x, int y) {
		xloc = x;
		yloc = y;
	}
	
	public Line getHitbox1() {
		return hitbox1;
	}
	
	public Line getHitbox2() {
		return hitbox2;
	}
	
	
	public void drawPerson(PApplet drawer) {
		drawer.pushMatrix();
		drawer.translate(xloc, yloc);
		drawer.scale(size);
		drawer.translate(-50, -100);
		drawer.ellipse(45, 45, 50, 50); //Head
		drawer.line(45, 70, 45, 150); //Body
		drawer.line(20, 100, 70, 100); //Arms
		drawer.line(45, 150, 70, 195); //Right Leg
		drawer.line(45, 150, 20, 195); //Left Leg
		drawer.stroke(0);
		drawer.popMatrix();
		
		//hitbox2.draw(drawer); //Top left to bottom right
		//hitbox1.draw(drawer); //Bottom left to top right
	}
}
