package com.tests.openmrs.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"com/tests/openmrs/stepdefinitions","com/tests/openmrs/hook"},
        dryRun = false,
        tags = "@smoke",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt",
        "json:target/cucumber-reports/cucumber.json"}

)
public class OpenMrs_Runner {
}
