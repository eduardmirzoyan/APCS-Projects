import java.io.IOException;
import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		
		MovieLensCSVTranslator trans = new MovieLensCSVTranslator();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		ArrayList<Tag> tags = new ArrayList<Tag>();
		ArrayList<Rating> ratings = new ArrayList<Rating>();
		ArrayList<Link> links = new ArrayList<Link>();
		
		//Adds Movies
		
		try {
			String moviesCSV = "ml-latest-small" + FileIO.fileSep + "movies.csv";
			ArrayList<String> movieStrs = FileIO.readFile(moviesCSV);
			
			movieStrs.remove(0);
			for(String s : movieStrs) {
				Movie m = trans.translateMovie(s);
				movies.add(m);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//Adds Tags
		
		try {
			String tagsCSV = "ml-latest-small" + FileIO.fileSep + "tags.csv";
			ArrayList<String> tagsStrs = FileIO.readFile(tagsCSV);
			
			tagsStrs.remove(0);
			for(String s : tagsStrs) {
				Tag t = trans.translateTag(s);
				tags.add(t);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		// Adds Ratings

		try {
			String ratingsCSV = "ml-latest-small" + FileIO.fileSep + "ratings.csv";
			ArrayList<String> ratingsStrs = FileIO.readFile(ratingsCSV);

			ratingsStrs.remove(0);
			for (String s : ratingsStrs) {
				Rating r = trans.translateRating(s);
				ratings.add(r);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		
		// Adds Links
		
		try {
			String ratingsCSV = "ml-latest-small" + FileIO.fileSep + "links.csv";
			ArrayList<String> linksStrs = FileIO.readFile(ratingsCSV);

			linksStrs.remove(0);
			for (String s : linksStrs) {
				Link l = trans.translateLink(s);
				links.add(l);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
		
		// Adds User

//		users = new ArrayList<User>();
//		for(Rating r : ratings) {
//			for(User u : users) {
//				if(r.getUserId() != u.getUserId()) {
//					users.add(new User(r.getUserId()));
//				}
//			}
//		}

		//Prints Movies
		
		for(Movie m : movies) {
			System.out.println(m);
		}
		
		//Prints Tags
		
		for(Tag t : tags) {
			System.out.println(t);
		}

		// Prints Ratings

		for (Rating r : ratings) {
			System.out.println(r);
		}
		
		// Prints Links
		
		for (Link l : links) {
			System.out.println(l);
		}

	}

}
