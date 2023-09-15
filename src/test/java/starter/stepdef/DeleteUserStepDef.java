package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import net.serenitybdd.rest.SerenityRest;

public class DeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    // Postive case
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }


    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    // Negative case
    @Given("Delete user with invalid id {string}")
    public void delete_user_with_invalid_id(String id) {
        reqresAPI.deleteInvalidUser(id);
    }

}
