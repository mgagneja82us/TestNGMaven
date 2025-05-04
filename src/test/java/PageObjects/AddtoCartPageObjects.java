package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utility.WrapperElementActionFile;

public class AddtoCartPageObjects
{

	WebDriver driver;
	WrapperElementActionFile action;
	

	public void addtocart() throws InterruptedException
	{
		action.ClickButton(By.id("add-to-cart-button-36"));
	}
	
	public void addtocart(String qty) throws InterruptedException
	{
		
		action.SetTextValstr(By.id("addtocart_36_EnteredQuantity"), qty);
	}
	
	public AddtoCartPageObjects(WebDriver driver)
	{
		this.driver = driver;
		this.action = new WrapperElementActionFile(driver);
		
	   PageFactory.initElements(driver, this);
	}
}
