package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginMRPage;
import pages.RegisterPatientPage;
import pages.UpdatePatDet;

public class testCaseOpenMR {

	WebDriver driver;
	
	@BeforeSuite
	public void beforeSut()
	{
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void navigateToSite ()
	{
		driver.get("https://o2.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void provideInvalidCredentials() throws Throwable
	{
		LoginMRPage login = new LoginMRPage(driver);
		login.userName("Aswath");
		login.enterPassword("narayana");
		Thread.sleep(500);
		login.clickLogin();

	}
	
	@Test(priority=2)
	public void provideBlankCredentials() throws Throwable
	{
		LoginMRPage login = new LoginMRPage(driver);
		login.userName("");
		login.enterPassword("");
		login.clickLogin();
		Thread.sleep(500);
	}
	
	@Test(priority=3)
	public void provideValidCredentials() throws Throwable
	{
		LoginMRPage login = new LoginMRPage(driver);
		login.userName("admin");
		login.enterPassword("Admin123");
		Thread.sleep(500);
		login.clickLogin();
		Thread.sleep(500);
	}
	
	@Test(priority=4)
	public void enterPatDetails() throws Throwable
	{
		RegisterPatientPage reg = new RegisterPatientPage(driver);
		reg.RegPatientBtn();
		reg.enterNameDet("Ramraj", "R", "Nayak");
		Thread.sleep(600);
		reg.clickNext();
		reg.selectGender("M");
		Thread.sleep(600);
		reg.clickNext();
		reg.enterDOB("12", "1", "1987");
		Thread.sleep(600);
		reg.clickNext();
		reg.enterAddDetails("no 33, 2nd street", "turvekere", "bengaluru", "karnataka", "India", "560080");
		Thread.sleep(600);
		reg.clickNext();
		reg.enterPhnDetails("1234567890");
		Thread.sleep(600);
		reg.clickNext();
		reg.enterRelationDet(2, "Muniyappa S");
		Thread.sleep(600);
		reg.clickNext();
		reg.clickCfm();
	}
	
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
	
}
