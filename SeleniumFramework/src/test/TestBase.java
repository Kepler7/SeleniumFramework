package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import helper.StartWebDriver;

public class TestBase extends StartWebDriver
{

	@BeforeSuite
	public void setUp() 
	{
		environment = Environment.GURU;
		browser = Browser.CHROME;
		init();
	}
	
	@AfterSuite
	public void tearDown()
	{
		try 
		{
			if(driver != null) 
			{
				driver.close();
				driver.quit();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
