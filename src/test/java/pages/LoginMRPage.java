package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginMRPage {
	
	public static WebDriver driver;

	public LoginMRPage(WebDriver driver) {
		this.driver = driver;
	} 
	
	By username = By.id("username");
	By pssword = By.id("password");
	
	public void userName (String user)
	{
		driver.findElement(username).sendKeys(user);
	}

	public void enterPassword (String password)
	{
		driver.findElement(pssword).sendKeys(password);
	}
	

	public void clickLogin ()
	{
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
	}

}
