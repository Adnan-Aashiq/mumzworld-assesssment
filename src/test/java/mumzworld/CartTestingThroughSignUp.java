package mumzworld;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckOut;
import pages.HomePage;
import pages.SignIn;
import pages.SignUp;
import utils.BaseClass;

public class CartTestingThroughSignUp extends BaseClass {
	
	@Test
	public void verifyCartFunctionality() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		CartPage cartpage = new CartPage(driver);
		SignIn signin = new SignIn(driver);
		SignUp signup = new SignUp(driver);
		CheckOut checkout = new CheckOut(driver);
		
		homepage.assertHomePageUrl();
		homepage.typeProductName();
		homepage.searchProductName();
		homepage.addProductToCart();
		homepage.clickOnViewBag();
		cartpage.assertCartPageUrl();
		cartpage.increaseProductQty();
		cartpage.clickProceedToCheckout();
		signin.assertSignInPageUrl();
		signin.clickSignUp();
		signup.typeFirstName();
		signup.typeLastName();
		signup.typeEmail();
		signup.typePassword();
		signup.clickRegister();
		checkout.assertCheckOutPageUrl();
	}

}
