package listners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.DriverFactory;
import io.qameta.allure.Attachment;

public class ItestListnersM implements ITestListener 
{
//	@Override
//	public void onTestStart(ITestResult result) 
//	{
//		System.out.println("Test Start"+result.getName());
//		
//		getscreenshot();
//	}
//	
//@Override
//	public void onTestSuccess(ITestResult result) 
//	{
//		System.out.println("Test Success"+result.getName());
//		getscreenshot();
//
//				
//	}
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Test Failed"+result.getName());
		getscreenshot();

				
	}


	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Test Skipped"+result.getName());
		getscreenshot();

				
	}
//	
//	@Override
//	public void onStart(ITestContext context) 
//	{
//		System.out.println("Test Start"+context.getName());
//		getscreenshot();
//				
//	}
//	
//	@Override
//	public void onFinish(ITestContext context) 
//	{
//	System.out.println("TestSuite Start"+context.getName());
//	getscreenshot();
//				
//	}
	
	
	@Attachment(value = "This is screen shot",type = "image/png")
	
	public byte[] getscreenshot()
	{
	
		WebDriver driver = DriverFactory.getdriver();
		return((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);  
	
	}
	
		
	

}
