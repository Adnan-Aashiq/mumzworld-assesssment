package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.JsonUtils;

public class SignIn {
	WebDriver driver = null;
	
	By email = By.id("sign_in_page_email");
	By password = By.id("sign_in_page_password");
	By signIn = By.xpath("//button[@title='Sign in']");
	By signUpLink = By.xpath("//button[@class='signLink-link-2ye']");
	
	public SignIn(WebDriver driver) {
		this.driver = driver;
	}
	
	public void assertSignInPageUrl() throws InterruptedException {
		Thread.sleep(5000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("sign-in"),"The Url doesnot contain 'sign-in'. ");
	}
	
	public void clickSignUp() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(signUpLink).click();
	}
	
	public void typeEmail() {
		String emailFromJson = JsonUtils.getNestedValueFromJson("userDetails", "email");
		driver.findElement(email).sendKeys(emailFromJson);
	}
	
	public void typePassword() {
		String passwordFromJson = JsonUtils.getNestedValueFromJson("userDetails", "password");
		driver.findElement(password).sendKeys(passwordFromJson);
	}
	
	public void clickSignIn() {
		driver.findElement(signIn).click();
	}
}
