package testing;

import java.util.ArrayList;

public class Practice extends Tester {

	// Fields:
	int[][] b = { 	{ 1, 2, 3, 4, 5 }, 
					{ 1, 3, 4, 5, 6 },
					{ 7, 8, 4, 4, 4 },
				};

	//ArrayList<Integer> a = new ArrayList<Integer>();
	
	int[] sounds = new int[10];
	
	public void test() {

		int[] a = new int[10];
		for(int e : a) {
			
		}
		
		
		for(int[] d : b) {
			for(int e : d) {
				System.out.print(e + " ");
			}
		}
		System.out.println();
		
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j] + " ");
			}
		}
		
		
	}
	
	public int limitAplitude(int limit) {
		int count = 0;
		for(int i = 0; i < sounds.length; i++) {
			if(sounds[i] > limit) {
				sounds[i] = limit;
				count++;
			}
			else if (sounds[i] < -limit) {
				sounds[i] = -limit;
				count++;
			}
		}
		return count;
		
	}
	
}
