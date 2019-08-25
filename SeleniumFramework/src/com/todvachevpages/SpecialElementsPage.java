package com.todvachevpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.SeleniumUtils;
import helper.StartWebDriver;

public class SpecialElementsPage extends StartWebDriver
{
	private By dropDownMenuTest = By.xpath("//a[contains( text(),'Drop down menu Test')]");
	
	
	public DropDownMenuTestPage clickDropDownMenuTest() 
	{
		SeleniumUtils.clickElement(dropDownMenuTest);
		return new DropDownMenuTestPage();
	}
	
}
