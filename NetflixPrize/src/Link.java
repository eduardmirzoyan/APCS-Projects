
public class Link {

	
	private int movieId;
	private String imdbId;
	private String tmdbId;
	
	public Link(int id, String imd, String tmd) {
		movieId = id;
		imdbId = imd;
		tmdbId = tmd;
	}
	
	public String toString() {
		return movieId + " " + imdbId + " " + tmdbId;
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public String getIMDB() {
		return imdbId;
	}


}
