package com.testFramework.pageHelper;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.testFramework.locators.Locators;
import com.testFramework.utils.DriverTest;
import com.testFramework.utils.DriverTestCase;

public class HomepageHelper extends DriverTest {
	public void assertHomepage() {
		print("Home page Launch");
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.seleniumeasy.com/test/");
	}

	public void clickInputFormDropdown() {
		print("Clicking InputFormDropdown");
		String str = Locators.Menu.INPUTFORM.value;
		getWhenVisible(str, 5);
		onClick(str);
	}
	
	public void clickAlertsModalMenuOption() {
		
		String str=Locators.Menu.ALERTSMODALS.value;
		onClick(str);
	}

	public void JavaScriptAlert() {
		String str=Locators.alertModalsDropdown.JAVASCRIPTALERTS.value;
		onClick(str);				
	}
	
	public void clickBootstrapModal() {
		String str=Locators.alertModalsDropdown.BOOTSTRAPMODALS.value;	
	    onClick(str);		
	}
}