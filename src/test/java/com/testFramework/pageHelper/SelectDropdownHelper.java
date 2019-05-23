package com.testFramework.pageHelper;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.testFramework.locators.Locators;
import com.testFramework.utils.DriverTest;

public class SelectDropdownHelper extends DriverTest{

	
	public void clickOnDropdownMenu() {
		print("Clicking DropdownMenu");
		String locator = Locators.InputForm.SELECTDROPDOWN.value;
		onClick(locator);
		
	}
		
	public String selectDropdownValue() {
		print("Selecting dropdown value");
		String str = Locators.SelectListDemo.SELECTLISTDEMO.value;
		isElementPresent(str,5);
		String day = "Sunday";
		selectValueFromDropdown(str, day);
		return day;
	}
		
		public void assertDaySelected() {
			print("Asserting dropdown value");
			String str=Locators.SelectListDemo.DAYSSELECTED.value;		
			String text=getText(str);			
			print(text);
			Assert.assertEquals(selectLastIndexOfString(text), selectDropdownValue());
		}	
		
		public void assertmultiselect() throws InterruptedException
		{
			String str=Locators.SelectMultipleList.SELECTMULTIPLELIST.value;
			Actions action = new Actions(driver);
			action.keyDown(Keys.LEFT_CONTROL);
			selectValueFromDropdown(str, "New Jersey");
			selectValueFromDropdown(str, "California");
			action.keyUp(Keys.LEFT_CONTROL);
			
			String str2=Locators.SelectMultipleList.GETALLSELECTED.value;
			onClick(str2);
			//Thread.sleep(5000);
			//String str3=Locators.SelectMultipleList.OPTIONSSELECTED.value;
			//str3=selectLastIndexOfString(str3);
			//print("Print:"+ str3);
			
			//assert.assertEquals("Florida", );
			
		}
		
}
