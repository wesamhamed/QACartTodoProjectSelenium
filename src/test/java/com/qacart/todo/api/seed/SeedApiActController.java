package com.qacart.todo.api.seed;

import com.qacart.todo.base.Specs;
import com.qacart.todo.config.EndPoint;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SeedApiActController {

    private static SeedApiActController act;

    private SeedApiActController() {

    }

    public static SeedApiActController getSeedApiActController() {
        if (act == null) {
            return new SeedApiActController();
        }
        return act;
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
