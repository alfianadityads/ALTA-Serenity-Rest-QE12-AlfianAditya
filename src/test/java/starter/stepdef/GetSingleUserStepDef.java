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

public class GetSingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

//    Positive case
    @Given("Get single user with valid id {int}")
    public void getSingleUserWithValidId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request valid id get single user")
    public void sendRequestValidIdGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @Then("Should return status code {int} OK")
    public void shouldReturnStatusCodeOK(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Responses body id was {int}")
    public void responsesBodyIdWas(int id) {
        SerenityRest.and()
                .body(ReqresResponses.DATA_ID, equalTo(id));
    }

    @And("Validate get single user JSON schema {string}")
    public void validateGetSingleUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

//    Negative case 1
    @Given("Get single user with exceed id {}")
    public void getSingleUserWithExceedId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request exceed id get single user")
    public void sendRequestExceedIdGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @Then("Should return status code {int} Not Found for exceed id")
    public void returnStatusCodeNotFound(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

//    Negative Case 2

    @Given("Get single user with first name {string}")
    public void getSingleUserWithFirstName(String firstName) {
        reqresAPI.getInvalidSingleUser(firstName);
    }

    @When("Send request invalid parameter get single user")
    public void sendRequestInvalidParameterGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_INVALID_SINGLE_USER);
    }

    @Then("Should return status code {int} Not Found for invalid parameter")
    public void shouldReturnStatusCodeNotFoundForInvalidParameter(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }


    @And("Validate invalid get single user JSON schema {string}")
    public void validateInvalidGetSingleUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
