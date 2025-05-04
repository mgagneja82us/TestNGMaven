package Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.DriverFactory;
import listners.IterstretryListner;

public class TestSet01 
{
	@Parameters({"browser","nodeTag"})
	@Test(retryAnalyzer = IterstretryListner.class)
	
	public void try1(String browser, String nodeTag) throws MalformedURLException, URISyntaxException
	{
		DriverFactory.setdriver(browser,nodeTag);
		Assert.assertEquals(false, true);
		System.out.println("Try1");
		DriverFactory.quitdriver();
		
	}
	@Parameters({"browser","nodeTag"})
	@Test(retryAnalyzer = IterstretryListner.class)
	
	public void try2(String browser,String nodeTag) throws MalformedURLException, URISyntaxException
	{
		DriverFactory.setdriver(browser,nodeTag);
		Assert.assertEquals(false, false);
		System.out.println("Try2");
		DriverFactory.logExecutionDetails("try2",DriverFactory.getdriver() );
		DriverFactory.quitdriver();
	}
	@Parameters({"browser","nodeTag"})
	@Test(retryAnalyzer = IterstretryListner.class)
	
	public void try3(String browser,String nodeTag) throws MalformedURLException, URISyntaxException
	{
		DriverFactory.setdriver(browser,nodeTag);
		Assert.assertEquals(false, false);
		System.out.println("Try3");
		DriverFactory.quitdriver();
		
	}
	@Parameters({"browser","nodeTag"})
	@Test(retryAnalyzer = IterstretryListner.class)
	
	public void try4(String browser,String nodeTag) throws MalformedURLException, URISyntaxException
	{
		DriverFactory.setdriver(browser,nodeTag);
		Assert.assertEquals(false, false);
		System.out.println("Try4");
		DriverFactory.quitdriver();
		
	}
	
	@Parameters({"browser","nodeTag"})
	@Test(retryAnalyzer = IterstretryListner.class)
	
	public void try5(String browser,String nodeTag) throws MalformedURLException, URISyntaxException
	{
		DriverFactory.setdriver(browser,nodeTag);
		Assert.assertEquals(false, false);
		System.out.println("Try5");
		DriverFactory.quitdriver();
	}

}
