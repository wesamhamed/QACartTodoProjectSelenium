package com.qacart.todo.api.seed;

import com.qacart.todo.base.Specs;
import com.qacart.todo.config.EndPoint;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SeedAPi {
    public static Response setupDatabase(){
        Response response = given()
                .spec(Specs.getRequestSpecification())
//                .log().all()
                .when()
                .get(EndPoint.API_SEED_ENDPOINT)
                .then()
//                .log().all()
                .extract().response();

        if(response.statusCode() != 200){
            throw  new RuntimeException("Something went wrong with the request");
        }
        return response;

    }
}
