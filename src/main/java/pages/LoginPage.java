package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By emailCreate = By.id("email_create");
	private By createAccountBtn = By.name("SubmitCreate");
	private By email = By.id("email");
	private By password = By.id("passwd");
	private By loginBtn = By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	public void setEmail(String userEmail) {

		driver.findElement(emailCreate).sendKeys(userEmail);
	}

	/**
	 * method click on "Create a new account" link in Login page
	 * 
	 * @return handler to SignUpPage
	 */

	public SignUpPage clickCreateAccountLink() {

		driver.findElement(createAccountBtn).click();
		return new SignUpPage(driver);

	}

	public String getPageTitle() {

		return driver.getTitle();
	}

	public void setEmailLogin(String emailV) {

		driver.findElement(email).sendKeys(emailV);
	}

	public void setPassworLogin(String pass) {
		driver.findElement(password).sendKeys(pass);
	}

	public MyAccountPage clickLoginBtn() {

		driver.findElement(loginBtn).click();
		return new MyAccountPage(driver);
	}

}
