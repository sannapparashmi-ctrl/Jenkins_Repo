package com.qa.usermanagement.utilities;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.qa.usermanagement.validation.ValuesValidation;

public class BrowserActions extends BaseUtility {

	public BrowserActions(WebDriver driver) {
		super(driver);
	}

	public WebElement locateElement(By locator) {
		ValuesValidation.validateLocator("locateElement", locator);
		WebElement element = driver.findElement(locator);
		return element;
	}

	public List<WebElement> locateElements(By locator) {
		ValuesValidation.validateLocator("locateElements", locator);
		List<WebElement> elements = driver.findElements(locator);
		return elements;
	}

	public Set<String> getAllTabAddress() {
		Set<String> allTabAdress = driver.getWindowHandles();
		Reporter.log("The tabAdress is\t" + allTabAdress);
		return allTabAdress;
	}

	public String getParentTabAddress() {
		String parentTabAdress = driver.getWindowHandle();
		Reporter.log("The parentTabAdress is\t" + parentTabAdress);
		return parentTabAdress;
	}

	public void enterUrl(String url) {
		ValuesValidation.validateStringInput("enterUrl", url);
		Reporter.log("The entered url is\t" + url, true);
		driver.get(url);
	}

	public String fetchTitle() {
		String title = driver.getTitle();
		Reporter.log("The page title is\t" + title, true);
		return title;
	}

	public String fetchPageUrl() {
		String pageUrl = driver.getCurrentUrl();
		Reporter.log("The pageUrl is\t" + pageUrl, true);
		return pageUrl;
	}

	public void navigateToPage(String url) {
		ValuesValidation.validateStringInput("navigateToPage", url);
		Reporter.log("The entered url is\t" + url, true);
		driver.navigate().to(url);
	}

	public void navigateToBack() {
		driver.navigate().back();
	}

	public void navigateToForward() {
		driver.navigate().forward();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void minimizeBrowser() {
		driver.manage().window().minimize();
	}

	public void fullscreenBrowser() {
		driver.manage().window().fullscreen();
	}

	public void closeTab() {
		driver.close();
	}

	public void terminateBrowser() {
			driver.quit();
		
	}
}
