import processing.core.PApplet;

public class KochSnowflake {

	private KochCurve a;
	private KochCurve b;
	private KochCurve c;
	
	public KochSnowflake(int x, int y, int level, int length) {
		a = new KochCurve(level, length, x + length , y + length , Math.PI);
		b = new KochCurve(level, length, x, y + length, Math.PI / 3);
		c = new KochCurve(level, length, x + (int)(length * Math.cos(Math.PI / 3)), y - (int)(length * Math.sin(Math.PI / 3)) + length, 5 * Math.PI / 3);
	}
	
	public void draw(PApplet marker) {
		a.draw(marker);
		b.draw(marker);
		c.draw(marker);
	}
	
}
