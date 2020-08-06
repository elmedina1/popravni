package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import pages.HomePage;

public class BaseTest {

	private WebDriver driver;
	private Properties prop1 = new Properties();
	private Properties prop2 = new Properties();
	private String fileProp = System.getProperty("user.dir") + "\\userEmail\\userEmail.properties";
	private String fileConf = System.getProperty("user.dir") +"\\config\\config.properties";
	FileInputStream input1;
	FileInputStream input2;
	
	@BeforeTest
	public void setUp() throws Exception {
		
		input2 = new FileInputStream(fileConf);
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//executable//chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		prop2.load(input2);
		driver.get(prop2.getProperty("url"));

	}

	// returns handle HomePage
	public HomePage getDriver() {

		return new HomePage(driver);
	}

	// grab email value from the file
	public String createUserAndgetUserEmail() throws Exception {

		radnomPart(); // generates random email and write it to properties file
		return getWrittenEmail();
	
	}

 //@AfterTest
	public void tearDown() {

		driver.quit();

	}

	
//get email  from properties file
	
	public String getWrittenEmail() throws Exception {
	input1 = new FileInputStream(fileProp);
	prop1.load(input1);

	return prop1.getProperty("email_full");
	}
	
//generates random string of length of 5 and adds it to email , than it saves email to properties file

	private void radnomPart() throws Exception {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 5;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		//generates random email with
		input1 = new FileInputStream(fileProp);
		input2 = new FileInputStream(fileConf);
		//prop1.load(input1);
		prop2.load(input2);
		
		String userEmail = prop2.getProperty("email_prefix") + generatedString + prop2.getProperty("email_sufix");
		System.out.println("UserEmail BASE TEST:" + userEmail);
		//save email to properties
		OutputStream out = new FileOutputStream(fileProp);
		prop1.setProperty("email_full", userEmail);
		prop1.store(out, null);

	}

}
