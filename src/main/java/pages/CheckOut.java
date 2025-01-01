package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckOut {
	WebDriver driver = null;
	
	public CheckOut(WebDriver driver) {
		this.driver = driver;
	}
	
	public void assertCheckOutPageUrl() throws InterruptedException {
		Thread.sleep(5000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("checkout"),"The Url doesnot contain 'checkout'.");
	}

}
