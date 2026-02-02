package stepdefinations;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private CommonSteps common;

	public LoginSteps(CommonSteps common) {
		this.common = common;
	}

	@When("User clicks on Login link")
	public void user_clicks_on_login_link() {
		common.homePageObj.clickLoginLink();
	}

	@Then("User should land on the login page")
	public void user_should_land_on_the_login_page() {
		Assert.assertEquals(common.loginPageObj.getLoginPageTitle(), "Account Login");
	}

	@When("User enters the email as {string}")
	public void user_enters_the_email_as(String emailAddress) {
		common.loginPageObj.enterEmail(emailAddress);
	}

	@And("password as {string}")
	public void password_as(String password) {
		common.loginPageObj.enterPassword(password);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		common.loginPageObj.clickLoginButton();
	}
}
