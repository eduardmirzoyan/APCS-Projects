import processing.core.PApplet;


/**
  @(#)KochCurve.java


  @author Eduard Mirzoyan
  @version Alpha
*/
public class KochCurve {

	private int level;
	private int length;
	private int x;
	private int y;
	private double angle;

    public KochCurve(int level, int length) {
    	this.length = length;
    	this.level = level;
    	x = 50;
    	y = 90;
    	angle = 0;
    }
    
    public KochCurve(int level, int length, int x, int y, double angle) {
    	this.length = length;
    	this.level = level;
    	this.x = x;
    	this.y = y;
    	this.angle = angle;
    }
    
    public void draw(PApplet marker) {
    	drawKochCurve(level, length, x, y, angle, marker);
    }

    private void drawKochCurve(float level, float length, float x, float y, double angle, PApplet marker) {
    	if(level <= 1) {
    		marker.line(x , y ,  x + (float)(length * Math.cos(angle)), y - (float)(length * Math.sin(angle)));
    	}
    	else {
    		length /= 3;
    		drawKochCurve(level - 1, length, x, y, angle, marker);
    		drawKochCurve(level - 1, length, (float) (x + length * Math.cos(angle)), (float) (y - length * Math.sin(angle)), (float)(angle + Math.PI / 3), marker);
    		drawKochCurve(level - 1, length, (float) (x + length * Math.cos(angle) +  length * Math.cos(angle + Math.PI / 3)), (float) (y - length * Math.sin(angle) - length * Math.sin(angle + Math.PI / 3)), (float)(angle - Math.PI / 3), marker);
    		drawKochCurve(level - 1, length, (float) (x + length * Math.cos(angle) + length * Math.cos(angle + Math.PI / 3) + length * Math.cos(angle - Math.PI / 3)), (float) (y - length * Math.sin(angle) - length * Math.sin(angle + Math.PI / 3) - length * Math.sin(angle - Math.PI / 3)), angle, marker);
    	
    	}
    }

}