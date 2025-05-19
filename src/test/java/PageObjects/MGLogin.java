package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.interfacesme;

public class MGLogin implements interfacesme 
{
	WebDriver driver;
	
	@FindBy(id = "username")
	
	WebElement userName;
	
	@FindBy(id = "password")
	
	WebElement pWd;
	
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	
	WebElement btn;
	
	public MGLogin(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void enterusername(String UserN)
	{
		userName.sendKeys(UserN);
	
	}
	public void enterpassword(String passWord)
	{
		pWd.sendKeys(passWord);
	
	}
	public void loginbutton()
	{
		btn.click();
	
	}

}
