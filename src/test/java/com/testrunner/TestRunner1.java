package com.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "E:\\LinkedLerrning\\mercautotestcuc\\src\\test\\java\\com\\features\\parameterize.feature",
        glue = {"com.steps"},
//        dryRun = true,
        plugin = {"pretty", "html:test-output"}
//        tags = {"@BasicTest"}
)
public class TestRunner1 {
}
