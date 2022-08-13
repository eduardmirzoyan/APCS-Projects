

public class RecursionPractice {


	private static int iterations;
	
	public static int factorial(int n)
	{
		if(n == 0) { //BASE CASE
			return 1;
		}
			return n * factorial(n - 1);
	}


	public static int squareNumber(int n) {
		if(n == 1) {
			return 1;
		}
			return squareNumber(n - 1) + 2 * n - 1;
	}


	public static int logBase2(int n) {
		if(n == 1) {
			return 0;
		}
		return 1 + logBase2(n / 2);
	}


	public static int pow(int n) {
		if(n == 0) {
			return 1;
		}
		return 2 * pow(n - 1);
	}


	public static int pentagonalNumber(int n) {
		if(n == 1) {
			return 1;
		}
		return (3 * (n - 1) + 1) + pentagonalNumber(n - 1);
	}

	public static int fibonacci(int n) {
		iterations++;
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static int fibonacciLoop(int n) {
		int sum = 0;
		int prevnum = 1;
		int prev2num = 0;
		
		for(int i = 0; i <= n; i++) {
			sum = prevnum + prev2num;
			prev2num = prevnum;
			prevnum = sum;
			iterations++;
			
		}
		return sum;
	}
	
	public static void printHanoiSolution(int n) {
		solve(n,1,3);
	}
	
	private static void solve(int disk, int fromPeg, int toPeg) {
		iterations++;
		if(disk <= 1) {
			//System.out.println("Move disk from Peg " + fromPeg + " to Peg " + toPeg);
		}
		else {
			int otherPeg = 6 - (toPeg + fromPeg);
			solve(disk - 1, fromPeg, otherPeg);
			//System.out.println("Move disk from Peg " + fromPeg + " to Peg " + toPeg);
			solve(disk - 1, otherPeg, toPeg);
		}
	}
	public static int test(int n) {
		if(n < 5) {
			return n + 3;
		}
		else {
			return test(test(n - 5));
		}
	}

	public static void main(String[] args) {
		int n = 11;
		for(int i = 1;i < n; i++) {
			iterations = 0;
			printHanoiSolution(i);
			System.out.println("A " + i + " disk hanoi puzzle had " + iterations + " iterations");
		}
	}


}