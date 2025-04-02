package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPatientPage {
	
	WebDriver driver;

	public RegisterPatientPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void RegPatientBtn ()
	{
		driver.findElement(By.xpath("//*[@id=\"referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension\"]")).click();
	}
	
	By fname = By.name("givenName");
	By mname = By.name("middleName");
	By lname = By.name("familyName");
	
	public void enterNameDet (String firstnm,String midname,String lstname)
	{
		driver.findElement(fname).sendKeys(firstnm);
		driver.findElement(mname).sendKeys(midname);
		driver.findElement(lname).sendKeys(lstname);
	}
	
	public void clickNext()
	{
		driver.findElement(By.xpath("//*[@id=\"next-button\"]")).click();
	}
	
	public void selectGender (String gen)
	{
		WebElement gender = driver.findElement(By.id("gender-field"));

		Select cnt = new Select(gender);
		cnt.selectByValue(gen);
	}
	
	By date = By.id("birthdateDay-field");
	By year = By.id("birthdateYear-field");
	
	public void enterDOB (String day,String month,String yr)
	{
		driver.findElement(date).sendKeys(day);
		driver.findElement(year).sendKeys(yr);
		
		WebElement mon = driver.findElement(By.id("birthdateMonth-field"));

		Select cnt = new Select(mon);
		cnt.selectByValue(month);
	}
	
	By add1 = By.id("address1");
	By add2 = By.id("address2");
	By city = By.id("cityVillage");
    By State = By.id("stateProvince");
    By Cntry = By.id("country");
    By Pstcd = By.id("postalCode");
    
    public void enterAddDetails (String addr1,String addr2,String cty,String stt,String ctr,String pcode)
    {
		driver.findElement(add1).sendKeys(addr1);
		driver.findElement(add2).sendKeys(addr2);
		driver.findElement(city).sendKeys(cty);
		driver.findElement(State).sendKeys(stt);
		driver.findElement(Cntry).sendKeys(ctr);
		driver.findElement(Pstcd).sendKeys(pcode);
    }
    
    By phnno = By.name("phoneNumber");
    
    public void enterPhnDetails (String phoneno)
    {
		driver.findElement(phnno).sendKeys(phoneno);
    }
    
	By relationname = By.xpath("//*[@id=\"relationship\"]/p[2]/input[1]");
	
	public void enterRelationDet (int rlntype,String rlnname)
	{
		driver.findElement(relationname).sendKeys(rlnname);
		
		WebElement mon = driver.findElement(By.id("relationship_type"));

		Select cnt = new Select(mon);
		cnt.selectByIndex(rlntype);
	}
	
	public void clickCfm()
	{
		driver.findElement(By.id("submit")).click();
	}
}
