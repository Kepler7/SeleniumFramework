package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.SeleniumUtils;
import helper.StartWebDriver;

public class HomeTrainingPage extends PageBase
{

	By customerLoginBtn = By.xpath("");
	public enum HomeTrainingPageElements
	{
		CUSTOMER_LOGIN("customer login button", By.cssSelector("div > div:first-child > .btn.btn-primary.btn-lg")), 
		BANK_MANAGER("bank manager", By.cssSelector("div > div:last-child > .btn.btn-primary.btn-lg"));
		
		private final String title;
		private final By by;
		
		private HomeTrainingPageElements(String title, By by)
		{
			this.title = title;
			this.by = by;
		}
		
		public By getLocator() 
		{
			return (by);
		}
	}
	
	
	public YourNamePage clickCustomerLogin() 
	{
		SeleniumUtils.clickElement(customerLoginBtn);
		return new YourNamePage();
	}
	
	public void clickBankManager() 
	{
		SeleniumUtils.clickElement(HomeTrainingPageElements.BANK_MANAGER.getLocator());
	}
	
}
