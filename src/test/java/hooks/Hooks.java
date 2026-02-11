package hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	public static WebDriver driver;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.manage().window().maximize();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File dest = new File("test-output/Screenshots/" + scenario.getName() + ".png");

			try {
				Files.copy(src.toPath(), dest.toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				byte[] screenshot = Files.readAllBytes(dest.toPath());
				scenario.attach(screenshot, "image/png", scenario.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (driver != null) {
			driver.quit();
		}
	}
}
