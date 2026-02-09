package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/Register.feature"},
		glue = {"stepdefinations","hooks"},
//		tags = "not @DataDriven",
		dryRun = false,
		plugin = {"pretty","html:target/cucumber-reports/Register.html"},
		monochrome = true
		)
public class RunnerRegister {
	
}
