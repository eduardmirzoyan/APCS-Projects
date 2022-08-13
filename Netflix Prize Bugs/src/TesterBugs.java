import java.io.IOException;
import java.util.ArrayList;

public class TesterBugs {

	public static void main(String[] args) {
		
		MovieLensCSVTranslatorBugs translator = new MovieLensCSVTranslatorBugs();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		try {
			String moviesCSV = "ml-latest-small" + FileIO.fileSep + "movies.csv";
			ArrayList<String> movieStrs = FileIO.readFile(moviesCSV);
			
			for (String s : movieStrs) {
				Movie m = translator.translateMovie(s);
				movies.add(m);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		for (Movie m : movies) {
			System.out.println(m);
		}
		
	}

}
