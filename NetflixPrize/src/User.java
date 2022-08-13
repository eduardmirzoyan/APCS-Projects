import java.util.ArrayList;

public class User implements Comparable<User> {

	private int id;
	private ArrayList<Movie> movies;
	private ArrayList<Tag> tags;
	private ArrayList<Rating> ratings;
	
	private ArrayList<Double> avgRating;
	
	public User() {
		avgRating = new ArrayList<Double>();
	}
	
	public User(int id) {
		this.id = id;
		avgRating = new ArrayList<Double>();
		avgRating.add((double) 0);
	}
	
	public int getUserId() {
		return id;
	}
	
//	public void addTag(Tag t) {
//		tags.add(t);
//	}
//	
//	public void addRating(Rating r) {
//		ratings.add(r);
//	}
//	
//	public void addMovie(Movie m) {
//		movies.add(m);
//	}
	
	public void addRating(double d) {
		avgRating.add(d);
	}
	
	public double getAvg() {
		double avg = 0;
		for(Double d : avgRating) {
			avg += d;
		}
		avg /= avgRating.size();
		return Math.round(avg * 2) / 2.0;
	}

	public int compareTo(User u) {
		return id - u.getUserId();
	}
}
