package test;

import java.util.ArrayList;

public class Test {

	private int[][] grid;
	ArrayList<Double> data;
	
	public Test() {
		grid = new int[3][1];
		grid[0] = new int[5];
		grid[1] = new int[7];
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				s += "*";
			}
			s += "\n";
		}
		return s;
	}
	

}
