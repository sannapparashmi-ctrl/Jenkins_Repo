package com.qa.usermanagement.pagelayers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	final private By usnTf = By.id("username");
	final private By pswTf = By.id("password");
	final private By loginBtn = By.id("button-login-submit");
	final private By createAccLink = By.id("link-login-to-register");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Step("checkUsnElementDisplayed")
	public boolean checkUsnElementDisplayed() {
		return elementActions.checkElementDisplayed("checkUsnElement", usnTf);
	}
	@Step("checkPswElementDisplayed")
	public boolean checkPswElementDisplayed() {
		return elementActions.checkElementDisplayed("checkPswElement", pswTf);
	}
	@Step("checkLoginElementDisplayed")
	public boolean checkLoginElementDisplayed() {
		return elementActions.checkElementDisplayed("checkLoginElement", loginBtn);
	}
	@Step("checkCreateAccElementDisplayed")
	public boolean checkCreateAccElementDisplayed() {
		return elementActions.checkElementDisplayed("checkCreateAccElement", createAccLink);
	}
	@Step("checkUsnElementEnabled")
	public boolean checkUsnElementEnabled() {
		return elementActions.checkElementEnabled("checkUsnElementEnabled", usnTf);
	}
	@Step("checkPswElementEnabled")
	public boolean checkPswElementEnabled() {
		return elementActions.checkElementEnabled("checkPswElementEnabled", pswTf);
	}
	@Step("checkLoginElementEnabled")
	public boolean checkLoginElementEnabled() {
		return elementActions.checkElementEnabled("checkLoginElementEnabled", loginBtn);
	}
	@Step("checkCreateAccElementEnabled")
	public boolean checkCreateAccElementEnabled() {
		return elementActions.checkElementEnabled("checkCreateAccElementEnabled", createAccLink);
	}
	@Step("doLogin")
	public void doLogin(String usn, String psw) {
		elementActions.enterValues(usnTf, usn);
		elementActions.enterValues(pswTf, psw);
		elementActions.doClick(loginBtn);
	}
	@Step("navigateToRegisterationPage")
	public RegistrationPage navigateToRegisterationPage() {
		elementActions.doClick(createAccLink);
		return new RegistrationPage(driver);
	}

}
