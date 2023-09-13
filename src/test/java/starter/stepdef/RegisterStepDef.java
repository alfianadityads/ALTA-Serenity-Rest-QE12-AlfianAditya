package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class RegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // Create new user

//    Positive case

    @Given("Register new user with valid json {string}")
    public void createNewUserWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        reqresAPI.postRegisterUser(json);
    }

    @When("Send request post register user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    //    Negative case

    @Given("User register with valid email and blank password {string}")
    public void userRegisterWithValidEmailAndBlankPassword(String jsonFile) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        reqresAPI.postRegisterUser(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int statusCodes) {
        SerenityRest.then().statusCode(statusCodes);
    }
}
