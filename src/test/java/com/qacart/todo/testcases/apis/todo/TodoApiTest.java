package com.qacart.todo.testcases.apis.todo;

import com.qacart.todo.api.todo.TodoApi;
import com.qacart.todo.api.user.register.RegisterApi;
import com.qacart.todo.models.error.Error;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.models.register.responseBody.RegisterResponseBody;
import com.qacart.todo.models.todo.addTodo.requestBody.AddTodoRequestBody;
import com.qacart.todo.models.todo.addTodo.responseBody.AddTodoResponseBody;
import com.qacart.todo.models.todo.deleteTodoById.responseBody.DeleteTodoByIdResponseBody;
import com.qacart.todo.models.todo.getTodoById.responseBody.GetTodoResponseBody;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

@Feature("Todo Feature")
public class TodoApiTest {

    RegisterApi registerApi = RegisterApi.getRegisterApi();
    TodoApi todoApi = TodoApi.getTodoApi();

    @Story("Should Be Able To Add Todo")
    @Test(description = "should Be Able To Add Todo")
    public void shouldBeAbleToAddTodo() {

        RegisterRequestBody registerRequestBody = registerApi.get()
                .generateUser();

        Response registerResponse = registerApi.act()
                .register(registerRequestBody);

        RegisterResponseBody registerResponseBody = registerApi.get()
                .registerResponseBody(registerResponse);


        String token = registerResponseBody.getAccess_token();

        AddTodoRequestBody addTodoRequest = todoApi.get()
                .generateTodo();

        Response response = todoApi.act()
                .addTodo(addTodoRequest, token);

        AddTodoResponseBody returnedTodo = todoApi.get()
                .addTodoResponseBody(response);

        todoApi.verify()
                .statusCodeIsCorrect(response, 201)
                .itemIsCorrect(returnedTodo, addTodoRequest)
                .isCompletedCorrect(returnedTodo, addTodoRequest);

    }

    @Story("Should Not Be Able To Add Todo If Is Completed Missing")
    @Test(description = "should Not Be Able To Add Todo If Is Completed Missing")
    public void shouldNotBeAbleToAddTodoIfIsCompletedMissing() {

        RegisterRequestBody registerRequestBody = registerApi.get()
                .generateUser();

        Response registerResponse = registerApi.act()
                .register(registerRequestBody);

        RegisterResponseBody registerResponseBody = registerApi.get()
                .registerResponseBody(registerResponse);

        String token = registerResponseBody.getAccess_token();

        AddTodoRequestBody addTodoRequest = todoApi.get()
                .addTodoRequestBody("Learn Appium");

        Response response = todoApi.act()
                .addTodo(addTodoRequest, token);

        Error returnedError = todoApi.get()
                .error(response);

        todoApi.verify()
                .statusCodeIsCorrect(response, 400)
                .isCompletedIsRequired(returnedError);

    }

    @Story("Should Be Able To Get A Todo By ID")
    @Test(description = "should Be Able To Get A Todo By ID")
    public void shouldBeAbleToGetATodoByID() {

        RegisterRequestBody registerRequestBody = registerApi.get()
                .generateUser();

        Response registerResponse = registerApi.act()
                .register(registerRequestBody);

        RegisterResponseBody registerResponseBody = registerApi.get()
                .registerResponseBody(registerResponse);

        String token = registerResponseBody.getAccess_token();


        AddTodoRequestBody addTodoRequest = todoApi.get()
                .generateTodo();

        Response response = todoApi.act()
                .addTodo(addTodoRequest, token);

        AddTodoResponseBody addTodoResponse = todoApi.get()
                .addTodoResponseBody(response);

        Response getTodoResponse = todoApi.act()
                .getTodoById(token, addTodoResponse.getId());

        GetTodoResponseBody returnedTodo = todoApi.get()
                .getTodoResponseBody(getTodoResponse);

        todoApi.verify()
                .statusCodeIsCorrect(getTodoResponse, 200)
                .itemIsCorrect(returnedTodo, addTodoResponse)
                .isCompletedCorrect(returnedTodo, addTodoResponse);

    }

    @Story("Should Be Able To Delete Todo By ID")
    @Test(description = "should Be Able To Delete Todo By ID")
    public void shouldBeAbleToDeleteTodoByID() {

        RegisterRequestBody registerRequestBody = registerApi.get()
                .generateUser();

        Response registerResponse = registerApi.act()
                .register(registerRequestBody);

        RegisterResponseBody registerResponseBody = registerApi.get()
                .registerResponseBody(registerResponse);

        String token = registerResponseBody.getAccess_token();


        AddTodoRequestBody addTodoRequest = todoApi.get()
                .generateTodo();

        Response addTodoResponse = todoApi.act()
                .addTodo(addTodoRequest, token);

        AddTodoResponseBody addTodoResponseBody = todoApi.get()
                .addTodoResponseBody(addTodoResponse);

        String todoID = addTodoResponseBody.getId();

        Response deleteTodoResponse = todoApi.act()
                .deleteTodoByID(token, todoID);

        DeleteTodoByIdResponseBody deleteTodoByIdResponse = todoApi.get()
                .deleteTodoByIdResponseBody(deleteTodoResponse);

        todoApi.verify()
                .statusCodeIsCorrect(deleteTodoResponse, 200)
                .itemIsCorrect(addTodoResponseBody, deleteTodoByIdResponse)
                .isCompletedCorrect(addTodoResponseBody, deleteTodoByIdResponse);

    }
}
