package stepdefinations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class LoginDataTableSteps {
    CommonSteps common;
    public LoginDataTableSteps(CommonSteps common){
        this.common =common;
    }

    @When("User enter the below credentials and clicks the login button then login process should be complete")
    public void user_enter_the_below_credentials_and_clicks_the_login_button_then_login_process_should_be_complete(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String expectedResult= "";

        for(Map<String, String> actualData: data){
            common.loginPageObj.enterEmail(actualData.get("email"));
            common.loginPageObj.enterPassword(actualData.get("password"));
            expectedResult = actualData.get("expected");
            common.loginPageObj.clickLoginButton();
            boolean status = false;
            if(expectedResult.equalsIgnoreCase("valid")){
                status =true;
                Assert.assertTrue(status);
            }

            else if(expectedResult.equalsIgnoreCase("invalid")) {
                status = false;
                Assert.assertFalse(status);
            }
            common.driver.navigate().refresh();
        }
    }
}
