package mumzworld;

import org.testng.annotations.Test;

import pages.Polling;
import utils.BaseClass;

public class PollingResults extends BaseClass{

	@Test
	public void youtubeTest() throws InterruptedException {
		Polling polling = new Polling(driver);
		
		polling.visitPollingWebsite();
	}
	
}
