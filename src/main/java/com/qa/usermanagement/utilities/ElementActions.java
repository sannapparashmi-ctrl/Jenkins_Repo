package com.qa.usermanagement.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.usermanagement.errors_exceptionmsg.ErrorMessages;
import com.qa.usermanagement.exceptions.ElementExceptions;
import com.qa.usermanagement.validation.ValuesValidation;

public class ElementActions extends BaseUtility {

	public ElementActions(WebDriver driver) {
		super(driver);
	}

	public void doClick(By locator) {
		ValuesValidation.validateLocator("doClick", locator);
		try {
			fluentWait.waitForClickable(locator).click();
		} catch (Exception e) {
			throw new ElementExceptions(ErrorMessages.doClickException);
		}
	}

	public void enterValues(By locator, String input) {
		ValuesValidation.validateLocator("enterValues", locator);
		ValuesValidation.validateStringInput("enterValues", input);
		try {
			fluentWait.waitForVisibility(locator).clear();
			fluentWait.waitForVisibility(locator).sendKeys(input);
		} catch (Exception e) {
			throw new ElementExceptions(ErrorMessages.enterValuesException);
		}
	}

	public void clearValues(By locator) {
		ValuesValidation.validateLocator("clearValues", locator);
		try {
			fluentWait.waitForVisibility(locator).clear();
		} catch (Exception e) {
			throw new ElementExceptions(ErrorMessages.clearValuesException);

		}
	}

//	isDisplayed(),isENabled(),isSelected()

	public boolean checkElementDisplayed(String methodName, By locator) {
		ValuesValidation.validateLocator(methodName, locator);
		try {
			return fluentWait.waitForVisibility(locator).isDisplayed();
		} catch (Exception e) {
			throw new ElementExceptions(ErrorMessages.checkElementDisplayedException);
		}
	}

	public boolean checkElementEnabled(String methodName, By locator) {
		ValuesValidation.validateLocator(methodName, locator);
		try {
			return fluentWait.waitForVisibility(locator).isEnabled();
		} catch (Exception e) {
			throw new ElementExceptions(ErrorMessages.checkElementEnabledException);
		}
	}

	public boolean checkElementSelected(String methodName, By locator) {
		ValuesValidation.validateLocator(methodName, locator);
		try {
			return fluentWait.waitForVisibility(locator).isSelected();
		} catch (Exception e) {
			throw new ElementExceptions(ErrorMessages.checkElementSelectedException);
		}
	}

	public String fetchElementText(String methodName, By locator) {
		ValuesValidation.validateLocator(methodName, locator);
		try {
			return fluentWait.waitForVisibility(locator).getText();
		} catch (Exception e) {
			throw new ElementExceptions(ErrorMessages.fetchElementTextException);
		}
	}

}
