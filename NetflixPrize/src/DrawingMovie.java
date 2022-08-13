import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PImage;

public class DrawingMovie {

	private Movie movie;
	private PImage coverArt;
	
	public DrawingMovie(Movie m) {
		this.movie = m;
		coverArt = null;
	}
	
	public void draw(PApplet drawer, float x, float y, float width, float height) {
		if (movie != null) {
			if (coverArt != null) {
				drawer.image(coverArt, x, y,width,height);
			}
			
			String title = movie.getTitle();
			drawer.text(title, x, y);
			
		}
		drawer.stroke(0);
		drawer.noFill();
		drawer.rect(x, y, width, height);
	}
	

	public void downloadArt(PApplet drawer) {

		Thread downloader = new Thread(new Runnable() {

			@Override
			public void run() {

				// Find the cover art using IMDB links
				// Initialize coverArt

				Scanner scan = null;
				String url = "https://www.imdb.com/title/tt" + movie.getLink() +"/";

				try {
					String output = "";

					URL reader = new URL(url);
					scan = new Scanner(reader.openStream());

					while (scan.hasNextLine()) {
						String line = scan.nextLine();
						output += line + "\n";
					}
					
					String urlImage = getImageURL(output);

					
					coverArt = drawer.loadImage(urlImage);
					

				} catch (IOException e) {

					e.printStackTrace();

				} finally {
					if (scan != null) {
						scan.close();
					}

				}
				
			}
			
		});
		
		downloader.start();

	}
	
	public String getImageURL(String s) {
		int i = s.indexOf("/title/tt" + movie.getLink() +"/mediaviewer");
		int j = s.indexOf("src=\"", i);
		int k = s.indexOf("\"", j + 5);
		
		return s.substring(j + 5, k);
	}

	
}
