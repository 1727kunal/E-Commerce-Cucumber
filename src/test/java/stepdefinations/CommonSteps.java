package stepdefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterPage;
import pages.SuccessPage;

public class CommonSteps {
	
	public WebDriver driver;
	
	public HomePage homePageObj;
	public RegisterPage registerPageObj;
	public SuccessPage successPageObj;
	public MyAccountPage myAccountPageObj;
	public LoginPage loginPageObj;
	
	@Given("User opens the browser")
	public void user_opens_the_browser() {
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  homePageObj = new HomePage(driver);
	  registerPageObj = new RegisterPage(driver);
	  successPageObj = new SuccessPage(driver);
	  myAccountPageObj = new MyAccountPage(driver);
	  loginPageObj = new LoginPage(driver);
	}

	@And("Hit the URL")
	public void hit_the_url() {
		driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=common/home");
	}

	@Then("User should land on the homepage")
	public void user_should_land_on_the_homepage() {
		Assert.assertEquals(homePageObj.getHomePageTitle(), "Your Store");
	}

	@When("User clicks on MyAccount button")
	public void user_clicks_on_my_account_button() {
		homePageObj.clickMyAccountButton();
	}
	
	@Then("User should land on the my account page")
	public void user_should_land_on_the_my_account_page() {
		Assert.assertEquals(myAccountPageObj.getMyAccountPageTitle(), "My Account");
	}
	
	@And("User close the browser")
	public void user_close_the_browser() {
		if(driver!= null) {
			driver.quit();	
		}
	}

	public void holdExecutionForSeconds(long miliSec){
		try {
			Thread.sleep(miliSec);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
