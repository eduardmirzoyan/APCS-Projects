import java.util.ArrayList;

public class Movie implements Comparable<Movie> {

	private String title;
	private int id;
	private int year;
	private ArrayList<String> genres;

	private ArrayList<Double> avgRating;

	private String imdbLink;

	public Movie() {
		avgRating = new ArrayList<Double>();
	}

	public Movie(int id) {
		this.id = id;
		avgRating = new ArrayList<Double>();
	}

	public Movie(String name, int code, int yr, ArrayList<String> genre) {
		title = name;
		id = code;
		year = yr;
		genres = genre;
		avgRating = new ArrayList<Double>();
	}

	public boolean checkId(int num) {
		return (num == id) ? true : false;
	}

	public int getMovieId() {
		return id;
	}

	public String[][] addGenres(String[][] str) {
		for (String g : genres) {
			for (int i = 0; i < str.length; i++) {
				if (g.equals(str[i][0])) {
					str[i][1] = "" + (Integer.parseInt(str[i][1]) + 1);
					break;
				}
				if (str[i][0] == null) {
					str[i][0] = g;
					str[i][1] = "1";
					break;
				}
			}
		}

		return str;
	}

	public boolean containsGenre(String s) {
		for (String g : genres) {
			if (g.equals(s)) {
				return true;
			}
		}
		return false;

	}

	public String toString() {
		String s = id + " " + title + " " + year + " ";
		for (String e : genres) {
			s += e + " ";
		}
		return s;
	}

	public void addRating(double d) {
		avgRating.add(d);
	}

	public double getAvg() {
		double avg = 0;
		for (Double d : avgRating) {
			avg += d;
		}
		avg /= avgRating.size();
		return Math.round(avg * 2) / 2.0;
	}

	public String getTitle() {
		return title;
	}

	public int compareTo(Movie m) {
		return id - m.getMovieId();
	}

	public void setLink(String link) {
		imdbLink = link;
	}

	public String getLink() {
		return imdbLink;
	}

	public ArrayList<String> getGenres() {
		return genres;
	}
	
	public int getYear() {
		return year;
	}
}
