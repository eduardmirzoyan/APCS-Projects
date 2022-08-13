
public class Rating implements Comparable<Rating>{

	private int timeStamp;
	private int movieId;
	private int userId;
	private double ratings;
	
	public Rating(int user, int movie) {
		userId = user;
		movieId = movie;
	}
	
	public Rating(int user, int movie, double rating, int time) {
		userId = user;
		movieId = movie;
		ratings = rating;
		timeStamp = time;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public double getRating() {
		return ratings;
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public String toString() {
		return userId + " " + movieId + " " + ratings + " " + timeStamp;
	}

	public int compareTo(Rating r) {
		int i = userId - r.getUserId();
		if(i == 0) {
			return movieId - r.getMovieId();
		}
		return i;
	}
}
