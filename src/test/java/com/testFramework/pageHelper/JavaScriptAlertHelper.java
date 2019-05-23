package com.testFramework.pageHelper;

import com.testFramework.locators.Locators;
import com.testFramework.utils.DriverTest;

public class JavaScriptAlertHelper extends DriverTest{
	
	public void assertJavaScriptAlertBox() throws InterruptedException {
		String str=Locators.alertModalsDropdown.ALERTBOX.value;
		onClick(str);
		Thread.sleep(5000);
		
	}
	
	public void assertJavaScriptConfirmBox() throws InterruptedException
	{
		String str=Locators.alertModalsDropdown.JAVASCRIPTCONFIRMMECLICKME.value;
		onClick(str);
		Thread.sleep(5000);
		
	}
	
	public void assertJavaScriptSendKeys() throws InterruptedException {
		String str=Locators.alertModalsDropdown.JAVASCRIPTSENDKEYS.value;
		onClick(str);
		Thread.sleep(5000);
		
	}
	

}
