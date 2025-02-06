import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample1OM 
{
@Test(priority = 1)
	
	public void login()
	{
	ChromeDriver driver = new ChromeDriver();	
	driver.get("https://demoqa.com/elements");
	
	driver.quit();
	
	System.out.println("Sample 1 second class");
	
	}
	
@Test (priority = 2)
	
	public void messageonly() throws InterruptedException
	{
	ChromeDriver driver = new ChromeDriver();
	System.out.println("Sample 1 second class");
	driver.get("https://www.ebay.com/");
	
	driver.findElement(By.id("gh-ac")).sendKeys("Cloth");
	
	driver.findElement(By.xpath("//span[.='Search']")).click();
	
	Thread.sleep(4000);
	
	driver.quit();
	}


}
