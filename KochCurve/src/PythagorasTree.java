import processing.core.PApplet;

public class PythagorasTree {

	private int level;
	private int length;
	private int x;
	private int y;
	private double angle;

    public PythagorasTree(int level, int length) {
    	this.length = length;
    	this.level = level;
    	x = 200;
    	y = 500;
    	angle = Math.PI/2;
    }
    
    public PythagorasTree(int level, int length, int x, int y) {
    	this.length = length;
    	this.level = level;
    	this.x = x;
    	this.y = y;
    	angle = Math.PI/2;
    }
    
    public void draw(PApplet marker) {
    	drawPythagorasTree(level, length, x, y, angle, marker);
    }

    private void drawPythagorasTree(float level, float length, float x, float y, double angle, PApplet marker) {
    	marker.line(x, y, x + (float)(length * Math.cos(angle)), y - (float)(length * Math.sin(angle)));
    	if(level > 1) {
    		drawPythagorasTree(level - 1, (float)(length * .5 * Math.sqrt(2)), x + (float)(length * Math.cos(angle)), y - (float)(length * Math.sin(angle)), angle + Math.PI/4, marker);
    		drawPythagorasTree(level - 1, (float)(length * .5 * Math.sqrt(2)), x + (float)(length * Math.cos(angle)), y - (float)(length * Math.sin(angle)), angle - Math.PI/4, marker);
    	}
    }
}
