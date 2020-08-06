package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {

	private WebDriver driver;
	
	private By logOut = By.className("logout");
	private By myWishList = By.className("lnk_wishlist");
	
	private By womenMenu = By.cssSelector("#block_top_menu >ul >li > [title=\"Women\"]");
	private By blousesItem = By.cssSelector("a[title=\"Blouses\"]");
	
	
	
	public MyAccountPage(WebDriver driver) {
		
		
		this.driver=driver;
	}
	
	// get page title
	
	public String accountPageTitle() {
		
		return driver.getTitle();
	}
	
	//logot
	
	public LoginPage logOutFromSite( ) {
		
		
		driver.findElement(logOut).click();
		return new LoginPage(driver);
	}
	
	
	public WishListPage clickWishListBtn() {
		
		
		driver.findElement(myWishList).click();
		return new WishListPage(driver);
	}
	
	public void hoverOnWomenMenu() {
		
		
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(womenMenu)).perform();
		
	}
	
	public BlousePage clickOnBlouseItem() 
	{
		
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(blousesItem));
		driver.findElement(blousesItem).click();
				
		return new BlousePage (driver);
		
	}
}
