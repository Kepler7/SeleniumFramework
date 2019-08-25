package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import flows.GuruFlows;
import guruPages.GuruLoginPage;
import webObjects.HeaderMenu;
import webObjects.ManagerMenu;

public class FirstTest extends TestBase
{


	public void firstTest() throws InterruptedException 
	{
		GuruFlows.GuruLoginFlow();
		ManagerMenu menu = new ManagerMenu();
		menu.clickByText("Delete Customer");;
		HeaderMenu header = new HeaderMenu();
		header.clickByText("Agile Project");
		
	}
	
	@Test
	public void configTest() throws InterruptedException, FileNotFoundException, IOException 
	{
		GuruLoginPage page = new GuruLoginPage();
		page.enterPassword();
		page.enterPassword();
		page.clickLogin();
	}
}

