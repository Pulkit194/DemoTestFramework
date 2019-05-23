package com.testFramework.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DriverTest extends DriverTestCase {

	protected PropertyReader propertyReader = new PropertyReader();

	// ===============To wait till the element(locator) displays

	public WebElement getWhenVisible(String locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByLocator(locator)));
		return element;
	}

	// ============================================== To verify Element present on
	// the screen
	public boolean isElementPresent(String locator) {
		Boolean result = false;

		if (driver.findElement(ByLocator(locator)).isDisplayed()) {
			result = true;
		} else {
			driver.manage().timeouts().implicitlyWait(3000000, TimeUnit.SECONDS);
		}
		return result;
	}

	// ============================================= To Click on the element
	public void onClick(String locator) {
		isElementPresent(locator, 5);
		// this.WaitForElementPresent(locator, 50);
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(ByLocator(locator)));
		driver.findElement(ByLocator(locator)).click();
	}

	// ============================================= To verify text of the element
	public boolean isTextPresent(String locator, String str) {
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		// String message = getWebDriver().findElement(ByLocator(locator)).getText();
		String message = driver.findElement(ByLocator(locator)).getText();
		if (message.contains(str)) {
			return true;
		} else {
			return false;
		}
	}

	// ============================================= To locate the element
	public By ByLocator(String locator) {
		By result = null;
		if (locator.startsWith("//") || (locator.startsWith("/") || locator.startsWith("(//"))) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.name(locator.replace("#", ""));
		} else if (locator.startsWith("Link=")) {
			result = By.linkText(locator.replace("Link=", ""));
		} else {
			result = By.id(locator);
		}
		return result;
	}

	// ========================================== To print
	public void print(String printString) {
		System.out.println(printString);
	}

	// ========================================== Wait for Element Present
	public void WaitForElementPresent(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator, 0)) {
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// ========================================= Is Element Present
	public boolean isElementPresent(String locator, Integer timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		return driver.findElements(ByLocator(locator)).size() != 0;
	}

	// ========================================== select drop down options by
	// mentioning text
	public void selectValueFromDropdown(String locator, String targetValue) {
		// this.WaitForElementPresent(locator, 30);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ByLocator(locator)));
		new Select(driver.findElement(ByLocator(locator))).selectByVisibleText(targetValue);

	}
	// ======================================Getting the text

	public String getText(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ByLocator(locator)));
		String onScreenText = driver.findElement(ByLocator(locator)).getText();
		return onScreenText;
	}

	// ===========================Selecting last

	public String selectLastIndexOfString(String str) {
		String trimmedString;
		trimmedString = str.substring(str.lastIndexOf(" ") + 1);
		return trimmedString;
	}
	
	//==============================Action Class
	/*Actions action = new Actions(driver);	
	public void holdCTRLKey() {
	action.keyDown(Keys.LEFT_CONTROL);	
	}
	
	*/

}