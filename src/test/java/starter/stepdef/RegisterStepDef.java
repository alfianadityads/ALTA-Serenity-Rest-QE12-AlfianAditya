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
    @And("Responses body id was {int} and token was {string}")
    public void responsesBodyIdWasAndTokenWas(int id, String token) {
        SerenityRest.and()
                .body(ReqresResponses.ID, equalTo(id))
                .body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Validate post register users JSON schema {string}")
    public void validatePostRegisterUsersJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
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


    @And("Responses body error was {string}")
    public void responsesBodyEmail(String error) {
        SerenityRest.and()
                .body(ReqresResponses.ERROR, equalTo(error));
    }

    @And("Validate Unsuccess post register users JSON schema {string}")
    public void validateUnsuccessPostRegisterUsersJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
