import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class NetflixPredictor {

	private ArrayList<Movie> movies;
	private ArrayList<Tag> tags;
	private ArrayList<Rating> ratings;
	private ArrayList<Link> links;
	private ArrayList<User> users;

	// Add fields to represent your database.

	/**
	 * 
	 * Use the file names to read all data into some local structures.
	 * 
	 * @param movieFilePath  The full path to the movies database.
	 * @param ratingFilePath The full path to the ratings database.
	 * @param tagFilePath    The full path to the tags database.
	 * @param linkFilePath   The full path to the links database.
	 */
	public NetflixPredictor(String movieFilePath, String ratingFilePath, String tagFilePath, String linkFilePath) {
		MovieLensCSVTranslator trans = new MovieLensCSVTranslator();

		// Adds Movies

		try {
			movies = new ArrayList<Movie>();
			String moviesCSV = movieFilePath;
			ArrayList<String> movieStrs = FileIO.readFile(moviesCSV);

			movieStrs.remove(0);
			for (String s : movieStrs) {
				Movie m = trans.translateMovie(s);
				movies.add(m);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

		Collections.sort(movies);

		// Adds Tags

		try {
			tags = new ArrayList<Tag>();
			String tagsCSV = tagFilePath;
			ArrayList<String> tagsStrs = FileIO.readFile(tagsCSV);

			tagsStrs.remove(0);
			for (String s : tagsStrs) {
				Tag t = trans.translateTag(s);
				tags.add(t);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

		// Adds Ratings

		try {
			ratings = new ArrayList<Rating>();
			users = new ArrayList<User>();
			String ratingsCSV = ratingFilePath;
			ArrayList<String> ratingsStrs = FileIO.readFile(ratingsCSV);

			ratingsStrs.remove(0);
			for (String s : ratingsStrs) {
				Rating r = trans.translateRating(s);
				ratings.add(r);
				int i = Collections.binarySearch(movies, new Movie(r.getMovieId()));
				if (i < 0) {
					// Do nothing
				} else {
					movies.get(i).addRating(r.getRating());
				}

				// Add Users
				int j = Collections.binarySearch(users, new User(r.getUserId()));
				if (j < 0) {
					users.add(new User(r.getUserId()));
					users.get(Collections.binarySearch(users, new User(r.getUserId()))).addRating(r.getRating());
				} else {
					users.get(j).addRating(r.getRating());
				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

		Collections.sort(ratings);

		// Adds Links

		try {
			links = new ArrayList<Link>();
			String ratingsCSV = "ml-latest-small" + FileIO.fileSep + "links.csv";
			ArrayList<String> linksStrs = FileIO.readFile(ratingsCSV);

			linksStrs.remove(0);
			for (String s : linksStrs) {
				Link l = trans.translateLink(s);
				links.add(l);

				int i = Collections.binarySearch(movies, new Movie(l.getMovieId()));
				if (i < 0) {
					// Do nothing
				} else {
					movies.get(i).setLink(l.getIMDB());
				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber  The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does
	 *         not exist in the database, the movie does not exist, or the movie has
	 *         not been rated by this user.
	 */
	public double getRating(int userID, int movieID) {

		int d = Collections.binarySearch(ratings, new Rating(userID, movieID));

		if (d < 0) {
			return -1;
		}

		return ratings.get(d).getRating();

	}

	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other
	 * available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber  The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the
	 *         movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating(int userID, int movieID) {

		ArrayList<String> movieGenres;

		if (getRating(userID, movieID) != -1) {
			return getRating(userID, movieID);
		} else {

		}

		int i = Collections.binarySearch(movies, new Movie(movieID));
		if (i < 0) {
			return -1;
		}

//		double tagAvg = 0;
//		int tagCount = 0;
//		int e = Collections.binarySearch(tags, new Tag(userID, movieID));
//		if (e >= 0) {
//			String tag = tags.get(e).getTag();
//			for (Tag t : tags) {
//				if (t.getUserId() == userID) {
//					if (t.getTag().toLowerCase().equals(tag.toLowerCase())) {
//						int c = Collections.binarySearch(ratings, new Rating(t.getUserId(), t.getMovieId()));
//						if (c < 0) {
//							// Do nothing
//						} else {
//							tagAvg += ratings.get(c).getRating();
//							tagCount++;
//						}
//
//					}
//
//				}
//			}
//		}
		// Compare Genres of movie to user watched movies with same genre

		movieGenres = movies.get(i).getGenres();
		int count = 0;
		double genreAvg = 0;
		for (Rating r : ratings) {
			if (r.getUserId() == userID) {
				int k = Collections.binarySearch(movies, new Movie(r.getMovieId()));
				for (String s : movieGenres) {
					if (movies.get(k).getGenres().contains(s)) {
						genreAvg += r.getRating();
						count++;
					}
				}
			}
		}

		int j = Collections.binarySearch(users, new User(userID));
		if (j < 0) {
			return -1;
		}

		return round((movies.get(i).getAvg() + users.get(j).getAvg() + (genreAvg / count) * 5) / 7);
	}

	/**
	 * Recommend a movie that you think this user would enjoy (but they have not
	 * currently rated it).
	 * 
	 * @param userNumber The ID of the user.
	 * @return The ID of a movie that data suggests this user would rate highly (but
	 *         they haven't rated it currently).
	 * @pre A user with id userID exists in the database.
	 */
	public int recommendMovie(int userID) {
		for (Movie m : movies) {
			if (getRating(userID, m.getMovieId()) == -1) {
				if (guessRating(userID, m.getMovieId()) >= 4) {
					return m.getMovieId();
				}
			}
		}
		return -1;
	}

	// Rounds to nearest .5
	public double round(double d) {
		return Math.round(d * 2) / 2.0;
	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}
}
