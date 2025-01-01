package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.JsonUtils;

public class HomePage {
	WebDriver driver = null;

	String productName = "Feeder";
	By searchField = By.xpath("//input");
	By productSearchButton = By.xpath("//button[@title='Submit your search query']");
	By addToCart = By.xpath(
			"//body/div[@id='root']/main[1]/div[2]/article[1]/div[2]/div[2]/section[1]/div[1]/div[1]/div[1]/div[2]/div[2]");
	By viewBag = By.xpath("//a[@title='View Bag']");
	By productCards = By.xpath("//div[@class='item-root-1iS']");
	By productNameSpan = By.xpath(".//div[@class='item-nameAndBtnWrapper-4IV']//span");
	By productNameTitle = By.xpath(".//div[@class='item-nameAndBtnWrapper-4IV']//a");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void assertHomePageUrl() throws InterruptedException {
		Thread.sleep(5000);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(currentUrl.contains("mumzworld.com"), "The Url doesnot contain 'mumzworld.com'. ");
	}

	public void typeProductName() throws InterruptedException {
		String productCategory = JsonUtils.getNestedValueFromJson("productDetails", "keyword");
		driver.findElement(searchField).sendKeys(productCategory);
		Thread.sleep(5000);
	}

	public void searchProductName() throws InterruptedException {
		driver.findElement(productSearchButton).click();
		Thread.sleep(5000);
	}

	public void addProductToCart() throws InterruptedException {
		// Get the product name from the JSON
		String productNameFromJson = JsonUtils.getNestedValueFromJson("productDetails", "productName");

		// Find all product elements matching the locator
		List<WebElement> productElements = driver.findElements(productCards);

		// Loop through each product element
		for (WebElement productElement : productElements) {
			// Retrieve the product name from both the span tag and title attribute
			String productNameFromSpan = productElement.findElement(productNameSpan).getText();
			String productNameFromTitle = productElement
					.findElement(productNameTitle).getAttribute("title");

			// Compare the retrieved product names with the JSON product name
			if (productNameFromSpan.equals(productNameFromJson) || productNameFromTitle.equals(productNameFromJson)) {
				// If match is found, click on the "Add to Cart" button
				WebElement addToCartButton = productElement.findElement(addToCart);
				addToCartButton.click();
				Thread.sleep(10000);
				System.out.println("Added to cart: " + productNameFromJson);
				return; // Exit after adding the desired product
			}
		}

		// If no product matches the provided name
		System.out.println("Product not found: " + productNameFromJson);
		
	}

	public void clickOnViewBag() throws InterruptedException {
		driver.findElement(viewBag).click();
	}

}
