package com.testFramework.scripts;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.testFramework.pageHelper.SelectDropdownHelper;
import com.testFramework.utils.DriverTestCase;

public class Selenium_Assignment_Framework extends DriverTestCase {
	
	@Test (priority=1)
	public void verifySingleSelect() {
		homepagehelper.assertHomepage();
		homepagehelper.clickInputFormDropdown();
		selectDropdownHelper.clickOnDropdownMenu();
		selectDropdownHelper.selectDropdownValue();
	}	
	
	@Test (priority=2, dependsOnMethods="verifySingleSelect")
	public void verifyMultipleSelect() throws InterruptedException {
		homepagehelper.assertHomepage();
		homepagehelper.clickInputFormDropdown();
		selectDropdownHelper.clickOnDropdownMenu();
		selectDropdownHelper.assertmultiselect();
	}
	
	@Test (priority=3)
	public void verifyJavaScriptAlertOK() throws InterruptedException {
		homepagehelper.assertHomepage();
		homepagehelper.clickAlertsModalMenuOption();
		homepagehelper.JavaScriptAlert();
		javaScriptAlertHelper.assertJavaScriptAlertBox();
		driver.switchTo().alert().accept();		
	}
	
	@Test (priority=4)
	public void verifyJavaScriptConfirmBoxCancel() throws InterruptedException {
		homepagehelper.assertHomepage();
		homepagehelper.clickAlertsModalMenuOption();
		homepagehelper.JavaScriptAlert();
		javaScriptAlertHelper.assertJavaScriptConfirmBox();
		driver.switchTo().alert().dismiss();
	}

	@Test (priority=5)
	public void verifyJavaScriptAlertSendData() throws InterruptedException {
		homepagehelper.assertHomepage();
		homepagehelper.clickAlertsModalMenuOption();
		homepagehelper.JavaScriptAlert();
		javaScriptAlertHelper.assertJavaScriptSendKeys();
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("Data for Testing");
		alert.getText();
		Thread.sleep(5000);
		alert.accept();
	}
	
	@Test (priority=6)
	public void verifyBootstrapModal() throws InterruptedException {
		homepagehelper.assertHomepage();
		homepagehelper.clickAlertsModalMenuOption();
		homepagehelper.clickBootstrapModal();
		bootstrapModalHelper.clickSingleModalLaunchModal();
		bootstrapModalHelper.clickSingleModalClose();		
	}

}
