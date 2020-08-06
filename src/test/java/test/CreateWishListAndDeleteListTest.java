
package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.WishListPage;

public class CreateWishListAndDeleteListTest extends BaseTest {

	private LoginPage login;
	private WishListPage wish;
	private MyAccountPage account;
	private String emailLog = getWrittenEmail();// need to user email created in signup flow
	private String password = "elmedina";
	private String wishName = "wish";

	public CreateWishListAndDeleteListTest() throws Exception {

	}

	@BeforeClass
	// need to log in in order to create list
	public void logIn() {

		HomePage home = getDriver();
		login = home.clickSignInLink();
		System.out.println("create wsh email" + emailLog);
		login.setEmailLogin(emailLog);
		login.setPassworLogin(password);
		MyAccountPage account = login.clickLoginBtn();
		this.account = account;
	}

	// create 3 wish lists
	@Test(priority = 0)
	public void createWishlist() {

		HashMap<Integer, String> hmap = new HashMap<Integer, String>();

		wish = account.clickWishListBtn();
		for (int i = 0; i < 3; i++) {
			wish.setWishListName(wishName + i);
			wish.saveWishListName();
			hmap.put(i, wishName + i);
		}

		Set set = hmap.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			// System.out.print("key is: " + mentry.getKey() + " & Value is: ");
			// System.out.println(mentry.getValue());
		}
		// print all wishes names from the table
		wish.getAllWishListNames();

		this.wish = wish;

	}

	// delete one list

	@Test(priority = 1)

	public void deleteWishList() {

		wish.deleteWishList(wishName + "0"); // put fix with to be delete, i could user Random to delete randomly wish
		System.out.println("Is element there" + wish.lookForDeleteList(wishName + "0"));// for testing
	}

}
