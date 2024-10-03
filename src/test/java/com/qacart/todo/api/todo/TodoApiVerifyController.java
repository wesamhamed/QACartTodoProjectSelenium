package com.qacart.todo.api.todo;

import com.qacart.todo.data.ErrorMessages;
import com.qacart.todo.models.error.Error;
import com.qacart.todo.models.todo.addTodo.requestBody.AddTodoRequestBody;
import com.qacart.todo.models.todo.addTodo.responseBody.AddTodoResponseBody;
import com.qacart.todo.models.todo.deleteTodoById.responseBody.DeleteTodoByIdResponseBody;
import com.qacart.todo.models.todo.getTodoById.responseBody.GetTodoResponseBody;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TodoApiVerifyController {

    private static TodoApiVerifyController verify;

    private TodoApiVerifyController() {

    }

    public static TodoApiVerifyController getTodoApiVerifyController() {
        if (verify == null) {
            return new TodoApiVerifyController();
        }
        return verify;
    }

    public TodoApiVerifyController statusCodeIsCorrect(Response response, int statusCode) {
        assertThat(response.statusCode(), equalTo(statusCode));
        return TodoApiVerifyController.getTodoApiVerifyController();
    }

    public TodoApiVerifyController itemIsCorrect(AddTodoResponseBody returnedTodo, AddTodoRequestBody addTodoRequest) {
        assertThat(returnedTodo.getItem(), is(equalTo(addTodoRequest.getItem())));
        return TodoApiVerifyController.getTodoApiVerifyController();
    }

    public TodoApiVerifyController itemIsCorrect(GetTodoResponseBody returnedTodo, AddTodoResponseBody addTodoResponse) {
        assertThat(returnedTodo.getItem(), is(equalTo(addTodoResponse.getItem())));
        return TodoApiVerifyController.getTodoApiVerifyController();
    }

    public TodoApiVerifyController itemIsCorrect(AddTodoResponseBody addTodoResponseBody, DeleteTodoByIdResponseBody deleteTodoByIdResponse) {
        assertThat(addTodoResponseBody.getItem(), is(equalTo(deleteTodoByIdResponse.getItem())));
        return TodoApiVerifyController.getTodoApiVerifyController();
    }

    public TodoApiVerifyController isCompletedCorrect(AddTodoResponseBody returnedTodo, AddTodoRequestBody addTodoRequest) {
        assertThat(returnedTodo.getIsCompleted(), equalTo(addTodoRequest.getIsCompleted()));
        return TodoApiVerifyController.getTodoApiVerifyController();
    }

    public TodoApiVerifyController isCompletedIsRequired(Error returnedError) {
        assertThat(returnedError.getMessage(), is(equalTo(ErrorMessages.IS_COMPLETED_IS_REQUIRED)));
        return TodoApiVerifyController.getTodoApiVerifyController();
    }


    public TodoApiVerifyController isCompletedCorrect(GetTodoResponseBody returnedTodo, AddTodoResponseBody addTodoResponse) {
        assertThat(returnedTodo.getIsCompleted(), is(equalTo(addTodoResponse.getIsCompleted())));
        return TodoApiVerifyController.getTodoApiVerifyController();
    }

    public TodoApiVerifyController isCompletedCorrect(AddTodoResponseBody addTodoResponseBody, DeleteTodoByIdResponseBody deleteTodoByIdResponse) {
        assertThat(addTodoResponseBody.getIsCompleted(), is(equalTo(deleteTodoByIdResponse.getIsCompleted())));
        return TodoApiVerifyController.getTodoApiVerifyController();
    }

}
