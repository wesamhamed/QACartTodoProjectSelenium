package com.qacart.todo.api.user.register;

import com.qacart.todo.base.Specs;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private static RegisterApi registerApi;

    private RegisterApi() {

    }

    public static RegisterApi getInstance() {
        if (registerApi == null) {
            registerApi = new RegisterApi();
        }
        return registerApi;
    }

    public Response register(RegisterRequestBody request) {
        return given()
                .spec(Specs.getRequestSpecification())
                .body(request)
                .when()
                .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                .extract()
                .response();
    }
}
