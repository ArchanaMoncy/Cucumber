package com.opencart.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase
{
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	
	public TestBase()
	{
		
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream("C:\\Users\\Moncy Archana\\"
						+ "eclipse-workspace\\Amazon\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
				prop.load(ip);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
	}


		public static void initialization()
		{
			String browserName = prop.getProperty("browser");
			if(browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
				driver = new ChromeDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//url from config properties file
			
			driver.get(prop.getProperty("url"));
		}
}
