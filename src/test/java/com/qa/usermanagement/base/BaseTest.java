package com.qa.usermanagement.base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.usermanagement.browserfactory.BrowserManager;
import com.qa.usermanagement.pagelayers.LoginPage;
import com.qa.usermanagement.pagelayers.RegistrationPage;
import com.qa.usermanagement.utilities.BrowserActions;
import com.qa.usermanagement.utilities.CaptureScreenshot;
import com.qa.usermanagement.utilities.ReadConfigFile;
//@Listeners({com.qa.usermanagement.listeners.AllureListeners.class, ChainTestListener.class})
public class BaseTest {
	private WebDriver driver;
	private BrowserActions driverActions;
	protected LoginPage loginPg;
	protected RegistrationPage registerationPg;
	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	
	@Parameters({ "browserName", "browserHeadless", "browserPrivate" })
	@BeforeClass
	public LoginPage launchApplication(String browserName1, String browserHeadless1, String browserPrivate1)
			throws IOException {
		BrowserManager driverManager = new BrowserManager();
		ReadConfigFile configFile = new ReadConfigFile();
		configFile.setProperty("browserName", browserName1);
		configFile.setProperty("browserHeadless", browserHeadless1);
		configFile.setProperty("browserPrivate", browserPrivate1);
		String browserName = configFile.getProperty("browserName");
		String browserHeadless = configFile.getProperty("browserHeadless");
		String browserPrivate = configFile.getProperty("browserPrivate");
		boolean headlessValue = Boolean.parseBoolean(browserHeadless);
		boolean privateValue = Boolean.parseBoolean(browserPrivate);
		driver = driverManager.initDriver(browserName, headlessValue, privateValue);
		logger.info("Browser has been launched with parameters"+"\t"+browserName+"\t"+headlessValue+"\t"+privateValue);
		driver = BrowserManager.getDriver();
		driverActions = new BrowserActions(driver);
		String url = configFile.getProperty("testUrl");
		driverActions.enterUrl(url);
		logger.info("Browser has been entered with url"+"\t"+url);
		loginPg = new LoginPage(driver);
		return loginPg;
	}

	@AfterMethod
	public void attachScreenshot(ITestResult result) {
		if (!result.isSuccess()) {
			Reporter.log("The screenshot is captured for failed test\t" + result.getName(), true);
			ChainTestListener.embed(CaptureScreenshot.getScreenshotFile(driver), "image/png");
//	        CaptureScreenshot.getScreenshotBytes(driver);
			logger.info("Screenshot is captured for failure testcase"+"\t"+result.getName());

		}
	}

	@AfterClass(enabled = true)
	public void tearDownBrowser() {
		if (!(driver == null)) {
			Reporter.log("Terminating browser after all test classes executed", true);
			driverActions.terminateBrowser();
			logger.info("Browser is terminated");
		}
	}

}










