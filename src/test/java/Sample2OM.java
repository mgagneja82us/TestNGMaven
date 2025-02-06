import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample2OM 
{
	
	@Test
	public void googlesearch() throws InterruptedException
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("Selenium");
		Thread.sleep(3000);
		driver.quit();
	}


}
