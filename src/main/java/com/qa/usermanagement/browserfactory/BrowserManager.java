package com.qa.usermanagement.browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

import com.qa.usermanagement.errors_exceptionmsg.ErrorMessages;
import com.qa.usermanagement.exceptions.FrameworkExceptions;

public class BrowserManager {
	static ThreadLocal<WebDriver> localDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(String browserName,Boolean headLess, Boolean privateTab) {
		browserName = browserName.toLowerCase().trim();
		Reporter.log( ErrorMessages.passedBrowserName+ browserName, true);
		switch (browserName) {
		case "chrome":
			ChromeOptions flag = BrowserOptions.chromeOptions(headLess, privateTab);
			localDriver.set(new ChromeDriver(flag));
			break;
		case "firefox":
			FirefoxOptions flag1 = BrowserOptions.firefoxOptions(headLess, privateTab);
			localDriver.set(new FirefoxDriver(flag1));
			break;
		case "edge":
			EdgeOptions flag3 = BrowserOptions.edgeOptions(headLess, privateTab);
			localDriver.set(new EdgeDriver(flag3));
			break;
		default:
			Reporter.log(ErrorMessages.invalidBrowserMsg+ browserName, true);
			throw new FrameworkExceptions(ErrorMessages.invalidBrowserException);
		}
		return getDriver();
	}
	public static WebDriver getDriver() {
		return localDriver.get();
	}
}
