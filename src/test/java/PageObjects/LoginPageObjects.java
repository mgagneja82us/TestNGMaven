package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utility.WrapperElementActionFile;

public class LoginPageObjects
{

	WebDriver driver;
	WrapperElementActionFile action;
	

	
	public void UseNameLogin(String username) throws InterruptedException
	{
		
		//action.SetTextValstr(By.xpath("//input[@class='form_input' and @id = 'user-name']"), username);
		action.SetTextValstr(By.id("Email"), username);
			
	}
	
	public void UserPasswordLogin(String userpassword) throws InterruptedException
	{
		
		//action.SetTextValstr(By.xpath("//input[@name='password']"), userpassword);
		
		action.SetTextValstr(By.id("Password"), userpassword);
		
		
	}
	
	public void ButtonUserLoginHomePage() throws InterruptedException
	{
		
		//action.ClickButton(By.xpath("//input[@type='submit' and @value='LOGIN']"));
		action.ClickButton(By.xpath("(//input[@value='Log in'])[1]"));
		
	}
	
	public LoginPageObjects(WebDriver driver)
	{
		this.driver = driver;
		this.action = new WrapperElementActionFile(driver);
		
	   PageFactory.initElements(driver, this);
	}
}
