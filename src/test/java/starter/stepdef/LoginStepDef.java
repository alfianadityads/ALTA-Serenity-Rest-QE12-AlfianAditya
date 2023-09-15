package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginStepDef {
    @Steps
    ReqresAPI reqresAPI;

//    Positive case
    @Given("User login with valid email and password {string}")
    public void userLoginWithValidEmailAndPassword(String jsonFile) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        reqresAPI.postLoginUser(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @And("Responses body token was {string}")
    public void responsesBodyTokenWas(String token) {
        SerenityRest.and()
                .body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Validate success post login user JSON schema {string}")
    public void validateSuccessPostLoginUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
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
