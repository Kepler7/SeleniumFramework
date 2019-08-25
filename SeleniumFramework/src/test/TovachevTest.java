package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.todvachevpages.DropDownMenuTestPage;
import com.todvachevpages.SpecialElementsPage;
import com.todvachevpages.TodvachevHomePage;

public class TovachevTest extends TestBase
{
	@Test(enabled = false)
	public void SelectMercedesTest() 
	{
		TodvachevHomePage tov = new TodvachevHomePage();
		SpecialElementsPage elements = tov.clickSpecialElements();
		DropDownMenuTestPage dropDown = elements.clickDropDownMenuTest();
		dropDown.selectMercedesOption();
	}
}
