package com.qacart.todo.api.todo.addTodo;

import com.qacart.todo.base.Specs;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.todo.addTodo.request.AddTodoRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AddTodoApi {
    public static Response addTodo(AddTodoRequest request, String token){
        Response response =
                given()
                        .spec(Specs.getRequestSpecification())
                        .body(request)
                        .auth().oauth2(token)
                        .when()
                        .post(EndPoint.API_TODO_ENDPOINT)
                        .then()
                        .log().all()
                        .extract().response();

        return response;
    }
}
