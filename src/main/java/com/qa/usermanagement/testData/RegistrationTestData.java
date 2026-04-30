package com.qa.usermanagement.testData;

import org.testng.annotations.DataProvider;

import com.qa.usermanagement.utilities.FakeDataGenerator;

public class RegistrationTestData {

	FakeDataGenerator fdg = new FakeDataGenerator();

	@DataProvider(name = "generateData")
	public Object[][] generateData() {
		Object[][] data = new String[1][4];
		data[0][0] = fdg.getUserName();
		data[0][1] = fdg.getFullName();
		data[0][2] = fdg.getEmailAddress();
		data[0][3] = fdg.getPassword();
		return data;
	}
}
