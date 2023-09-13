package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {

    public static String GET_LIST_USERS = Constants.BASE_URL + "/api/users?page={page}";
    public static String POST_CREATE_USER = Constants.BASE_URL + "/api/users";
    public static String PUT_UPDATE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String GET_SINGLE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String GET_INVALID_SINGLE_USER = Constants.BASE_URL+"/api/users/{firstName}";

    // ============================================================================

    @Step("Get List Users")
    public void getListUsers(int page) {
        SerenityRest.given()
                .pathParam(ReqresResponses.PAGE, page);
    }

    @Step("Post create new user")
    public void postCreateNewUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get single user")
    public void getSingleUser(int id) {
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id);
    }

    @Step("Get invalid single user")
    public void getInvalidSingleUser(String firstName) {
        SerenityRest.given()
                .pathParam(ReqresResponses.FIRST_NAME, firstName);
    }
}
