package com.qacart.todo.api.todo;

import com.qacart.todo.base.Specs;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.models.todo.addTodo.requestBody.AddTodoRequestBody;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TodoApiActController {

    private static TodoApiActController act;

    private TodoApiActController() {

    }


    public static TodoApiActController getTodoApiActController() {
        if (act == null) {
            return new TodoApiActController();
        }
        return act;
    }

    public Response addTodo(AddTodoRequestBody request, String token) {
        return given()
                .spec(Specs.getRequestSpecification())
                .body(request)
                .auth().oauth2(token)
                .when()
                .post(EndPoint.API_TODO_ENDPOINT)
                .then()
                .extract()
                .response();
    }

    public Response deleteTodoByID(String token, String taskID) {
        return given()
                .spec(Specs.getRequestSpecification())
                .auth().oauth2(token)
                .when()
                .delete(EndPoint.API_TODO_ENDPOINT + "/" + taskID)
                .then()
                .extract()
                .response();
    }

    public Response getTodoById(String token, String taskID) {
        return given()
                .spec(Specs.getRequestSpecification())
                .auth().oauth2(token)
                .when()
                .get(EndPoint.API_TODO_ENDPOINT + "/" + taskID)
                .then()
                .extract()
                .response();
    }

}
