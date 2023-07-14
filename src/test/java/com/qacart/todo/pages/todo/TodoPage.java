package com.qacart.todo.pages.todo;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.newTodo.NewTodoPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TodoPage extends PageBase{
    private static TodoPage todoPage;

    // Elements
    private By welcomeMessageLocator = By.cssSelector("[data-testid='welcome']");
    private By addButtonLocator = By.cssSelector("[data-testid='add']");
    private By todoItemLocator = By.cssSelector("[data-testid='todo-item']");
    private By deleteButtonLocator = By.cssSelector("[data-testid='delete']");
    private By noTodosMessageLocator = By.cssSelector("[data-testid='no-todos']");

    public static TodoPage getInstance() {
        if (todoPage == null) {
            todoPage = new TodoPage();
        }
        return todoPage;
    }

    @Step("Visiting Todo page")
    public TodoPage load(WebDriver driver) {
        visit(driver,EndPoint.TODO_PAGE_ENDPOINT);
        return this;
    }

    // Methods, Steps
    @Step("Check if the welcome message is displayed")
    public boolean isWelcomeDisplayed(WebDriver driver) {
        return isDisplayed(driver,welcomeMessageLocator);
    }

    @Step("Click on the plus button")
    public NewTodoPage clickOnPlusButton(WebDriver driver) {
        click(driver,addButtonLocator);
        return NewTodoPage.getInstance();
    }

    @Step("Click on the delete icon")
    public TodoPage clickOnDeleteButton(WebDriver driver) {
        click(driver,deleteButtonLocator);
        return TodoPage.getInstance();
    }

    @Step("Get the text of the todo")
    public String getTodoText(WebDriver driver) {
        return getText(driver,todoItemLocator);
    }

    @Step("Check if no todos message is displayed")
    public boolean isNoTodosMessageDisplayed(WebDriver driver) {
        return isDisplayed(driver,noTodosMessageLocator);
    }

}
