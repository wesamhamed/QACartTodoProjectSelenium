package com.qacart.todo.api.todo.getTodoById;

import com.qacart.todo.base.Specs;
import com.qacart.todo.config.EndPoint;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetTodoByIdApi {
    public static Response getTodoById(String token, String taskID){
       Response response =  given()
                .spec(Specs.getRequestSpecification())
                .auth().oauth2(token)
                .when()
                .get(EndPoint.API_TODO_ENDPOINT+"/"+taskID)
                .then()
                .log().all()
                .extract().response();
        return response;
    }
}
