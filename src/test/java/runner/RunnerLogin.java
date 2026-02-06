package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/Login.feature"},
		glue = {"stepdefinations","hooks"},
//		tags = "not @DataDriven",
		dryRun = false,
		plugin = {"pretty","json:target/cucumber-reports/Login.json"},
		monochrome = true
		)
public class RunnerLogin {
	
}
