
public class Tester {

	public static void main(String[] args) {
		Life board = new Life("data\\life tester.txt");
		System.out.println(board);
		board.step();
		System.out.println(board);
	}
}
