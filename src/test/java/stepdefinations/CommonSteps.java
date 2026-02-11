package stepdefinations;

import org.junit.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class CommonSteps {
	public HomePage homePageObj;
	public RegisterPage registerPageObj;
	public SuccessPage successPageObj;
	public MyAccountPage myAccountPageObj;
	public LoginPage loginPageObj;

	public CommonSteps() {
		homePageObj = new HomePage(Hooks.driver);
		registerPageObj = new RegisterPage(Hooks.driver);
		successPageObj = new SuccessPage(Hooks.driver);
		myAccountPageObj = new MyAccountPage(Hooks.driver);
		loginPageObj = new LoginPage(Hooks.driver);
	}

	@Given("User should land on the homepage")
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
}
