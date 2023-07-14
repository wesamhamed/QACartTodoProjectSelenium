package com.qacart.todo.testcases.apis.todo;

import com.qacart.todo.data.ErrorMessages;
import com.qacart.todo.models.error.Error;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.models.register.responseBody.RegisterResponseBody;
import com.qacart.todo.models.todo.addTodo.requestBody.AddTodoRequestBody;
import com.qacart.todo.models.todo.addTodo.responseBody.AddTodoResponseBody;
import com.qacart.todo.models.todo.deleteTodoById.responseBody.DeleteTodoByIdResponseBody;
import com.qacart.todo.models.todo.getTodoById.responseBody.GetTodoResponseBody;
import com.qacart.todo.steps.todo.TodoSteps;
import com.qacart.todo.steps.user.UserSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


@Feature("Todo Feature")
public class TodoApiTest {
    @Story("Should Be Able To Add Todo")
    @Test(description = "should Be Able To Add Todo")
    public void shouldBeAbleToAddTodo(){

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequestBody = userSteps.generateUser();
        Response registerResponse = userSteps.register(registerRequestBody);
        RegisterResponseBody registerResponseBody = registerResponse.body().as(RegisterResponseBody.class);

        String token = registerResponseBody.getAccess_token();

        TodoSteps todoSteps = new TodoSteps();
        AddTodoRequestBody addTodoRequest = todoSteps.generateTodo();

        Response response = todoSteps.addTodo(addTodoRequest,token);
        AddTodoResponseBody returnedTodo = response.body().as(AddTodoResponseBody.class);

        assertThat(response.statusCode(),equalTo(201));
        assertThat(returnedTodo.getItem(),is(equalTo(addTodoRequest.getItem())));
        assertThat(returnedTodo.getIsCompleted(),equalTo(addTodoRequest.getIsCompleted()));
    }
    @Story("Should Not Be Able To Add Todo If Is Completed Missing")
    @Test(description = "should Not Be Able To Add Todo If Is Completed Missing")
    public void shouldNotBeAbleToAddTodoIfIsCompletedMissing(){

        AddTodoRequestBody addTodoRequest = AddTodoRequestBody.builder()
                                                .item("Learn Appium").build();

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequestBody = userSteps.generateUser();
        Response registerResponse = userSteps.register(registerRequestBody);
        RegisterResponseBody registerResponseBody = registerResponse
                                                        .body().as(RegisterResponseBody.class);

        String token = registerResponseBody.getAccess_token();

        TodoSteps todoSteps = new TodoSteps();

        Response response = todoSteps.addTodo(addTodoRequest,token);
        Error returnedError = response.body().as(Error.class);

        assertThat(response.statusCode(),equalTo(400));
        assertThat(returnedError.getMessage(),is(equalTo(ErrorMessages.IS_COMPLETED_IS_REQUIRED)));
    }
    @Story("Should Be Able To Get A Todo By ID")
    @Test(description = "should Be Able To Get A Todo By ID")
    public void shouldBeAbleToGetATodoByID(){

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequestBody = userSteps.generateUser();
        Response registerResponse = userSteps.register(registerRequestBody);
        RegisterResponseBody registerResponseBody = registerResponse.body().as(RegisterResponseBody.class);

        String token = registerResponseBody.getAccess_token();

        TodoSteps todoSteps = new TodoSteps();
        AddTodoRequestBody addTodoRequest = todoSteps.generateTodo();

        Response response = todoSteps.addTodo(addTodoRequest,token);
        AddTodoResponseBody addTodoResponse = response.body().as(AddTodoResponseBody.class);

        Response getTodoResponse = todoSteps.getTodoByID(token,addTodoResponse.getId());
        GetTodoResponseBody returnedTodo = getTodoResponse.body().as(GetTodoResponseBody.class);

        assertThat(getTodoResponse.statusCode(),equalTo(200));
        assertThat(returnedTodo.getItem(),is(equalTo(addTodoResponse.getItem())));
        assertThat(returnedTodo.getIsCompleted(),is(equalTo(addTodoResponse.getIsCompleted())));
    }
    @Story("Should Be Able To Delete Todo By ID")
    @Test(description="should Be Able To Delete Todo By ID")
    public void shouldBeAbleToDeleteTodoByID(){

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequestBody = userSteps.generateUser();
        Response registerResponse = userSteps.register(registerRequestBody);
        RegisterResponseBody registerResponseBody = registerResponse.body().as(RegisterResponseBody.class);

        String token = registerResponseBody.getAccess_token();

        TodoSteps todoSteps = new TodoSteps();
        AddTodoRequestBody addTodoRequest = todoSteps.generateTodo();
        AddTodoResponseBody addTodoResponse = todoSteps.addTodo(addTodoRequest,token)
                                                        .body().as(AddTodoResponseBody.class);

        String todoID = addTodoResponse.getId();
        Response deleteTodoResponse = todoSteps.deleteTodoByID(token,todoID);
        DeleteTodoByIdResponseBody deleteTodoByIdResponse = deleteTodoResponse
                                                                .body().as(DeleteTodoByIdResponseBody.class);

        assertThat(deleteTodoResponse.statusCode(),equalTo(200));
        assertThat(addTodoResponse.getItem(),is(equalTo(deleteTodoByIdResponse.getItem())));
        assertThat(addTodoResponse.getIsCompleted(),is(equalTo(deleteTodoByIdResponse.getIsCompleted())));
    }
}
