package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/LoginDataTable.feature"},
		glue = {"stepdefinations","hooks"},
//		tags = "not @DataDriven",
		dryRun = false,
		plugin = {"pretty","html:target/cucumber-reports/LoginDataTable.html"},
		monochrome = true
		)
public class RunnerLoginDataTable {
	
}
