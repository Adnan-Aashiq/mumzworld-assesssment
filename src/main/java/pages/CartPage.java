package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.JsonUtils;

public class CartPage {
	WebDriver driver = null;
	
	By increaseQty = By.xpath("//body/div[@id='root']/main[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/div[2]/div[1]/form[1]/div[1]/button[2]");
	By proceedToCheckout = By.xpath("//div[@class='proceedToCheckoutBtn-root-2ra'] //button[@title='Proceed to Checkout']");
	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void assertCartPageUrl() throws InterruptedException {
		Thread.sleep(5000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("cart"),"The Url doesnot contain 'cart'. ");
		Thread.sleep(5000);
	}
	
	public void increaseProductQty() {
	    String productQty = JsonUtils.getNestedValueFromJson("productDetails", "quantity");
	    int qtyToIncrease = Integer.parseInt(productQty);
	    for (int i = 0; i < qtyToIncrease; i++) {
	        try {
	            // Explicit wait for the button to be clickable
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.elementToBeClickable(increaseQty));
	            driver.findElement(increaseQty).click();
	            Thread.sleep(2000);
	        } catch (Exception e) {
	            System.out.println("Failed to click increase quantity on iteration: " + (i + 1));
	            e.printStackTrace();
	        }
	    }
		
	}
	
	public void clickProceedToCheckout() {
		driver.findElement(proceedToCheckout).click();
	}
	
}
