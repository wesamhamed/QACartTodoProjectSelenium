package com.qacart.todo.pages.newTodo;


public class NewTodoPage {

    private static NewTodoPage newTodoPage;

    private NewTodoPageGetController get;
    private NewTodoPageActController act;
    private NewTodoPageVerifyController verify;

    public NewTodoPageActController act() {
        return act;
    }

    public NewTodoPageVerifyController verify() {
        return verify;
    }

    public NewTodoPageGetController get() {
        return get;
    }

    // Constructor
    private NewTodoPage() {
    }

    private NewTodoPage(NewTodoPageGetController get, NewTodoPageActController act, NewTodoPageVerifyController verify) {
        this.get = get;
        this.act = act;
        this.verify = verify;
    }

    public static NewTodoPage getNewTodoPage() {
        if (newTodoPage == null) {
            newTodoPage = new NewTodoPage(NewTodoPageGetController.getNewTodoPageGetController(), NewTodoPageActController.getNewTodoPageActController(), NewTodoPageVerifyController.getNewTodoPageVerifyController());
        }
        return newTodoPage;
    }

}
