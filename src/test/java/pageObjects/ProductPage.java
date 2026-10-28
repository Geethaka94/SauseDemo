package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[@class='title']")
	WebElement title;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement BackPackElement;
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")
	WebElement BickLightElement;
	
	@FindBy(xpath="//span[@class=\"shopping_cart_badge\"]")
	WebElement shopingCartBadgeElement;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement logOutElement;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement menuElement;
	
	// ADDED: needed to reach the cart page
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cartLinkElement;
	
	
	public boolean isProductPageExists() {
		try {
			waitUntilElementIsVisible(By.xpath("//span[@class='title']"), 5);
			return title.isDisplayed();
		} catch (TimeoutException e) {
			return false;
		}
	}
	
	public void logOut() {
		menuElement.click();
		waitUntilElementIsClickable(By.xpath("//a[@id='logout_sidebar_link']"), 15);
		logOutElement.click();
	}
	
	public void addTwoItemsToCart() {
		BackPackElement.click();
		BickLightElement.click();
		
	}
	
	public String getCartBadge() {
		waitUntilElementIsVisible(By.xpath("//span[@class=\"shopping_cart_badge\"]"), 15);
		return shopingCartBadgeElement.getText();
	}
	
	public void openCart() {
		cartLinkElement.click();
	}

}