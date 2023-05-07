package com.qacart.todo.api.user.login;

import com.qacart.todo.base.Specs;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.login.request.LoginRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginApi {

    public static Response login(LoginRequest request){
        Response response = given()
                .spec(Specs.getRequestSpecification())
                .body(request)
                .log().all()
                .when()
                .post(EndPoint.API_LOGIN_ENDPOINT)
                .then()
                .log().all()
                .extract().response();

        return response;
    }
}
