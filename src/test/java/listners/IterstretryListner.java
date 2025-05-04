package listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IterstretryListner implements IRetryAnalyzer 
{
	
	private int retrycount = 0;
	
	private static final int totalretrycount = 2;
	
	@Override
	
	public boolean retry(ITestResult results)
	{
		if(retrycount < totalretrycount)
		{
			retrycount++;
			return true;
		}
		
		return false;
	}
	
	

}
