package com.testFramework.utils;

import java.io.File;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.testFramework.pageHelper.BootstrapModalHelper;
import com.testFramework.pageHelper.HomepageHelper;
import com.testFramework.pageHelper.JavaScriptAlertHelper;
import com.testFramework.pageHelper.SelectDropdownHelper;


public class DriverTestCase {
	
	enum BrowserName{
		Chrome, IE, Firefox; 
			}
	protected PropertyReader propertyReader = new PropertyReader();
	//protected WebDriver driver;
	public static WebDriver driver;
	protected String locator;
	protected HomepageHelper homepagehelper;
	protected SelectDropdownHelper selectDropdownHelper;
	protected JavaScriptAlertHelper javaScriptAlertHelper;
	protected BootstrapModalHelper bootstrapModalHelper;
//=====================================================	
	@BeforeMethod
	public void setUp() {
		
		String driverType = propertyReader.readApplicationFile("BROWSER");

		if (BrowserName.Firefox.toString().equals(driverType)) {
			driver = new FirefoxDriver();

		} else if (BrowserName.IE.toString().equals(driverType)) {
			driver = new InternetExplorerDriver();

		} else if (BrowserName.Chrome.toString().equals(driverType)) {
			String path1 = getPath();
			String chromeDriverPath = path1 + "//Browsers//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);

		} else {
			String path1 = getPath();
			String chromeDriverPath = path1 + "//Browsers//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
		}
		
		String url = propertyReader.readApplicationFile("URL");		
		//getWebDriver().manage().window().maximize();
		driver.manage().window().maximize();
		System.out.println("==>: "+url);
		//getWebDriver().navigate().to(url);
		driver.get(url);
		this.initializeHelpers();
	}
	
//=========================================================
		@AfterMethod
		public void tearDown() {
			driver.quit();
			driver = null;
			homepagehelper = null;
			selectDropdownHelper=null;
		}

		
//===========================================================		
		/*public WebDriver getWebDriver() {
			return driver;
		}*/
	
		
		public void initializeHelpers() {
			homepagehelper = new HomepageHelper();
			selectDropdownHelper=new SelectDropdownHelper();
			javaScriptAlertHelper=new JavaScriptAlertHelper();
			bootstrapModalHelper= new BootstrapModalHelper();
		}
		
		
		public String getPath() {
			String path = "";
			File file = new File("");
			String absolutePathOfFirstFile = file.getAbsolutePath();
			path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
			return path;
		}

		// Get UNC Path - \\host-name\drive-letter$\folder
		public String getUNC_Path() {
			String path = getPath();
			path = "\\\\" + getComputerName() + "/" + path.replace(":", "$");
			return path;
		}
		public String getComputerName() {
			Map<String, String> env = System.getenv();
			if (env.containsKey("COMPUTERNAME"))
				return env.get("COMPUTERNAME");
			else if (env.containsKey("HOSTNAME"))
				return env.get("HOSTNAME");
			else
				return "Unknown Computer";
		}

	

}
