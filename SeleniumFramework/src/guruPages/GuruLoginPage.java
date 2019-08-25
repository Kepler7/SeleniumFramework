package guruPages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;

import helper.SeleniumUtils;
import helper.StartWebDriver;

public class GuruLoginPage extends StartWebDriver
{
	public enum GuruLoginPageElements
	{
		USER_ID("user id",By.cssSelector("input[name='uid']")),
		PASSWORD("password", By.cssSelector("input[name='password']")),
		LOGIN_BUTTON("login button", By.cssSelector("input[name='btnLogin']")),
		RESET_BUTTON("reset button", By.cssSelector("input[name='btnReset']"));
		
		private final String name;
		private final By by;
		
		private GuruLoginPageElements(String name, By by) 
		{
			this.name = name;
			this.by = by;
		}
		
		public By getLocator() 
		{
			return (by);
		}
	}
	
	private TreeSet<Object> getPropertyKeys()
	{
		loadCredentials();
		Set<Object> c =propCredentials.keySet();
		TreeSet<Object> tree = new TreeSet<>(c);
		return tree;
	}
	
	public String getNewUser() throws FileNotFoundException, IOException 
	{
		int number = 0;
		
		TreeSet<Object> tree = getPropertyKeys();
		String user;
		String keyUser = "";
		for(Object item : tree)
		{
			user = "mngr21103"+ number;
			keyUser = "user"+ number;
			if(item.toString().equalsIgnoreCase(keyUser)) 
			{
				number++;
			}
		}
		user = "mngr21103"+ number;
		keyUser = "user"+ number;
		File file = new File(System.getProperty("user.dir")+"\\src\\executables\\credentials.properties");
		propCredentials.setProperty(keyUser, user);
		propCredentials.store(new FileOutputStream(file), "users");
		return propCredentials.getProperty(keyUser);
	}
	
	private List<String> getUserNPassword() 
	{
		String[] array = {"mngr219316","AsunUzU"};
		return Arrays.asList(array);
	}
	
	public void enterUser() 
	{
		SeleniumUtils.sendKeysTo(GuruLoginPageElements.
				USER_ID.getLocator(), getUserNPassword().get(0));
	}
	
	public void enterNewUser() throws FileNotFoundException, IOException 
	{
		SeleniumUtils.sendKeysTo(GuruLoginPageElements.
				USER_ID.getLocator(), getNewUser());
	}
	
	public void enterPassword() 
	{
		SeleniumUtils.sendKeysTo(GuruLoginPageElements.
				PASSWORD.getLocator(), getUserNPassword().get(1));
	}
	
	public void clickLogin() 
	{
		SeleniumUtils.clickElement(GuruLoginPageElements.LOGIN_BUTTON.getLocator());
	}
	
	public void clickReset() 
	{
		SeleniumUtils.clickElement(GuruLoginPageElements.RESET_BUTTON.getLocator());
	}
	
}