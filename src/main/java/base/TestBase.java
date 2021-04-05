package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import util.TestUtil;
import java.util.concurrent.TimeUnit;
public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:/Eclipse/workspace/Intellisense_Framework/src/main/java/config/config.properties");
			
			prop.load(ip);
			
			}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();	
		}
	
	}


	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "D:/Spyder/Selenium/chromedriver.exe");
			 driver = new ChromeDriver();
	
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT);
		
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("Email"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		

	
		}
		
}
