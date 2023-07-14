package com.qacart.todo.api.seed;

import com.qacart.todo.base.Specs;
import com.qacart.todo.config.EndPoint;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SeedAPi {

    private static SeedAPi seedAPi;

    private SeedAPi() {

    }

    public static SeedAPi getInstance() {
        if (seedAPi == null) {
            seedAPi = new SeedAPi();
        }
        return seedAPi;
    }

    public Response setupDatabase() {
        return given()
                .spec(Specs.getRequestSpecification())
                .when()
                .get(EndPoint.API_SEED_ENDPOINT)
                .then()
                .extract()
                .response();
    }
}
