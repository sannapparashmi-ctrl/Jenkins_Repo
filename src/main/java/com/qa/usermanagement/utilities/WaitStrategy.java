package com.qa.usermanagement.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitStrategy {

	private FluentWait<WebDriver> fluentWait;

	public WaitStrategy(WebDriver driver) {
		fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
	}

	public WebElement checkForElementPresence(By locator) {
		return fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForVisibility(By locator) {
		return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForClickable(By locator) {
		return fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public Boolean checkTitle(String inputTitle) {
		return fluentWait.until(ExpectedConditions.titleContains(inputTitle));
	}

	public Boolean checkUrl(String inputUrl) {
		return fluentWait.until(ExpectedConditions.urlContains(inputUrl));
	}
}
