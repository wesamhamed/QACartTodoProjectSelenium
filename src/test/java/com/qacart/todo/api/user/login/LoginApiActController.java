package com.qacart.todo.api.user.login;

import com.qacart.todo.base.Specs;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.login.requestBody.LoginRequestBody;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginApiActController {

    private static LoginApiActController act;

    private LoginApiActController() {
    }


    public static LoginApiActController getLoginApiActController() {
        if (act == null) {
            return new LoginApiActController();
        }
        return act;
    }

    public Response login(LoginRequestBody request) {
        return given()
                .spec(Specs.getRequestSpecification())
                .body(request)
                .when()
                .post(EndPoint.API_LOGIN_ENDPOINT)
                .then()
                .extract().response();
    }
}
