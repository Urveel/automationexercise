package com.automationexercise.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/automationexercise/steps",
        plugin = {"html:target/cucumber-reports/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "json:target/cucumber-reports/cucumber.json"}
)

public class RunCukeTest extends AbstractTestNGCucumberTests {
}
