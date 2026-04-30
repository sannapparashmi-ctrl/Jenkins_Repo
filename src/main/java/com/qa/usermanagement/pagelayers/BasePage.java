package com.qa.usermanagement.pagelayers;
import org.openqa.selenium.WebDriver;

import com.qa.usermanagement.utilities.ElementActions;
public class BasePage {
	protected WebDriver driver;
	protected ElementActions elementActions;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		elementActions = new ElementActions(driver);
	}
}
