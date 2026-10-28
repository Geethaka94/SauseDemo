package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC001_Verify_Shopping_Cart_Functionality extends BaseTest {

	private void login(String username, String password) {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.setUserName(username);
		loginPage.setPassword(password);
		loginPage.clickLoggin();
	}

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void testUserLogin(String userName, String password, String expectedResult) {

		login(userName, password);

		ProductPage productPage = new ProductPage(driver);

		if ("valid".equalsIgnoreCase(expectedResult)) {

			Assert.assertTrue(productPage.isProductPageExists(), "Expected successful login.");

		} else if ("invalid".equalsIgnoreCase(expectedResult)) {

			Assert.assertFalse(productPage.isProductPageExists(), "Expected login to fail.");

		} else {

			Assert.fail("Unsupported ExpectedResult: " + expectedResult);
		}
	}

	@Test
	public void testShoppingCartBadge() {

		login("standard_user", "secret_sauce");

		ProductPage productPage = new ProductPage(driver);

		Assert.assertTrue(productPage.isProductPageExists(), "Products page was not displayed.");

		productPage.addTwoItemsToCart();

		Assert.assertEquals(productPage.getCartBadge(), "2", "Cart badge should display 2 items.");

		productPage.openCart();

		CartPage cartPage = new CartPage(driver);

		Assert.assertEquals(cartPage.getTextBackPack(), "Sauce Labs Backpack");

		Assert.assertEquals(cartPage.getTextBikeLight(), "Sauce Labs Bike Light");
	}
}