package com.qacart.todo.pages.todo;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.pages.newTodo.NewTodoPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TodoPage extends PageBase {
    private WebDriver driver;

    @FindBy(css = "[data-testid='welcome']")
    private WebElement welcomeMessage;

    @FindBy(css = "[data-testid='add']")
    private WebElement addButton;

    @FindBy(css ="[data-testid='todo-item']")
    private WebElement todoItem;

    @FindBy(css ="[data-testid='delete']")
    private WebElement deleteButton;

    @FindBy(css ="[data-testid='no-todos']")
    private WebElement noTodosMessage;

    public TodoPage(WebDriver webDriver){
        super(webDriver);
        this.driver = webDriver;
    }

    @Step("Load Todo page")
    public TodoPage load(){
        driver.get(EndPoint.TODO_PAGE_ENDPOINT);
        wait.until(ExpectedConditions.urlToBe(EndPoint.TODO_PAGE_ENDPOINT));
        return this;
    }
    public boolean isWelcomeDisplayed(){
        wait.until(ExpectedConditions.urlToBe(EndPoint.TODO_PAGE_ENDPOINT));
        return this.welcomeMessage.isDisplayed();
    }

    @Step("Click on plus button")
    public NewTodoPage clickOnPlusButton(){
        click(this.addButton);
        wait.until(ExpectedConditions.urlToBe(EndPoint.NEW_TODO_ENDPOINT));
        return new NewTodoPage(this.driver);
    }
    @Step("Click on delete button")
    public TodoPage clickOnDeleteButton(){
        click(this.deleteButton);
        return this;
    }
    public String getTodoText(){
        wait.until(ExpectedConditions.visibilityOf(todoItem));
        return this.todoItem.getText();
    }
    public boolean isNoTodosMessageDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(noTodosMessage));
        return this.noTodosMessage.isDisplayed();
    }

}
