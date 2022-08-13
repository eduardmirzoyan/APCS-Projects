import processing.core.PApplet;

//Does not work
//Not finished

public class DragonCurve {

	private int level;
	private int length;
	private int x;
	private int y;
	private double angle;

    public DragonCurve(int level, int length) {
    	this.length = length;
    	this.level = level;
    	x = 50;
    	y = 50;
    	angle = Math.PI/2;
    }
    
    public DragonCurve(int level, int length, int x, int y) {
    	this.length = length;
    	this.level = level;
    	this.x = x;
    	this.y = y;
    	angle = 0;
    }
    
    public void draw(PApplet marker) {
    	drawDragonCurve(level, length, x, y, angle, marker);
    }

    private void drawDragonCurve(float level, float length, float x, float y, double angle, PApplet marker) {
    	marker.line(x, y, x + (float)(length * Math.cos(angle)), y - (float)(length * Math.sin(angle)));
    	if(level <= 1) {
    		
    	}
    	else {
    		drawDragonCurve(level - 1, (float)(length * .5 * Math.sqrt(2)), x + (float)(length * Math.cos(angle)), y - (float)(length * Math.sin(angle)), angle + Math.PI/2, marker);
    		//drawDragonCurve(level - 1, (float)(length * .5 * Math.sqrt(2)), x + (float)(length * Math.cos(angle)), y - (float)(length * Math.sin(angle)), angle - Math.PI/4, marker);
    	}
    		
    }
}
