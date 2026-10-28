package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[text()=\"Sauce Labs Backpack\"]")
	WebElement backPackElement;
	
	@FindBy(xpath="//div[text()=\"Sauce Labs Bike Light\"]")
	WebElement bickLightElement;
	
	public String getTextBackPack() {
		waitUntilElementIsVisible(By.xpath("//div[text()=\"Sauce Labs Backpack\"]"), 15);
		return backPackElement.getText();
	}
	
	public String getTextBikeLight() {
		waitUntilElementIsVisible(By.xpath("//div[text()=\"Sauce Labs Bike Light\"]"), 15);
		return bickLightElement.getText();
	}

}