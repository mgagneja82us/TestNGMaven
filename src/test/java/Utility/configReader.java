package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader 
{
	private Properties properties;
	public configReader() throws IOException
	{
		FileInputStream fil = new FileInputStream("C:\\Users\\Mohit\\eclipse-workspace\\TestNGMavenProject\\src\\test\\resources\\config.properties");
		properties = new Properties();
		
		properties.load(fil);
		
	}

	public String getproperties(String key)
	{
		return properties.getProperty(key);
		
	}
	
}
