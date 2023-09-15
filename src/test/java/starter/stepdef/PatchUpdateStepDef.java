package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class PatchUpdateStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //Positive Case 1
    @Given("Patch update user with valid json {string} and id {int}")
    public void patchUpdateUserWithValidJsonAndId(String jsonFile,int id) {
        File json = new File(Constants.REQ_BODY + jsonFile);
        reqresAPI.putUpdateUser(id, json);
    }
    @When("Send patch update user")
    public void sendPatchUpdateUser() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
    @And("Validate patch update user JSON Schema {string}")
    public void validatePatchUpdateUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA + jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Negative Case 1
    @Given("Patch update user with empty name and job with id {int}")
    public void patchUpdateUserWithEmptyNameAndJobWithId(int id) {
        reqresAPI.patchUpdateUser(id);
    }


}
