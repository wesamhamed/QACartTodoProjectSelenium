package com.qacart.todo.base;

import static io.restassured.RestAssured.*;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specs {
    public static RequestSpecification getRequestSpecification(){
        return given()
                .baseUri(EndPoint.API_BASE_URL)
                .contentType(ContentType.JSON);
//                .log().all();
    }
}
