package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BlousePage {

	private WebDriver driver;
	private By blouseItem = By.cssSelector("img[title=\"Blouse\"]");
	private By moreButton = By.cssSelector("[title=\"View\"]");
	public BlousePage(WebDriver driver) {
		
		
		this.driver = driver;
	}
	                  
	
	
	
	private void hoverOverItem() {
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(blouseItem)).perform();
		
	}
	
	public ItemPage clickMoreBtn() {
		
		hoverOverItem();
		driver.findElement(moreButton).click();
		return new ItemPage(driver);
	}

}
