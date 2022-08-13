
public class Tester {

	public static void main(String args[]) {
		
//		Erase e = new Erase("Data\\Erase\\digital.txt");
//		e.eraseObject(1, 3);
//		Maze m = new Maze("Data\\Maze\\test6.txt");
//		System.out.println(m.solve());
//		System.out.println(m.toString());
		
		Labyrinth l = new Labyrinth("Data\\Labyrinth\\test2.txt");
		System.out.println(l.findPath());
		System.out.println(l.getSteps());
		System.out.println(l.toString());
		
	}
}
