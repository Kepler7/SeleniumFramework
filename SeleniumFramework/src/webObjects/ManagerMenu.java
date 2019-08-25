package webObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.SeleniumUtils;

public class ManagerMenu extends WebObjectBase
{
	private By menuOptions = By.cssSelector("li");
	private static By ContextMenu = By.cssSelector(".menusubnav");

	public ManagerMenu() 
	{
		super(SeleniumUtils.getElement(ContextMenu));
	}
	
	private List<WebElement> getMenuOptions()
	{
		return getContext().findElements(menuOptions);
	}
	
	public void clickOnMenuByIndex(int index) 
	{
		getMenuOptions().get(index).click();
		
	}
	
	public void clickByText(String text) 
	{
//		for(int i = 0; i < getMenuOptions().size(); i++) 
//		{
//			if(getMenuOptions().get(i).getText().equalsIgnoreCase(text)) 
//			{
//				getMenuOptions().get(i).click();
//			}
//		}
		
		WebElement ele = getMenuOptions().stream().filter(i -> i.getText().equalsIgnoreCase(text)).findFirst().orElse(null);
		System.out.println(ele.getText());
		ele.click();
	}
	
	
	

	
}
