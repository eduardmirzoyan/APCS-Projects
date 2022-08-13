import java.awt.geom.*;  // for Point2D.Double
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;      // for ArrayList

import edboy.shapes.*;
import processing.core.PApplet;	// for Processing

public class IrregularPolygon extends Shape {
   private ArrayList <Point2D.Double> myPolygon;
   private boolean toggle;
    
   // constructors
   public IrregularPolygon() {
	   super(0, 0);
	   toggle = true;
	   myPolygon = new ArrayList<Point2D.Double>();
	   myPolygon.add(new Point2D.Double(20,10));
	   myPolygon.add(new Point2D.Double(70,20));
	   myPolygon.add(new Point2D.Double(50,50));
	   myPolygon.add(new Point2D.Double(0,40));
   }
   
   // public methods
   public void add(Point2D.Double aPoint) {
	   myPolygon.add(aPoint);
   }
   
   public void remove(int index){
	   myPolygon.remove(index);
   }

   public void draw(PApplet marker) {
	   if(toggle) {
		   
		   for(int count = 0; count < myPolygon.size() - 1; count++) {
			   marker.line((float)myPolygon.get(count).getX(), (float)myPolygon.get(count).getY(), (float)myPolygon.get(count + 1).getX(), (float)myPolygon.get(count + 1).getY());
		   }
		   if(myPolygon.size() > 0) {
			   marker.line((float)myPolygon.get(0).getX(), (float)myPolygon.get(0).getY(), (float)myPolygon.get(myPolygon.size() - 1).getX(), (float)myPolygon.get(myPolygon.size() - 1).getY());
		   }
	   }
	   
	   
	   else {
		   for(int count = 0; count < myPolygon.size(); count++) {
			   marker.fill(0);
			   marker.ellipse((float)myPolygon.get(count).getX(), (float)myPolygon.get(count).getY(), 2, 2);
		   }  
	   }
	   
	  
	   
   }

   public double getPerimeter() {
	   double sum = 0;
	   //System.out.println(myPolygon.size());
	   if(myPolygon.size() > 0) {
		   for(int count = 0; count < myPolygon.size() - 1; count++) {
			   sum += Math.sqrt(Math.pow(myPolygon.get(count + 1).getX() - myPolygon.get(count).getX(), 2.0) + Math.pow(myPolygon.get(count + 1).getY() - myPolygon.get(count).getY(), 2.0));
			   //System.out.println("other seg: " + sum);
		   }
		   if(myPolygon.size() > 2) {
			   sum += Math.sqrt(Math.pow(myPolygon.get(0).getX() - myPolygon.get(myPolygon.size() - 1).getX(), 2.0) + Math.pow(myPolygon.get(0).getY() - myPolygon.get(myPolygon.size() - 1).getY(), 2.0));
			   //System.out.println("last seg: " + sum);
		   }
	   }
	   return sum;
	   }

   public double getArea() {
	   double area = 0;
	   if(myPolygon.size() > 2) {
		   for(int count = 0; count < myPolygon.size() - 1; count++) {
			  area += myPolygon.get(count).getX() * myPolygon.get(count + 1).getY();
		  }
		  area += myPolygon.get(myPolygon.size() - 1).getX() * myPolygon.get(0).getY();
		  for(int count = 0; count < myPolygon.size() - 1; count++) {
			  area -= myPolygon.get(count).getY() * myPolygon.get(count + 1).getX();
			  
		  	}
		  area -= myPolygon.get(myPolygon.size() - 1).getY() * myPolygon.get(0).getX();
	   }
	   area /= 2;
	   area = Math.abs(area);
	   return area;
	}
   
   public int getSize() {
	   return myPolygon.size();
   }
   
   public void toggle() {
	   if(toggle) {
		   toggle = false;
	   }
	   else {
		   toggle = true;
	   }
   }
}
