package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

	private WebDriver driver;
	// form fields
	private By genderMs = By.id("uniform-id_gender2");
	private By firstName = By.id("customer_firstname");
	private By lastName = By.id("customer_lastname");
	private By email = By.id("email");
	private By password = By.id("passwd");
	private By dobDay = By.id("days");
	private By dobMonth = By.id("months");
	private By dobYears = By.id("years");
	private By newLetterCheckBox = By.id("newsletter");
	private By specialOffersCheckBox = By.id("optin");
	
// your address locators	
	private By fistNameAddress = By.id("firstname");
	private By lastNameAddress = By.id("lastname");
	private By company = By.id("company");
	private By address1 = By.id("address1");
	private By address2 = By.id("address2");
	private By city = By.id("city");
	private By postCode = By.id("postcode");
	private By state = By.id("id_state");
	private By country = By.id("id_country");
	private By additionalInfo = By.id("other");
	private By homePhone = By.id("phone");
	private By mobilePhone = By.id("phone_mobile");
	private By aliasAddress = By.id("alias");

	private By registerBtn = By.id("submitAccount");

	public SignUpPage(WebDriver driver) {

		this.driver = driver;
	}

//select MRS
	public void checkTitle() {
		scrollToElement(genderMs);
		driver.findElement(genderMs).click();
	}

// set first name

	public void setFirstName(String name) {

		driver.findElement(firstName).sendKeys(name);
	}
// get set last name

	public void setLastName(String last) {

		driver.findElement(lastName).sendKeys(last);
	}

// get value of email field

	public String getEmailValue() {

		return driver.findElement(email).getAttribute("value");
	}

// enter password
	public void setPassword(String pass) {

		driver.findElement(password).sendKeys(pass);
	}

//select DOB

	public void setDOB(String date) {

		String[] dateOfBirth = date.split("-");
		String day = dateOfBirth[0];
		String month = dateOfBirth[1];
		String year = dateOfBirth[2];

		selectDayMonthYear(dobDay, day);
		selectDayMonthYear(dobMonth, month);
		selectDayMonthYear(dobYears, year);

	}

// select newletter

	public void checkNewletterCheckbox() {

		driver.findElement(newLetterCheckBox).click();

	}

	// return status of newslettercheckbox

	public boolean isNewLetterChecked() {

		return driver.findElement(newLetterCheckBox).isSelected();
	}

	// return status of Special offer checkbox

	public boolean isSpecialOfferChecked() {

		return driver.findElement(specialOffersCheckBox).isSelected();
	}

	// get firs name value from you address section

	public String getFirstNameAdd() {
		scrollToElement(fistNameAddress);
		return driver.findElement(fistNameAddress).getAttribute("value");
	}

	public String getLastNameAdd() {

		return driver.findElement(lastNameAddress).getAttribute("value");
	}

	public void setCompany(String comp) {

		driver.findElement(company).sendKeys(comp);
	}

	// enter first address
	public void enterAddress(String add) {

		driver.findElement(address1).sendKeys(add);

	}

	// enter city
	public void setCity(String cityV) {
		scrollToElement(city);
		driver.findElement(city).sendKeys(cityV);
	}

	// select state
	public void selectState(String stateV) {

		selectDayMonthYear(state, stateV);

	}

	// enter postcode

	public void setPostCode(String postCodeV) {

		driver.findElement(postCode).sendKeys(postCodeV);
	}

	// select country

	public void selectCountry(String ctValue) {

		selectDayMonthYear(country, ctValue);
	}

	// set additional info

	public void setAdditionalInfo(String setInfo) {

		driver.findElement(additionalInfo).sendKeys(setInfo);

	}

	// set mobil phone

	public void setMobilePhone(String phoneM) {
		scrollToElement(mobilePhone);
		driver.findElement(mobilePhone).sendKeys(phoneM);

	}

	// set Alias Address

	public void setAliasAddress(String alAdd) {
driver.findElement(aliasAddress).clear();
		driver.findElement(aliasAddress).sendKeys(alAdd);
	}

	// click on registerButton
	public MyAccountPage submitForm() {
		driver.findElement(registerBtn).click();
		return new MyAccountPage(driver); 
	}

	private void selectDayMonthYear(By item, String value) {

		Select sel = new Select(driver.findElement(item));
		sel.selectByValue(value);

	}

	private void scrollToElement(By item) {

		WebElement element = driver.findElement(item);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
