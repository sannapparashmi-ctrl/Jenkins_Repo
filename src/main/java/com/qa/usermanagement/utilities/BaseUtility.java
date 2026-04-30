package com.qa.usermanagement.utilities;

import org.openqa.selenium.WebDriver;

public class BaseUtility {
	protected WebDriver driver;
	protected WaitStrategy fluentWait;
	public BaseUtility(WebDriver driver) {
		this.driver=driver;
		 fluentWait = new WaitStrategy(driver);
	}
}
