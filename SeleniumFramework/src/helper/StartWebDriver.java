package helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class StartWebDriver 
{
	
	public static Environment environment = Environment.UAT1;
	public static Browser browser = Browser.CHROME;
	public static InputStream input;
	public static InputStream credentials;
	public static Properties properties = new Properties();
	public static Properties propCredentials = new Properties();
	public static Select select=null;
	
	public enum Environment
	{
		UAT1,UAT2,PROD,TRAINING,GURU
	}
	
	public enum Browser
	{
		CHROME,IE,FIREFOX
	}
	
	public static WebDriver driver;
	public static String URL;
	
	public void loadCredentials() 
	{
		try 
		{
			credentials = StartWebDriver.class.getClassLoader().getResourceAsStream("executables\\credentials.properties");
			propCredentials.load(credentials);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	
	}
	
	private void loadConfig() 
	{
		try 
		{
			input = StartWebDriver.class.getClassLoader().getResourceAsStream("executables\\config.properties");
			properties.load(input);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	
	}
	
	public void init() 
	{
		loadConfig();
		try 
		{
			switch (browser) 
			{
			case IE:
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver(capabilities);
				break;
			case CHROME:
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			default:
				break;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			switch(environment) 
			{
				case UAT1:
					URL = properties.getProperty("uat1");
					break;
				case UAT2:
					URL = properties.getProperty("uat2");
					break;
				case PROD:
					URL = properties.getProperty("prod");
					break;
				case TRAINING:
					URL = properties.getProperty("testsiteurl");
					break;
				case GURU:
					URL = properties.getProperty("guru");
					break;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("implicitwait")), TimeUnit.SECONDS);
	}
	
}
