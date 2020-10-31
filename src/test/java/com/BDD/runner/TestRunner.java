package com.BDD.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.BDD.testBase.TestBase;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//features", glue = "com.BDD.testSteps", plugin = {
		"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:src/test/resources/reports//report.html",
		"html:output/html-report" }, monochrome = true)

public class TestRunner extends TestBase{
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("src//main//resources//extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows 10");
		Reporter.setTestRunnerOutput("Sample test runner output message");
		
		driver.close();
		driver.quit();
	}

}
