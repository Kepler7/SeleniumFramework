package com.todvachevpages;

import org.openqa.selenium.By;

import helper.SeleniumUtils;
import helper.StartWebDriver;

public class TodvachevHomePage extends StartWebDriver
{
	private By specialElements = By.xpath("//li[@id='menu-item-35']");
	
	
	public SpecialElementsPage clickSpecialElements() 
	{
		SeleniumUtils.clickElement(specialElements);
		return new SpecialElementsPage();
		
	}
}
