package com.BDD.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\main\\java\\com\\BDD\\Feature", glue = "com.BDD.testSteps", tags = {
		"@Test" })

public class TestRunner {

}
