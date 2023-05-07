package com.qacart.todo.api.user.register;

import com.qacart.todo.base.Specs;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.register.request.RegisterRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    public static Response register(RegisterRequest request){
        Response response = given()
                .spec(Specs.getRequestSpecification())
                .body(request)
                .log().all()
                .when()
                .post(EndPoint.API_REGISTER_ENDPOINT)
                .then()
                .log().all()
                .extract().response();
        return response;
    }
}
