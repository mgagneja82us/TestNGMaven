import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testme {
	WebDriver driver;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		System.out.println("Hello World");
		
		
		
		
	}

}
