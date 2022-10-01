package com.qacart.todo.pages;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends PageBase {

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

    public TodoPage(WebDriver driver){
        super(driver);
    }

    @Step
    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.TODO_PAGE_ENDPOINT);
        return this;
    }
    @Step
    public boolean isWelcomeDisplayed(){
        return welcomeMessage.isDisplayed();
    }

    @Step
    public NewTodoPage clickOnPlusButton(){
        addButton.click();
        return new NewTodoPage(driver);
    }
    @Step
    public TodoPage clickOnDeleteButton(){
        deleteButton.click();
        return this;
    }
    @Step
    public String getTodoText(){
        return todoItem.getText();
    }
    @Step
    public boolean isNoTodosMessageDisplayed(){
        return noTodosMessage.isDisplayed();
    }

}
