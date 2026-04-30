package com.qa.usermanagement.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.qa.usermanagement.exceptions.FrameworkExceptions;

public class ReadConfigFile {
	Properties prop;

	public ReadConfigFile() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("./src/test/resources/Config.properties");
		} catch (FileNotFoundException e) {
			throw new FrameworkExceptions("===[ReadConfigFile]-Specified file cannot be found ===");
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			throw new FrameworkExceptions(
					"===[ReadConfigFile]-Specified file cannot be loaded into properties object ===");

		}
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}
	public void setProperty(String key,String value) {
		 prop.setProperty(key,value);
	}
}
