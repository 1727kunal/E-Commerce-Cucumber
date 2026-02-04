package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/LoginDataTable.feature"},
		glue = {"stepdefinations"},
		dryRun = false,
		plugin = {"pretty","json:target/cucumber.json", "html:target/cucumber.html"},
		monochrome = false
		)
public class MyRunner {
	
}
