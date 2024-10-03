package com.qacart.todo.api.todo;

import com.github.javafaker.Faker;
import com.qacart.todo.models.error.Error;
import com.qacart.todo.models.todo.addTodo.requestBody.AddTodoRequestBody;
import com.qacart.todo.models.todo.addTodo.responseBody.AddTodoResponseBody;
import com.qacart.todo.models.todo.deleteTodoById.responseBody.DeleteTodoByIdResponseBody;
import com.qacart.todo.models.todo.getTodoById.responseBody.GetTodoResponseBody;
import io.restassured.response.Response;

public class TodoApiGetController {

    private static TodoApiGetController get;

    private TodoApiGetController() {
    }

    public static TodoApiGetController getTodoApiGetController() {
        if (get == null) {
            return new TodoApiGetController();
        }
        return get;
    }

    public AddTodoRequestBody generateTodo() {
        Faker faker = new Faker();
        String item = faker.book().title();
        Boolean isCompleted = false;
        return AddTodoRequestBody
                .builder()
                .item(item)
                .isCompleted(isCompleted)
                .build();
    }

    public AddTodoResponseBody addTodoResponseBody(Response response) {
        return response.body().as(AddTodoResponseBody.class);
    }

    public Error error(Response response) {
        return response.body().as(Error.class);
    }

    public AddTodoRequestBody addTodoRequestBody(String item) {
        return AddTodoRequestBody.builder()
                .item(item).build();
    }

    public GetTodoResponseBody getTodoResponseBody(Response getTodoResponse) {
        return getTodoResponse.body().as(GetTodoResponseBody.class);
    }

    public DeleteTodoByIdResponseBody deleteTodoByIdResponseBody(Response deleteTodoResponse) {
        return deleteTodoResponse
                .body().as(DeleteTodoByIdResponseBody.class);
    }

}
