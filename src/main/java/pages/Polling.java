package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Polling {
	WebDriver driver = null;

	public Polling(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visitPollingWebsite() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://projects.fivethirtyeight.com/polls/president-general/2024/national/ ");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//div[@class='secondary-nav'] //nav //div[@id='form-wrap']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        //driver.quit();
	}
	
}
