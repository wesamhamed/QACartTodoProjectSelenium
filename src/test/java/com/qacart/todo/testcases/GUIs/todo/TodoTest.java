package com.qacart.todo.testcases.GUIs.todo;

import com.qacart.todo.api.todo.TodoApi;
import com.qacart.todo.api.user.register.RegisterApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.register.requestBody.RegisterRequestBody;
import com.qacart.todo.models.register.responseBody.RegisterResponseBody;
import com.qacart.todo.models.todo.addTodo.requestBody.AddTodoRequestBody;
import com.qacart.todo.pages.home.HomePage;
import com.qacart.todo.pages.todo.TodoPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;


@Feature("Todo Feature")
public class TodoTest extends BaseTest {

    RegisterApi registerApi = RegisterApi.getRegisterApi();
    HomePage homePage = HomePage.getHomePage();
    TodoPage todoPage = TodoPage.getTodoPage();
    TodoApi todoApi = TodoApi.getTodoApi();

    @Story("Add Todo")
    @Test(description = "Should be able to add a new todo correctly")
    public void shouldBeAbleToAddNewTodo() {

        RegisterRequestBody registerRequestBody = registerApi.get()
                .generateUser();

        Response registerResponse = registerApi.act()
                .register(registerRequestBody);


        homePage.act()
                .load(getDriver());

        List<Cookie> cookies = registerResponse.detailedCookies().asList();
        injectCookiesToBrowser(cookies);

        todoPage.act()
                .load(getDriver());

        String todoText = "Learn Selenium";

        todoPage.act()
                .clickOnPlusButton(getDriver())
                .addNewTask(getDriver(), todoText);

        String getTodoText = todoPage.get()
                .getTodoText(getDriver());

        todoPage.verify()
                .addedTodoTextIsCorrect(todoText, getTodoText);

    }

    @Story("Delete Todo")
    @Test(description = "Should be able to delete a todo correctly")
    public void shouldBeAbleToDeleteTodo() {

        RegisterRequestBody registerRequestBody = registerApi.get()
                .generateUser();

        Response registerResponse = registerApi.act()
                .register(registerRequestBody);


        RegisterResponseBody registerResponseBody = registerApi.get()
                .registerResponseBody(registerResponse);

        homePage.act()
                .load(getDriver());


        List<Cookie> cookies = registerResponse.detailedCookies().asList();
        injectCookiesToBrowser(cookies);

        String token = registerResponseBody.getAccess_token();

        AddTodoRequestBody addTodoRequest = todoApi.get()
                .generateTodo();

        todoApi.act()
                .addTodo(addTodoRequest, token);


        todoPage.act()
                .load(getDriver());

        todoPage.act()
                .clickOnDeleteButton(getDriver());

        todoPage.verify()
                .noTodosMessageIsDisplayed(getDriver());

    }

}
