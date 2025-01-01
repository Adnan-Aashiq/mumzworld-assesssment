package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignUp {
	WebDriver driver = null;
	
	By firstName = By.id("create_account_page_firstname");
	By lastName = By.id("create_account_page_lastname");
	By email = By.id("create_account_page_email");
	By password = By.id("create_account_page_password");
	By register = By.xpath("//div[@class='createAccount-actions-3by'] //button[@title='Register']");
	

	public SignUp(WebDriver driver) {
		this.driver = driver;
	}
	
	public void assertSignUpPageUrl() throws InterruptedException {
		Thread.sleep(5000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("create-account"),"The Url doesnot contain 'create-account'. ");
	}
	
	public void typeFirstName() {
	    int nameLength = 6;
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	    StringBuilder randomFirstName = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < nameLength; i++) {
	        randomFirstName.append(alphabet.charAt(random.nextInt(alphabet.length())));
	    }
	    driver.findElement(firstName).sendKeys(randomFirstName.toString());
	    System.out.println("Generated random first name: " + randomFirstName);
	}
	
	public void typeLastName() {
	    int nameLength = 6;
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	    StringBuilder randomFirstName = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < nameLength; i++) {
	        randomFirstName.append(alphabet.charAt(random.nextInt(alphabet.length())));
	    }
	    driver.findElement(lastName).sendKeys(randomFirstName.toString());
	    System.out.println("Generated random first name: " + randomFirstName);
	}
	
	public void typeEmail() {
		Random random = new Random();
	    int randomThreeDigits = 100 + random.nextInt(900); 
	    String randomEmail = "adnanqa" + randomThreeDigits + "@mailinator.com";
	    driver.findElement(email).sendKeys(randomEmail);
	    System.out.println("Generated email: " + randomEmail);
	}
	
	public void typePassword() {
		Random random = new Random();
	    int randomThreeDigits = 100 + random.nextInt(900); 
	    String randomPassword = "Adnan" + randomThreeDigits + ".";
	    driver.findElement(password).sendKeys(randomPassword);
	    System.out.println("Generated email: " + randomPassword);
	}
	
	public void clickRegister() {
		driver.findElement(register).click();
	}
	

}
