package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UpdatePatDet {

	WebDriver driver;

	public UpdatePatDet(WebDriver driver) {
		this.driver = driver;
	}
	
	By findpat = By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension");
	
	public void clickFind()
	{
		driver.findElement(findpat).click();
	}
	
	By patname = By.id("patient-search");
	
	public void searchPat(String name)
	{
		driver.findElement(patname).sendKeys(name);
	}
	
	public void selectPatDet()
	{
		
		WebElement det = driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr/td[1]"));
		det.click();

	}
	
	By edit = By.xpath("//*[@id=\"edit-patient-demographics\"]/a");
	
	public void clickEdit()
	{
	driver.findElement(edit).click();
	}
	
	By mname = By.name("middleName");
	
	public void editMname(String name) throws Throwable
	{
		driver.findElement(mname).sendKeys(name);
		Thread.sleep(600);
		driver.findElement(By.id("save-form")).click();
		Thread.sleep(600);
		driver.findElement(By.id("registration-submit")).click();
	}
}
