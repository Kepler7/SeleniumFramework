package webObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.SeleniumUtils;

public class HeaderMenu extends WebObjectBase
{
	private By menuOptions = By.cssSelector("li");
	private static By headerMenuContext = By.cssSelector("ul[class='nav navbar-nav']");
	
	public HeaderMenu() 
	{
		super(SeleniumUtils.getElement(headerMenuContext));
	}

	public List<WebElement> getMenuOptions()
	{
		return getContext().findElements(menuOptions);
	}
	
	public void clickByText(String text) 
	{
		WebElement ele = getMenuOptions().stream().filter(x -> x.getText().contains(text))
				.findFirst().orElse(null);
		ele.click();
	}
}
