package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

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
}
