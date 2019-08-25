package com.todvachevpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import helper.SeleniumUtils;
import helper.StartWebDriver;

public class DropDownMenuTestPage extends StartWebDriver
{
	private By dropDownElement = By.name("DropDownTest");
	
	
	public void selectMercedesOption() 
	{
		SeleniumUtils.select(dropDownElement, 2);
	}
}
