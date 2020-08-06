package test;

import org.testng.annotations.Test;

import base.BaseTest;
import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.SignUpPage;

public class SiguUpTest extends BaseTest {

	private String email = createUserAndgetUserEmail();
	private String fName = "Amina";
	private String lName = "Pez";
	private String password = "elmedina";
	private String dob = "12-5-1990";
	private String company = "Nahla";
	private String address = "BLV 14st";
	private String city = "New York";
	private String stateAlabama = "1"; // value for alabama is 1
	private String postCode = "12300";
	private String countryUSA = "21"; // value 21 is for USA
	private String additionalInfo = "Dodatni info";
	private String mobile = "1232412343234";
	private String aliasAddress = "amina.pez+ote@gmail.com";

	
	public SiguUpTest() throws Exception {
		
		
		
	}
	@Test
	public void signUpNewUser() throws Exception {

		HomePage home = getDriver();
		LoginPage login = home.clickSignInLink();
		// enter email and click "Create Account" button on Login page
		login.setEmail(email);
		SignUpPage sign = login.clickCreateAccountLink();
		// select Mrs as title

		sign.checkTitle();
		sign.setFirstName(fName);
		sign.setLastName(lName);

		// verify value of email field

		Assert.assertEquals("Sumitted email is not same as displayed email", email, sign.getEmailValue());

		sign.setPassword(password);// set password
		sign.setDOB(dob);// set date of birth
		sign.checkNewletterCheckbox();// check newletter
		// verify that checkbox is checked
		Assert.assertTrue("Newsletter checkbox is not checked", sign.isNewLetterChecked());

		// verify that receive.. checkbox is not checked
		Assert.assertFalse("Receive.. check box is checked but it should not be", sign.isSpecialOfferChecked());

		/////////////////// Your Address //////////////////////////

		// verify that first and last name are prefilled in your address section and
		// they are the same as one user entered

		Assert.assertEquals("Fist Name field in You Address in not having correct result", fName,
				sign.getFirstNameAdd());
		Assert.assertEquals("LastName ....", lName, sign.getLastNameAdd());

		sign.setCompany(company);
		sign.enterAddress(address);
		sign.setCity(city);
		sign.selectState(stateAlabama);
		sign.setPostCode(postCode);
		sign.selectCountry(countryUSA);
		sign.setAdditionalInfo(additionalInfo);
		sign.setMobilePhone(mobile);
		sign.setAliasAddress(aliasAddress);

		MyAccountPage account = sign.submitForm(); // submit form
        //capture screenshot 

		Assert.assertEquals("User is not on Account page", account.accountPageTitle(), "My account - My Store");

		LoginPage log = account.logOutFromSite(); //log out from the page
		//verify that user is logged out
		Assert.assertEquals("User is not on login page", log.getPageTitle(), "Login - My Store");
	}

	
	 
	
}
