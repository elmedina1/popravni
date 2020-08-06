package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BlousePage;
import pages.HomePage;
import pages.ItemPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.WishListPage;

public class AddItemWishListTest extends BaseTest {

	private LoginPage login;
	private WishListPage wish;
	private MyAccountPage account;
	private String emailLog = getWrittenEmail();// need to user email created in signup flow
	private String password = "elmedina";

	public AddItemWishListTest() throws Exception {

	}

	@BeforeClass
	//
	public void logIn() {

		HomePage home = getDriver();
		login = home.clickSignInLink();
		login.setEmailLogin(emailLog);
		login.setPassworLogin(password);
		MyAccountPage account = login.clickLoginBtn();
		this.account = account;
	}

	@Test
	public void addProductToWishList() {
		account.hoverOnWomenMenu();
		BlousePage blouse = account.clickOnBlouseItem();
		ItemPage item = blouse.clickMoreBtn();
		item.clickWishButton();
		Assert.assertEquals(item.getErrorMsg(), "Added to your wishlist.", "Item is not added to the wishlist");
		item.closePopup();
	}
}
