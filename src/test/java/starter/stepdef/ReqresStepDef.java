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

    // Put update user

    @Given("Put update user with valid json {string} and user id {int}")
    public void putUpdateUserWithValidData(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY + jsonFile);
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

//    Delete User

    @Given("Delete a user with valid user id {int}")
    public void deleteAUserWithValidUserId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code delete user should {int} No Content")
    public void statusCodeDeleteUserShouldNoContent(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
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
}
