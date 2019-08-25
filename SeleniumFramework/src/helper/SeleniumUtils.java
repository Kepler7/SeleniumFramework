package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtils extends StartWebDriver
{

	public static WebElement getElement(By by) 
	{
		return driver.findElement(by);
	}
		
	public static void clickElement(By by) 
	{
		try 
		{
			if(driver.findElements(by).size() == 1) 
			{
				driver.findElement(by).click();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void sendKeysTo(By by, String keys) 
	{
		WebElement element = getElement(by);
		element.sendKeys(keys);
	}
	
	public static void sendKeysTo(WebElement element, String keys) 
	{
		try 
		{
			element.sendKeys(keys);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void clickElement(WebElement element) 
	{
		try 
		{
			element.click();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	//select methods to handle dropDowns
	
	public static void select(By by, int index) 
	{	
		new Select(getElement(by)).selectByIndex(index);
	}
	
	public static void select(WebElement element, int index) 
	{	
		new Select(element).selectByIndex(index);
	}
	
	public static void select(By by, String value) 
	{
		new Select(getElement(by)).selectByValue(value);
	}
	
	public static void select(String text, By by) 
	{
		new Select(getElement(by)).selectByVisibleText(text);
	}
		
	
}
