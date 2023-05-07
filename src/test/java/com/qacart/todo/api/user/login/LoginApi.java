package com.qacart.todo.api.user.login;

import com.qacart.todo.base.Specs;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.login.requestBody.LoginRequestBody;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginApi {

    public static Response login(LoginRequestBody request){
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
