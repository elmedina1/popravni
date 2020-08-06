package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage {

	private WebDriver driver;
	private By wishListName = By.id("name");
	private By wishListSave = By.id("submitWishlist");
	private By nameColumn= By.linkText("//tr/td[1]");
	
	public WishListPage(WebDriver driver) {
		this.driver=driver;
	}
	
public void setWishListName(String lname) {
		
		driver.findElement(wishListName).sendKeys(lname);
	}
	
	
	public void saveWishListName() {
		driver.findElement(wishListSave).click();
	}
	
	
 public void getAllWishListNames() {
	 
	List<WebElement> wishes= driver.findElements(nameColumn);
	for(WebElement wish: wishes) {
		System.out.println("Created wish list:" + wish);
	}

	
	
 }	
	
 public void deleteWishList(String listName) {
	 String wish_id = getWishlistID(listName);
	 driver.findElement(By.xpath("//tr[@id=\""+wish_id+"\"]//td[@class=\"wishlist_delete\"]/a")).click();
	 driver.switchTo().alert().accept();
 }
 
 public int lookForDeleteList(String listName) {
	 
	 
	List<WebElement> list= driver.findElements(By.xpath("//a[contains(.,\""+listName+"\")]/./."));
 return list.size();
 }
 
 
	
private String getWishlistID(String listname) {
	String id =driver.findElement(By.xpath("//a[contains(.,\""+listname+"\")]/../..")).getAttribute("id");
	System.out.println("Ovo je list id" + id);
return id;	
	
}	
 
}
