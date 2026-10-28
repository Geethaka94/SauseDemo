package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement userNameElement;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordElement;

	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement logginButton;

	public void setUserName(String username) {
		waitUntilElementIsVisible(By.xpath("//input[@id='user-name']"),15);
		userNameElement.clear();
		userNameElement.sendKeys(username);

	}

	public void setPassword(String password) {

		waitUntilElementIsVisible(By.xpath("//input[@id='password']"),15);
		passwordElement.clear();
		passwordElement.sendKeys(password);
	}

	public void clickLoggin() {
		waitUntilElementIsClickable(By.xpath("//input[@id='login-button']"),15);
		logginButton.click();
	}

}