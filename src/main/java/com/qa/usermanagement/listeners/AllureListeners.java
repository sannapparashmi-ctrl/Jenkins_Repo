package com.qa.usermanagement.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.usermanagement.browserfactory.BrowserManager;
import com.qa.usermanagement.utilities.CaptureScreenshot;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class AllureListeners implements ITestListener {	
//suite
	public void onStart(ITestContext context) {
		ChainTestListener.log("The test suite " + context.getName() + " is started with execution");
		Allure.step("The test suite " + context.getName() + " is started with execution");
	}
//suite
	public void onFinish(ITestContext context) {
		ChainTestListener.log("The test suite " + context.getName() + " is finished with execution");
		Allure.step("The test suite " + context.getName() + " is finished with execution");
	}
//testcase
	public void onTestStart(ITestResult result) {
		ChainTestListener.log("The test case " + result.getName() + " is started with execution");
		Allure.step("The test case " + result.getName() + " is started with execution");
	}
	public void onTestSuccess(ITestResult result) {
		ChainTestListener.log("The test case " + result.getName() + " is successfully executed");
		Allure.step("The test case " + result.getName() + " is successfully executed");
	}
	public void onTestFailure(ITestResult result) {
		ChainTestListener.log("The test case " + result.getName() + " is failed during execution & captured screenshot");
		WebDriver driver = BrowserManager.getDriver();

		if (driver != null) {
			CaptureScreenshot.getScreenshotBytes(driver); // this works because of @Attachment
		}
		getTextLog(getTestMethodName(result) + " " + result.getName() + " is failed and attached");
		getTextMsg(getTestMethodName(result) + " " + result.getName() + " is failed and attached");
		Allure.step("The test case " + result.getName() + " is failed from execution");
	}

	public void onTestSkipped(ITestResult result) {
		ChainTestListener.log("The test case " + result.getName() + " is skipped from execution");
		Allure.step("The test case " + result.getName() + " is skipped from execution");
	}
	
	
	public String getTestMethodName(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();
	}

	@Attachment(value = "{0}", type = "text/html")
	public String getTextLog(String htmlLog) {
		return htmlLog;
	}

	@Attachment(value = "{0}", type = "text/plain")
	public String getTextMsg(String textMsg) {
		return textMsg;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
