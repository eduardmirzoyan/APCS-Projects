
public class Tag implements Comparable<Tag>{

	private int timeStamp;
	private int movieId;
	private int userId;
	private String tags;
	
	public Tag(int user, int movie) {
		userId = user;
		movieId = movie;
	}
	
	public Tag(int user, int movie, String tag, int time) {
		userId = user;
		movieId = movie;
		tags = tag;
		timeStamp = time;
	}
	
	public String toString() {
		return userId + " " + movieId + " " + tags + " " + timeStamp;
	}

	public int compareTo(Tag t) {
		int i = userId - t.getUserId();
		if(i == 0) {
			return movieId - t.getMovieId();
		}
		return i;
	}

	public int getMovieId() {
		return movieId;
	}

	public int getUserId() {
		return userId;
	}
	
	public String getTag() {
		return tags;
	}
}
