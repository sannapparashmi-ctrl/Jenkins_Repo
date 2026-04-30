package com.qa.usermanagement.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.usermanagement.base.BaseTest;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Usermanagement-1.0.1")
@Feature("SRS-1.0.1_Login")
@Story("FS-1.0.1_Login")
public class LoginTest extends BaseTest {
	@Test(priority = Integer.MIN_VALUE)
	@Owner("Rahul_ATE001")
	@Severity(SeverityLevel.CRITICAL)
	@Description("loginSmokeTest validates all elements in UI page")
	public void loginSmokeTest() {
		
		boolean usnElementFlag = loginPg.checkUsnElementDisplayed();
		Assert.assertTrue(usnElementFlag);
		Reporter.log("usnElementFlag is true \t|checkUsnElementDisplayed passed", true);
		ChainTestListener.log("usnElementFlag is true \t|checkUsnElementDisplayed passed");
		Allure.step("usnElementFlag is true \t|checkUsnElementDisplayed passed");

		
		boolean pswElementFlag = loginPg.checkPswElementDisplayed();
		Assert.assertTrue(pswElementFlag);
		Reporter.log("pswElementFlag is true \t|checkPswElementDisplayed passed", true);
		ChainTestListener.log("pswElementFlag is true \t|checkPswElementDisplayed passed");
		Allure.step("pswElementFlag is true \t|checkPswElementDisplayed passed");

		boolean loginElementFlag = loginPg.checkLoginElementDisplayed();
		Assert.assertTrue(loginElementFlag);
		Reporter.log("loginElementFlag is true \t|checkLoginElementDisplayed passed", true);
		ChainTestListener.log("loginElementFlag is true \t|checkLoginElementDisplayed passed");
		Allure.step("loginElementFlag is true \t|checkLoginElementDisplayed passed");

		boolean createAccElementFlag = loginPg.checkCreateAccElementDisplayed();
		Assert.assertTrue(createAccElementFlag);
		Reporter.log("createAccElementFlag is true \t|checkCreateAccElementDisplayed passed", true);
		ChainTestListener.log("createAccElementFlag is true \t|checkCreateAccElementDisplayed passed");
		Allure.step("createAccElementFlag is true \t|checkCreateAccElementDisplayed passed");

		boolean usnElementFlag1 = loginPg.checkUsnElementEnabled();
		Assert.assertTrue(usnElementFlag1);
		Reporter.log("usnElementFlag1 is true \t|checkUsnElementEnabled passed", true);
		ChainTestListener.log("usnElementFlag1 is true \t|checkUsnElementEnabled passed");
		Allure.step("usnElementFlag1 is true \t|checkUsnElementEnabled passed");

		boolean pswElementFlag1 = loginPg.checkPswElementEnabled();
		Assert.assertTrue(pswElementFlag1);
		Reporter.log("pswElementFlag1 is true \t|checkPswElementEnabled passed", true);
		ChainTestListener.log("pswElementFlag1 is true \t|checkPswElementEnabled passed");
		Allure.step("pswElementFlag1 is true \t|checkPswElementEnabled passed");

		boolean loginElementFlag1 = loginPg.checkLoginElementEnabled();
		Assert.assertTrue(loginElementFlag1);
		Reporter.log("loginElementFlag1 is true \t|checkLoginElementEnabled passed", true);
		ChainTestListener.log("loginElementFlag1 is true \t|checkLoginElementEnabled passed");
		Allure.step("loginElementFlag1 is true \t|checkLoginElementEnabled passed");

		boolean createAccElementFlag1 = loginPg.checkCreateAccElementEnabled();
		Assert.assertTrue(createAccElementFlag1);
		Reporter.log("createAccElementFlag1 is true \t|checkCreateAccElementEnabled passed", true);
		ChainTestListener.log("createAccElementFlag1 is true \t|checkCreateAccElementEnabled passed");
		Allure.step("createAccElementFlag1 is true \t|checkCreateAccElementEnabled passed");

	}

	@Test(dependsOnMethods = "loginSmokeTest")
	@Owner("Rahul_ATE001")
	@Severity(SeverityLevel.CRITICAL)
	@Description("validateLogin validates login functionality")
	public void validateLogin() {
		loginPg.doLogin("Admin", "Admin123");
		ChainTestListener.log("validateLogin test is passed");
		Allure.step("validateLogin test is passed");

		Assert.fail();
	}

}
