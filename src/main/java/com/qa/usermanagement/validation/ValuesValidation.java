package com.qa.usermanagement.validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.usermanagement.errors_exceptionmsg.ErrorMessages;
import com.qa.usermanagement.exceptions.ElementExceptions;

public class ValuesValidation {

	public static void validateLocator(String methodName, By locator) {
		if (methodName == null) {
			throw new ElementExceptions(ErrorMessages.validateMethodNameException);
		}
		if (locator == null) {
			throw new ElementExceptions("===[ValuesValidation-validateLocator]The locator cannot be null===");
		}
	}

	public static void validateElement(String methodName, WebElement element) {
		if (methodName == null) {
			throw new ElementExceptions(ErrorMessages.validateMethodNameException);
		}
		if (element == null) {
			throw new ElementExceptions("===[ValuesValidation-validateElement]The element cannot be null===");
		}
	}

	public static void validateStringInput(String methodName, String input) {
		if (methodName == null) {
			throw new ElementExceptions(ErrorMessages.validateMethodNameException);
		}
		if (input == null) {
			throw new ElementExceptions("===[ValuesValidation-validateStringInput]The value cannot be null===");
		}
	}
}
