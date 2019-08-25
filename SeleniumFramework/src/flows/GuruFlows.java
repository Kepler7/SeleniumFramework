package flows;

import guruPages.GuruLoginPage;
import helper.StartWebDriver;

public class GuruFlows extends StartWebDriver
{
	public static void GuruLoginFlow() 
	{
		GuruLoginPage guru = new GuruLoginPage();	
		guru.enterUser();
		guru.enterPassword();
		guru.clickLogin();
	}
}
