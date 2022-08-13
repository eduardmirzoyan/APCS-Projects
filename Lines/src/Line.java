import processing.core.PApplet;

public class Line {
	private float x1, x2, y1, y2;  
	private float px, py;
	
	public Line(double x1, double y1, double x2, double y2) {
		this.x1 = (float) x1;
		this.y1 = (float) y1;
		this.x2 = (float) x2;
		this.y2 = (float) y2;
	}
	
	public void setPoint2(double x2, double y2) {
		this.x2 = (float) x2;
		this.y2 = (float) y2;
		
	}

	public boolean intersects(Line other) {
//		double slope1 = (y2 - y1) / (x2 - x1);
//		double slope2 = (other.y2 - other.y1) / (other.x2 - other.x1);
		px = ((x1*y2 - y1*x2)*(other.x1 - other.x2) - (x1 - x2)*(other.x1*other.y2 - other.y1*other.x2)) / ((x1 - x2)*(other.y1 - other.y2) - (y1 - y2)*(other.x1 - other.x2));
		py = ((x1*y2 - y1*x2)*(other.y1 - other.y2) - (y1 - y2)*(other.x1*other.y2 - other.y1*other.x2)) / ((x1 - x2)*(other.y1 - other.y2) - (y1 - y2)*(other.x1 - other.x2));
		
		
		if(px >= Math.min(x1,x2) && px <= Math.max(x1, x2)) {
			if(px >= Math.min(other.x1,other.x2) && px <= Math.max(other.x2, other.x1)) {
				return true;
			}
			else {}
		}
		return false;
		
		
		
		//CHEATS
//		if(Line2D.linesIntersect(x1,y1,x2,y2,other.x1,other.y1,other.x2,other.y2)) {
//			return true;
//		}
//		else {
//			return false;
//		}
		
	}
	
	public void draw(PApplet drawer){
		drawer.line(x1, y1, x2, y2);
		//drawer.rect(px, py, 2, 2);
	}
}
