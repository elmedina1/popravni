package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {
private WebDriver driver;
private By wishButton = By.id("wishlist_button");
private By errMsg = By.className("fancybox-error");
private By closeBtn = By.cssSelector("[title=\"Close\"]");

public ItemPage(WebDriver driver) {
	
	this.driver = driver;
}


public void clickWishButton() {
	
	driver.findElement(wishButton).click();
	
}

public String getErrorMsg() {
	
	return driver.findElement(errMsg).getText();
}

public void closePopup() {
	
	driver.findElement(closeBtn).click();
	
}
}
