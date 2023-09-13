package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // Get list users
    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Get list users status code should be {int} OK")
    public void getStatusCodeShouldBe(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    // Create new user

    @Given("Create new user with valid json {string}")
    public void createNewUserWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        reqresAPI.postCreateNewUser(json);
    }

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    // Put update user

    @Given("Put update user with valid id {int}")
    public void putUpdateUserWithValidData(int id) {
        File json = new File(Constants.REQ_BODY + "User.json");
        reqresAPI.putUpdateUser(id, json);
    }
    
    @When("Send put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @Then("Put update user status code should be {int} OK")
    public void putStatusCodeShouldBe(int ok) {
        SerenityRest.then().statusCode(ok);
    }
}
