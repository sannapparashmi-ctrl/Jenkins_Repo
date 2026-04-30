package com.qa.usermanagement.browserfactory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

public class BrowserOptions {

	public static ChromeOptions chromeOptions(Boolean headLess, Boolean privateTab) {
		ChromeOptions chromeOpts = new ChromeOptions();
		if (headLess) {
			Reporter.log("Running chrome browser in headless mode",true);
			chromeOpts.addArguments("--headless");
		}
		if (privateTab) {
			Reporter.log("Running chrome browser in private mode",true);
			chromeOpts.addArguments("--incognito");
		}
		return chromeOpts;
	}

	public static FirefoxOptions firefoxOptions(Boolean headLess, Boolean privateTab) {
		FirefoxOptions firefoxOpts = new FirefoxOptions();
		if (headLess) {
			Reporter.log("Running firefox browser in headless mode",true);
			firefoxOpts.addArguments("--headless");
		}
		if (privateTab) {
			Reporter.log("Running firefox browser in private mode",true);
			firefoxOpts.addArguments("-private");
		}
		return firefoxOpts;
	}

	public static EdgeOptions edgeOptions(Boolean headLess, Boolean privateTab) {
		EdgeOptions edgeOptions = new EdgeOptions();
		if (headLess) {
			Reporter.log("Running edge browser in headless mode",true);
			edgeOptions.addArguments("--headless");
		}
		if (privateTab) {
			Reporter.log("Running edge browser in private mode",true);
			edgeOptions.addArguments("--inprivate");
		}
		return edgeOptions;
	}
}
