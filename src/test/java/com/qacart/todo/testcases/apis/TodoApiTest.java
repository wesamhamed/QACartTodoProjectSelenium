package com.qacart.todo.testcases.apis;

import com.qacart.todo.data.ErrorMessages;
import com.qacart.todo.models.error.Error;
import com.qacart.todo.models.todo.addTodo.request.AddTodoRequest;
import com.qacart.todo.models.todo.addTodo.response.AddTodoResponse;
import com.qacart.todo.models.todo.deleteTodoById.response.DeleteTodoByIdResponse;
import com.qacart.todo.models.todo.getTodoById.response.GetTodoResponse;
import com.qacart.todo.steps.TodoSteps;
import com.qacart.todo.steps.UserSteps;
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

        TodoSteps todoSteps = new TodoSteps();
        AddTodoRequest addTodoRequest = todoSteps.generateTodo();

        UserSteps userSteps = new UserSteps();
        userSteps.getRegisteredUser();
        String token = userSteps.getToken();

        Response response = todoSteps.addTodo(addTodoRequest,token);
        AddTodoResponse returnedTodo = response.body().as(AddTodoResponse.class);

        assertThat(response.statusCode(),equalTo(201));
        assertThat(returnedTodo.getItem(),is(equalTo(addTodoRequest.getItem())));
        assertThat(returnedTodo.getIsCompleted(),equalTo(addTodoRequest.getIsCompleted()));
    }
    @Story("Should Not Be Able To Add Todo If Is Completed Missing")
    @Test(description = "should Not Be Able To Add Todo If Is Completed Missing")
    public void shouldNotBeAbleToAddTodoIfIsCompletedMissing(){

        AddTodoRequest addTodoRequest = new AddTodoRequest("Learn Appium");

        UserSteps userSteps = new UserSteps();
        userSteps.getRegisteredUser();
        String token = userSteps.getToken();

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
        userSteps.getRegisteredUser();
        String token = userSteps.getToken();

        TodoSteps todoSteps = new TodoSteps();
        AddTodoRequest addTodoRequest = todoSteps.generateTodo();

        Response response = todoSteps.addTodo(addTodoRequest,token);
        AddTodoResponse addTodoResponse = response.body().as(AddTodoResponse.class);

        Response getTodoResponse = todoSteps.getTodoByID(token,addTodoResponse.getId());
        GetTodoResponse returnedTodo = getTodoResponse.body().as(GetTodoResponse.class);

        assertThat(getTodoResponse.statusCode(),equalTo(200));
        assertThat(returnedTodo.getItem(),is(equalTo(addTodoResponse.getItem())));
        assertThat(returnedTodo.getIsCompleted(),is(equalTo(addTodoResponse.getIsCompleted())));
    }
    @Story("Should Be Able To Delete Todo By ID")
    @Test(description="should Be Able To Delete Todo By ID")
    public void shouldBeAbleToDeleteTodoByID(){

        UserSteps userSteps = new UserSteps();
        userSteps.getRegisteredUser();
        String token = userSteps.getToken();

        TodoSteps todoSteps = new TodoSteps();
        AddTodoRequest addTodoRequest = todoSteps.generateTodo();
        AddTodoResponse addTodoResponse = todoSteps.addTodo(addTodoRequest,token).body().as(AddTodoResponse.class);

        String todoID = addTodoResponse.getId();
        Response deleteTodoResponse = todoSteps.deleteTodoByID(token,todoID);
        DeleteTodoByIdResponse deleteTodoByIdResponse = deleteTodoResponse.body().as(DeleteTodoByIdResponse.class);

        assertThat(deleteTodoResponse.statusCode(),equalTo(200));
        assertThat(addTodoResponse.getItem(),is(equalTo(deleteTodoByIdResponse.getItem())));
        assertThat(addTodoResponse.getIsCompleted(),is(equalTo(deleteTodoByIdResponse.getIsCompleted())));
    }
}
