package com.SparkHub.runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {"src/test/java/com/SparkHub/feature"},
    glue = {"com.SparkHub.stepdefinition"},
    tags = "@TC_101",
    monochrome = true,
    dryRun = false,
    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/cucumber-report.json"
    }
)
public class RunnerTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
