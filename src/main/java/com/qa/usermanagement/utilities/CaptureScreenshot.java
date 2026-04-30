package com.qa.usermanagement.utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;

public class CaptureScreenshot {

	public static File getScreenshotFile(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.FILE);
	}

	@Attachment(value = "Failed Test Page Screenshot", type = "image/png")
	public static byte[] getScreenshotBytes(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BYTES);
	}
}
