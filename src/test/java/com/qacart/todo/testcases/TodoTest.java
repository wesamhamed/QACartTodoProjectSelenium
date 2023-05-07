package com.qacart.todo.testcases;

import com.qacart.todo.api.todo.addTodo.AddTodoApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.register.request.RegisterRequest;
import com.qacart.todo.models.todo.addTodo.request.AddTodoRequest;
import com.qacart.todo.pages.home.HomePage;
import com.qacart.todo.pages.todo.TodoPage;
import com.qacart.todo.steps.TodoSteps;
import com.qacart.todo.steps.UserSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;


@Feature("Todo Feature")
public class TodoTest extends BaseTest {
    @Story("Add Todo")
    @Test(description = "Should be able to add a new todo correctly")
    public void shouldBeAbleToAddNewTodo(){

        UserSteps userSteps = new UserSteps();
        RegisterRequest registerRequest = userSteps.getRegisteredUser();

        HomePage homePage = new HomePage(getDriver());
        homePage.load();

        injectCookiesToBrowser(userSteps.getCookies());

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
         userSteps.getRegisteredUser();

        HomePage homePage = new HomePage(getDriver());
        homePage.load();

        injectCookiesToBrowser(userSteps.getCookies());

        String token = userSteps.getToken();

        TodoSteps todoSteps = new TodoSteps();
        AddTodoRequest addTodoRequest = todoSteps.generateTodo();

        AddTodoApi.addTodo(addTodoRequest,token);

        TodoPage todoPage = new TodoPage(getDriver())
                                    .load();

        boolean isNoTodosMessageDisplayed  = todoPage
                                            .clickOnDeleteButton()
                                            .isNoTodosMessageDisplayed();

        Assert.assertTrue(isNoTodosMessageDisplayed);
    }

}
