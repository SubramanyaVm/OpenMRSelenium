package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginMRPage;
import pages.UpdatePatDet;

public class testCaseUpdPat {
	
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
	public void provideValidCredentials() throws Throwable
	{
		LoginMRPage login = new LoginMRPage(driver);
		login.userName("admin");
		login.enterPassword("Admin123");
		Thread.sleep(500);
		login.clickLogin();
		Thread.sleep(500);
	}

	@Test(priority=2)
	public void updateDet () throws Throwable
	{
		UpdatePatDet upd = new UpdatePatDet(driver);
		upd.clickFind();
		upd.searchPat("Ramraj");
		upd.selectPatDet();
		upd.clickEdit();
		upd.editMname("Raj");
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
