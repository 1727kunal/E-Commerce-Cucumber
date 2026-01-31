package stepdefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegisterPage;
import pages.SuccessPage;
import utilities.FakeDataGenerator;


public class RegisterSteps {
	
	public WebDriver driver;
	
	HomePage homePageObj;
	RegisterPage registerPageObj;
	SuccessPage successPageObj;
	MyAccountPage myAccountPageObj;
	
	String password;
	
	@Given("User opens the browser")
	public void user_opens_the_browser() {
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  homePageObj = new HomePage(driver);
	  registerPageObj = new RegisterPage(driver);
	  successPageObj = new SuccessPage(driver);
	  myAccountPageObj = new MyAccountPage(driver);
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

	@And("User clicks on Register button")
	public void user_clicks_on_register_button() {
		homePageObj.clickRegisterButton();
	}

	@Then("User should land on the registration page")
	public void user_should_land_on_the_registration_page() {
		Assert.assertEquals(registerPageObj.getRegisterPageTitle(), "Register Account");
	}

	@When("User enters first name")
	public void user_enters_first_name() {
		registerPageObj.enterFirstName(FakeDataGenerator.generateFirstName());
	}

	@And("User enters last name")
	public void user_enters_last_name() {
		registerPageObj.enterLastName(FakeDataGenerator.generateLastName());
	}

	@And("User enters email")
	public void user_enters_email() {
		registerPageObj.enterEmail(FakeDataGenerator.generateEmail());
	}

	@And("User enters telephone")
	public void user_enters_telephone() {
		registerPageObj.enterTelephoneNumber(FakeDataGenerator.generateTelephone());
	}

	@And("User enters password")
	public void user_enters_password() {
		password = FakeDataGenerator.generatePassword();
		registerPageObj.enterPassword(password);
	}

	@And("User enters confirm password")
	public void user_enters_confirm_password() {
		registerPageObj.enterConfirmPassword(password);
	}

	@And("User checks the privacy policy checkbox")
	public void user_checks_the_privacy_policy_checkbox() {
		registerPageObj.clickPrivacyCheckbox();
	}

	@And("User clicks on the continue button")
	public void user_clicks_on_the_continue_button() {
		registerPageObj.clickContinueButton();
	}

	@Then("User should be registered successfully")
	public void user_should_be_registered_successfully() {
		Assert.assertEquals(successPageObj.isSuccessTextMessageDisplayed(), true);
	}

	@And("User should land on success page")
	public void user_should_land_on_success_page() {
		Assert.assertEquals(successPageObj.getSuccessPageTitle(), "Your Account Has Been Created!");
	}

	@When("User clicks continue button on the success page")
	public void user_clicks_continue_button_on_the_success_page() {
		successPageObj.clickContinueButton();
	}
	
	@Then("User should land on the my account page")
	public void user_should_land_on_the_my_account_page() {
		Assert.assertEquals(myAccountPageObj.getMyAccountPageTitle(), "My Account");
	}
	
	@And("User close the browser")
	public void user_close_the_browser() {
		driver.quit();
	}
}
