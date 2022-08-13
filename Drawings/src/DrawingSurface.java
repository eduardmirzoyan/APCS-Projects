import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

/*
 * Name: Eduard Mirzoyan
 * Period: 6
 * Mr. Shelby
 * 
 * Overview: A person that move in the x direction can go inside the house if he's infront of the door
 * Person can't move while hes inside the house.
 * 
 * Controls: Use left/right arrows to move house, and up/down to scale the person (person hitbox doesn't scale)
 * Used W/S to scale house and mouse to relocate house. While the person is infront of the door (door turns gray), 
 * Use 'e' to enter/exit the house, you can
*/


public class DrawingSurface extends PApplet {
	
	/*
	 * +: I like the door features when entering and exiting the house
	 * +: The house and person size and move correctly, the door works for sizing too
	 * 
	 * - if you put the person in the house and then move the house with the person inside,
	 * if you press exit the person spawns where the house previously was.
	 * - the person gets too large..... getting in the door is strange
	 * 
	 * delta: I would before re-drawing the person translate the coordinates (use a variable to keep track)
	 * so it will redraw at the house door
	 * delta: I would make a limit for the size scale (maybe do a loop to check)
	 * 
	 */
	
	private House house;
	private Person person;
	
	public DrawingSurface() {
		house = new House();
		person = new Person();
		house.center();
		person.center();
	}
	
	public void draw() { 
		background(255);   // Set the background to black
		house.drawHouse(this);
		if(house.getIndoors()) {
			//Do nothing
		}
		else {
			person.drawPerson(this);
		}
		fill(0);
		textSize(10);
		text("Instructions: Use arrow keys for person and 'e' to enter/exit house (use 'W'/'S' to scale house)",10,10);
		noFill();
	}
	
	public void mousePressed() {
		house.moveHouse(mouseX, mouseY);
	}
	
	public void keyPressed() {
		if(keyCode == UP) {
			if(!house.getIndoors()) {
				person.bigger(this);
			}
		}
		if(keyCode == DOWN) {
			if(!house.getIndoors()) {
				person.smaller(this);
			}
		}
		if(keyCode == LEFT) {
			if(!house.getIndoors()) {
				person.moveLeft();
			}
			//System.out.println(person.getHitbox1().intersects(house.getTdoor())); //Checks the result of the intersection
			if(person.getHitbox1().intersects(house.getTdoor()) || person.getHitbox2().intersects(house.getTdoor())) {
				house.touch(true);
			}
			else {
				house.touch(false);
			}
		}
		if(keyCode == RIGHT) {
			if(!house.getIndoors()) {
				person.moveRight();
			}
			//System.out.println(person.getHitbox1().intersects(house.getTdoor())); //Checks the result of the intersection
			if(person.getHitbox1().intersects(house.getTdoor()) || person.getHitbox2().intersects(house.getTdoor())) {
				house.touch(true);
			}
			else {
				house.touch(false);
			}
		}
		if(key == 'e') {
			if(house.getIndoors()) {
				house.setIndoors(false);
			}
			else if(person.getHitbox1().intersects(house.getTdoor()) || person.getHitbox2().intersects(house.getTdoor())) {
				house.setIndoors(true);
				
			}
		}
		if(key == 'w') {
			house.bigger(this);
		}
		if(key == 's') {
			house.smaller(this);
		}
	}
}
