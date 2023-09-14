package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class LoginStepDef {
    @Steps
    ReqresAPI reqresAPI;

//    Postive case
    @Given("User login with valid email and password {string}")
    public void userLoginWithValidEmailAndPassword(String jsonFile) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        reqresAPI.postLoginUser(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

//    Negative case

    @Given("User login with valid email and blank password {string}")
    public void userLoginWithValidEmailAndBlankPassword(String jsonFile) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        reqresAPI.postLoginUser(json);
    }

    @Then("Should return status code {int} Bad Request")
    public void shouldReturnStatusCodeBadRequest(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}
