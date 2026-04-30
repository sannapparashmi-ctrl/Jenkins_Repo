package com.qa.usermanagement.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import io.qameta.allure.Step;

public class RegistrationPage extends BasePage {

	By usnTf = By.id("username");
	By fullnameTf = By.id("fullname");
	By emailTf = By.id("email");
	By passwordTf = By.id("password");
	By registerBtn = By.id("submit");
	By loginLink = By.id("link-register-to-login");
	By registrationSuccess = By.id("registration-success-message");
	By registrationFailure = By.id("registration-error-message");

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@Step("checkUsnElement")
	public boolean checkUsnElement() {
		if (elementActions.checkElementDisplayed("checkUsnElement", emailTf)) {
			Reporter.log("checkUsnElementDisplayed | Passed", true);
			if (elementActions.checkElementEnabled("checkUsnElement", emailTf)) {
				Reporter.log("checkUsnElementENabled | Passed", true);
				return true;
			}
		}
		return false;
	}
	@Step("checkFullnameElement")
	public boolean checkFullnameElement() {
		boolean checkFullnameElementDisplayed = elementActions.checkElementDisplayed("checkFullnameElement",
				fullnameTf);
		boolean checkFullnameElementEnabled = elementActions.checkElementEnabled("checkFullnameElement", fullnameTf);
		if (!checkFullnameElementDisplayed) {
			Reporter.log("checkFullnameElementDisplayed | Failed", true);
		}
		if (!checkFullnameElementEnabled) {
			Reporter.log("checkFullnameElementEnabled | Failed", true);
		}
		return checkFullnameElementDisplayed && checkFullnameElementEnabled;
	}
	@Step("checkEmailElement")
	public boolean checkEmailElement() {
		boolean checkEmailElementDisplayed = elementActions.checkElementDisplayed("checkEmailElement", fullnameTf);
		boolean checkEmailElementEnabled = elementActions.checkElementEnabled("checkEmailElement", emailTf);
		if (!checkEmailElementDisplayed) {
			Reporter.log("checkFullnameElementDisplayed | Failed", true);
		}
		if (!checkEmailElementEnabled) {
			Reporter.log("checkFullnameElementEnabled | Failed", true);
		}
		return checkEmailElementDisplayed && checkEmailElementEnabled;
	}
	@Step("checkPasswordElement")
	public boolean checkPasswordElement() {
		boolean checkPasswordElementDisplayed = elementActions.checkElementDisplayed("checkPasswordElement",
				fullnameTf);
		boolean checkPasswordElementEnabled = elementActions.checkElementEnabled("checkPasswordElement", passwordTf);
		if (!checkPasswordElementDisplayed) {
			Reporter.log("checkPasswordElement | Failed", true);
		}
		if (!checkPasswordElementEnabled) {
			Reporter.log("checkPasswordElement | Failed", true);
		}
		return checkPasswordElementDisplayed && checkPasswordElementEnabled;
	}
	@Step("checkRegisterElement")
	public boolean checkRegisterElement() {
		boolean checkRegisterElementDisplayed = elementActions.checkElementDisplayed("checkRegisterElement",
				fullnameTf);
		boolean checkRegisterElementEnabled = elementActions.checkElementEnabled("checkRegisterElement", registerBtn);
		if (!checkRegisterElementDisplayed) {
			Reporter.log("checkPasswordElement | Failed", true);
		}
		if (!checkRegisterElementEnabled) {
			Reporter.log("checkPasswordElement | Failed", true);
		}
		return checkRegisterElementDisplayed && checkRegisterElementEnabled;
	}
	@Step("checkLoginElement")
	public boolean checkLoginElement() {
		boolean checkLoginElementDisplayed = elementActions.checkElementDisplayed("checkLoginElement", fullnameTf);
		boolean checkLoginElementEnabled = elementActions.checkElementEnabled("checkLoginElement", loginLink);
		if (!checkLoginElementDisplayed) {
			Reporter.log("checkPasswordElement | Failed", true);
		}
		if (!checkLoginElementEnabled) {
			Reporter.log("checkPasswordElement | Failed", true);
		}
		return checkLoginElementDisplayed && checkLoginElementEnabled;
	}
	@Step("doRegister")
	public String doRegister(String userName, String fullName, String email, String password) {
		Reporter.log("The entered is :\t" + "\tuserName :" + userName + "\tfullName :" + fullName + "\temail :" + email
				+ "\tpassword :" + password, true);
		elementActions.enterValues(usnTf, userName);
		elementActions.enterValues(fullnameTf, fullName);
		elementActions.enterValues(emailTf, email);
		elementActions.enterValues(passwordTf, password);
		elementActions.doClick(registerBtn);
		boolean res = elementActions.checkElementDisplayed("doRegister", registrationSuccess);
		if (res) {
			String textValue = elementActions.fetchElementText("doRegister", registrationSuccess);
			Reporter.log("Text value of registrationSuccess is\t" + textValue, true);
			return textValue;
		} else {
			boolean res1 = elementActions.checkElementDisplayed("doRegister", registrationFailure);
			if (res1) {
				String textValue = elementActions.fetchElementText("doRegister", registrationFailure);
				Reporter.log("Text value of registrationFailure is\t" + textValue, true);
				return textValue;
			}
		}
		return "Method executed";
	}
}
