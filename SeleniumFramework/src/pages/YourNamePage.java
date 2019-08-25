package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helper.StartWebDriver;

public class YourNamePage extends StartWebDriver
{	

	public enum YourNamePageElements
	{
		YOUR_NAME("yourName", By.xpath("//label[text()='Your Name :']")),
		YOUR_NAME_DROP("yourNameDropDown", By.xpath("//select[@id='userSelect']"));
		
		private final String title;
		private final By by;
		
		private YourNamePageElements (String title, By by) 
		{
			this.title = title;
			this.by = by;
		}
		
		public By getLocator() 
		{
			return (by);
		}		
	}
	
	public void selectDemo() 
	{
		WebElement dropDown =driver.findElement(YourNamePageElements.YOUR_NAME_DROP.getLocator());
		Select select = new Select(dropDown);
		select.getOptions();
		select.selectByIndex(3);
		select.selectByValue("2");
		select.selectByVisibleText("Harry Potter");
	}
	
}
