import java.util.ArrayList;

public class MovieLensCSVTranslator {

	public Movie translateMovie(String line) {
		String name;
		int id;
		int year;
		ArrayList<String> genres;

		// Movie ID
		id = Integer.parseInt(line.substring(0, line.indexOf(',')));

		// Genres
		
		genres = new ArrayList<String>();

		String gen = line.substring(line.lastIndexOf(',') + 1);

		if (gen.trim().equals("(no genres listed)")) {
			//Do nothing
		} else {
			int start = 0;
			int end = 0;
			while (true) {
				if (gen.indexOf('|', end) == -1) {
					genres.add(gen.substring(gen.lastIndexOf('|') + 1));
					break;
				}
				genres.add(gen.substring(start, gen.indexOf('|', end)));
				start = gen.indexOf('|', end) + 1;
				end = gen.indexOf('|', end) + 1;
			}
		}

		int name1 = line.indexOf(',') + 1;
		int name2 = line.lastIndexOf(',');

		String title = line.substring(name1, name2).trim();

		// Name
		if (title.lastIndexOf('(') == -1) {
			name = title.substring(0, title.length()).trim();
		} else {
			name = title.substring(0, title.lastIndexOf('(')).trim();
		}

		if ((title.charAt(title.length() - 1) == '\"')) {
			name += "\"";
		}

		// Year
		int startP = title.lastIndexOf('(');
		// int endP = title.lastIndexOf(')');

		if (!Character.isDigit(title.charAt(startP + 1))) {
			year = -1;
		} else {
			year = Integer.parseInt(title.substring(startP + 1, startP + 5));
		}

		return new Movie(name, id, year, genres);

	}

	public Tag translateTag(String line) {

		// User Id
		String user = line.substring(0, line.indexOf(','));
		line = line.substring(line.indexOf(',') + 1);

		// Movie Id
		String movie = line.substring(0, line.indexOf(','));
		line = line.substring(line.indexOf(',') + 1);

		// Tag
		String tag = line.substring(0, line.indexOf(','));
		line = line.substring(line.indexOf(',') + 1);

		// Timestamp
		String time = line;

		return new Tag(Integer.parseInt(user), Integer.parseInt(movie), tag, Integer.parseInt(time));
	}

	public Rating translateRating(String line) {
		// User Id
		String user = line.substring(0, line.indexOf(','));
		line = line.substring(line.indexOf(',') + 1);

		// Movie Id
		String movie = line.substring(0, line.indexOf(','));
		line = line.substring(line.indexOf(',') + 1);

		// Rating
		String rating = line.substring(0, line.indexOf(','));
		line = line.substring(line.indexOf(',') + 1);

		// Timestamp
		String time = line;

		return new Rating(Integer.parseInt(user), Integer.parseInt(movie), Double.parseDouble(rating),
				Integer.parseInt(time));
	}

	public Link translateLink(String line) {
		int id = Integer.parseInt(line.substring(0, line.indexOf(',')));

		String imd = line.substring(line.indexOf(',') + 1, line.lastIndexOf(','));

		String tmd = line.substring(line.lastIndexOf(',') + 1);
		
		return new Link(id, imd, tmd);
	}
}
