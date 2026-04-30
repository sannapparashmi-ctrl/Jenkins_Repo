package com.qa.usermanagement.utilities;

import com.github.javafaker.Faker;

public class FakeDataGenerator {

	static Faker fakeData = new Faker();

	public String getUserName() {
		return fakeData.name().username();
	}

	public String getFullName() {
		return fakeData.name().fullName();
	}

	public String getEmailAddress() {
		return fakeData.internet().emailAddress();
	}

	public String getPassword() {
		return fakeData.internet().password(6, 8, true, true, true);
	}
}
