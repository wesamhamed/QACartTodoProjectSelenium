package com.qacart.todo.pages;

import com.qacart.todo.base.PageBase;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends PageBase {

    public NewTodoPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "[data-testid='new-todo']")
    private WebElement newTodoInput;

    @FindBy(css = " [data-testid='submit-newTask']")
    private  WebElement newTaskSubmit;

    @Step
    public NewTodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.NEW_TODO_ENDPOINT);
        return this;
    }
    @Step
    public TodoPage addNewTask(String item){
        newTodoInput.sendKeys(item);
        newTaskSubmit.click();
        return new TodoPage(driver);
    }
}
