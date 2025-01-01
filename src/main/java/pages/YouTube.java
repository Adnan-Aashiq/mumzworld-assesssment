package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class YouTube {
	WebDriver driver = null;

	public YouTube(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visitYouTube() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("try not to laugh video");
        driver.findElement(By.id("search-icon-legacy")).click();
        Thread.sleep(5000);
        List<WebElement> elements = driver.findElements(By.xpath("//body/ytd-app[1]/div[1]/ytd-page-manager[1]/ytd-search[1]/div[1]/ytd-two-column-search-results-renderer[1]/div[1]/ytd-section-list-renderer[1]/div[2]/ytd-item-section-renderer[1]/div[3] //a[@id='thumbnail']"));
        if (!elements.isEmpty()) {
            elements.get(0).click();
        } else {
            System.out.println("No matching elements found.");
        }
        Thread.sleep(70000);
        
        driver.quit();
	}
	
}
