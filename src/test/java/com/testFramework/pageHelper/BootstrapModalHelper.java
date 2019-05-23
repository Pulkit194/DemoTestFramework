package com.testFramework.pageHelper;

import com.testFramework.locators.Locators;
import com.testFramework.utils.DriverTest;

public class BootstrapModalHelper extends DriverTest{

	public void clickSingleModalLaunchModal() {
		String str=Locators.alertModalsDropdown.SINGLEMODALLAUNCH.value;
		onClick(str);
	}
	
	public void clickSingleModalClose() throws InterruptedException {
		String str=Locators.alertModalsDropdown.CLICKSINGLECLOSE.value;
		WaitForElementPresent(str, 2000);
		Thread.sleep(2000);
		onClick(str);
		Thread.sleep(2000);
		
	}
	
	
}
