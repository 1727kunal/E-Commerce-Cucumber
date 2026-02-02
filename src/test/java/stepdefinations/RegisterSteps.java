package stepdefinations;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.FakeDataGenerator;

public class RegisterSteps {

	private CommonSteps common;

	String password;

	public RegisterSteps(CommonSteps common) {
		this.common = common;
	}

	@When("User clicks on Register button")
	public void user_clicks_on_register_button() {
		common.homePageObj.clickRegisterButton();
	}

	@Then("User should land on the registration page")
	public void user_should_land_on_the_registration_page() {
		Assert.assertEquals(common.registerPageObj.getRegisterPageTitle(), "Register Account");
	}

	@When("User enters first name")
	public void user_enters_first_name() {
		common.registerPageObj.enterFirstName(FakeDataGenerator.generateFirstName());
	}

	@And("User enters last name")
	public void user_enters_last_name() {
		common.registerPageObj.enterLastName(FakeDataGenerator.generateLastName());
	}

	@And("User enters email")
	public void user_enters_email() {
		common.registerPageObj.enterEmail(FakeDataGenerator.generateEmail());
	}

	@And("User enters telephone")
	public void user_enters_telephone() {
		common.registerPageObj.enterTelephoneNumber(FakeDataGenerator.generateTelephone());
	}

	@And("User enters password")
	public void user_enters_password() {
		password = FakeDataGenerator.generatePassword();
		common.registerPageObj.enterPassword(password);
	}

	@And("User enters confirm password")
	public void user_enters_confirm_password() {
		common.registerPageObj.enterConfirmPassword(password);
	}

	@And("User checks the privacy policy checkbox")
	public void user_checks_the_privacy_policy_checkbox() {
		common.registerPageObj.clickPrivacyCheckbox();
	}

	@And("User clicks on the continue button")
	public void user_clicks_on_the_continue_button() {
		common.registerPageObj.clickContinueButton();
	}

	@Then("User should be registered successfully")
	public void user_should_be_registered_successfully() {
		Assert.assertEquals(common.successPageObj.isSuccessTextMessageDisplayed(), true);
	}

	@And("User should land on success page")
	public void user_should_land_on_success_page() {
		Assert.assertEquals(common.successPageObj.getSuccessPageTitle(), "Your Account Has Been Created!");
	}

	@When("User clicks continue button on the success page")
	public void user_clicks_continue_button_on_the_success_page() {
		common.successPageObj.clickContinueButton();
	}
}
