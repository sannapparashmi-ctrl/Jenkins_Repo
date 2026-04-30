package com.qa.usermanagement.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.usermanagement.base.BaseTest;
import com.qa.usermanagement.testData.RegistrationTestData;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Usermanagement-1.0.1")
@Feature("SRS-1.0.1_Registration")
@Story("FS-1.0.1_Registration")
public class RegisterationTest extends BaseTest {
	@Owner("Rahul_ATE001")
	@Severity(SeverityLevel.CRITICAL)
	@Description("getIntoRegistarationPage precondition")
	@BeforeClass
	public void getIntoRegistarationPage() {
		registerationPg = loginPg.navigateToRegisterationPage();
		Allure.step("getIntoRegistarationPage is executed");

	}

	@Owner("Rahul_ATE001")
	@Severity(SeverityLevel.CRITICAL)
	@Description("registationPgSmokeTest validates all elements in UI page")
	@Test(priority = Integer.MIN_VALUE)
	public void registationPgSmokeTest() {
		boolean usnElementRes = registerationPg.checkUsnElement();
		if (usnElementRes) {
			Assert.assertTrue(usnElementRes);
//			Reporter.log("usnElementRes is True", true);
		} else {
//			Reporter.log("usnElementRes is false", true);
		}

		boolean fullnameElementRes = registerationPg.checkFullnameElement();
		Assert.assertTrue(fullnameElementRes);
		if (fullnameElementRes) {
			Assert.assertTrue(fullnameElementRes);
//			Reporter.log("fullnameElementRes is True", true);
		} else {
//			Reporter.log("fullnameElementRes is false", true);
		}

		boolean emailElementRes = registerationPg.checkEmailElement();
		Assert.assertTrue(emailElementRes);
		if (emailElementRes) {
			Assert.assertTrue(emailElementRes);
//			Reporter.log("emailElementRes is True", true);
		} else {
//			Reporter.log("emailElementRes is false", true);
		}

		boolean passwordElementRes = registerationPg.checkPasswordElement();
		Assert.assertTrue(passwordElementRes);
		if (passwordElementRes) {
			Assert.assertTrue(passwordElementRes);
//			Reporter.log("passwordElementRes is True", true);
		} else {
//			Reporter.log("passwordElementRes is false", true);
		}

		boolean registerElementRes = registerationPg.checkRegisterElement();
		Assert.assertTrue(registerElementRes);
		if (registerElementRes) {
			Assert.assertTrue(registerElementRes);
//			Reporter.log("registerElementRes is True", true);
		} else {
//			Reporter.log("registerElementRes is false", true);
		}

		boolean loginElementRes = registerationPg.checkLoginElement();
		Assert.assertTrue(loginElementRes);
		if (loginElementRes) {
			Assert.assertTrue(loginElementRes);
//			Reporter.log("loginElementRes is True", true);
		} else {
//			Reporter.log("loginElementRes is false", true);
		}
		Allure.step("registationPgSmokeTest is executed");
		ChainTestListener.log("registationPgSmokeTest is executed");

	}
	@Owner("Rahul_ATE001")
	@Severity(SeverityLevel.CRITICAL)
	@Description("createUser validates creating user functionality")
	@Test(invocationCount = 1,dependsOnMethods = "registationPgSmokeTest", dataProvider = "generateData", dataProviderClass = RegistrationTestData.class)
	public void createUser(String username, String fullname, String email, String password) {
		String confirmationMsg = registerationPg.doRegister(username, fullname, email, password);
		Assert.assertEquals(confirmationMsg, "Registration Successfully");
		Allure.step("createUser is executed");
		ChainTestListener.log("createUserTest is executed");
//		Assert.fail();
	}

}







