package webObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.StartWebDriver;

public class WebObjectBase extends StartWebDriver
{
	private WebElement context;
	
	public WebObjectBase(WebElement context) 
	{
		this.context = context;
	}

	public WebElement getContext() 
	{
		return context;
	}
	 

}
