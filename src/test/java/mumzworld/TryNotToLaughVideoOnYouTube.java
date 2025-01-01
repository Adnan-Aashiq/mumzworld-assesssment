package mumzworld;

import org.testng.annotations.Test;

import pages.YouTube;
import utils.BaseClass;

public class TryNotToLaughVideoOnYouTube extends BaseClass{

	@Test
	public void youtubeTest() throws InterruptedException {
		YouTube youtube = new YouTube(driver);
		
		youtube.visitYouTube();
	}
	
}
