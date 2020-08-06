package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

private WebDriver driver;

//locators
private By signInLink = By.cssSelector(".login");



//constructor
public HomePage(WebDriver driver) {
	
	this.driver = driver;
	
}

/**
 * method clicks on Sign In link on Home page 
 * @return - handler to LoginPge
 */
public LoginPage clickSignInLink() {
	
	driver.findElement(signInLink).click();
	return  new LoginPage(driver);	
}
}
