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

public class SingleResourceStepDef {
    @Steps
    ReqresAPI reqresAPI;

//    Positive case
    @Given("Get single resource with valid parameter id {int}")
    public void getSingleUserWithValidId(int id) {
        reqresAPI.getSingleResource(id);
    }

    @When("Send request valid id get single resource")
    public void sendRequestValidIdGetSingleResource() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);
    }

    @Then("Get single resource should return status code {int} OK")
    public void getSingleResourceShouldReturnStatusCodeOK(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body id was {int}")
    public void responseBodyIdWas(int id) {
        SerenityRest.and()
                .body(ReqresResponses.DATA_ID, equalTo(id));
    }

    @And("Validate get single resource JSON schema {string}")
    public void validateGetSingleResourceJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //    Negative case
    @Given("Get single resource with exceed id {int}")
    public void getSingleResourceWithExceedId(int id) {
        reqresAPI.getSingleResource(id);
    }

    @When("Send request get single resource")
    public void sendRequestGetSingleResource() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);
    }

    @Then("Should return status code {int} Not Found")
    public void shouldReturnStatusCodeNotFound(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate get single resource with exceed id JSON schema {string}")
    public void validateGetSingleResourceWithExceedIdJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
