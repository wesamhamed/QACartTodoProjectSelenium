package com.qacart.todo.testcases;

import com.qacart.todo.api.todo.addTodo.AddTodoApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.models.register.responseBody.RegisterResponseBody;
import com.qacart.todo.models.todo.addTodo.requestBody.AddTodoRequestBody;
import com.qacart.todo.pages.home.HomePage;
import com.qacart.todo.pages.todo.TodoPage;
import com.qacart.todo.steps.TodoSteps;
import com.qacart.todo.steps.UserSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


@Feature("Todo Feature")
public class TodoTest extends BaseTest {
    @Story("Add Todo")
    @Test(description = "Should be able to add a new todo correctly")
    public void shouldBeAbleToAddNewTodo(){

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequestBody = userSteps.generateUser();
        Response registerResponse = userSteps.register(registerRequestBody);

        HomePage homePage = new HomePage(getDriver());
        homePage.load();

        List<Cookie> cookies = registerResponse.detailedCookies().asList();
        injectCookiesToBrowser(cookies);

        TodoPage todoPage = new TodoPage(getDriver())
                            .load();

        String todoText = "Learn Selenium";
        String getTodoText = todoPage
                                    .clickOnPlusButton()
                                    .addNewTask(todoText)
                                    .getTodoText();

        Assert.assertEquals(todoText,getTodoText);
    }

    @Story("Delete Todo")
    @Test(description = "Should be able to delete a todo correctly")
    public void shouldBeAbleToDeleteTodo(){

        UserSteps userSteps = new UserSteps();
        RegisterRequestBody registerRequestBody = userSteps.generateUser();
        Response registerResponse = userSteps.register(registerRequestBody);
        RegisterResponseBody registerResponseBody = registerResponse.body().as(RegisterResponseBody.class);

        HomePage homePage = new HomePage(getDriver());
        homePage.load();

        List<Cookie> cookies= registerResponse.detailedCookies().asList();
        injectCookiesToBrowser(cookies);

        String token = registerResponseBody.getAccess_token();

        TodoSteps todoSteps = new TodoSteps();
        AddTodoRequestBody addTodoRequest = todoSteps.generateTodo();

        todoSteps.addTodo(addTodoRequest,token);

        TodoPage todoPage = new TodoPage(getDriver())
                                    .load();

        boolean isNoTodosMessageDisplayed  = todoPage
                                            .clickOnDeleteButton()
                                            .isNoTodosMessageDisplayed();

        Assert.assertTrue(isNoTodosMessageDisplayed);
    }

}
