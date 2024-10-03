package com.qacart.todo.pages.login;

public class LoginPage {

    private static LoginPage loginPage;

    private LoginPageGetController get;
    private LoginPageActController act;
    private LoginPageVerifyController verify;

    public LoginPageActController act() {
        return act;
    }

    public LoginPageVerifyController verify() {
        return verify;
    }

    public LoginPageGetController get() {
        return get;
    }

    // Constructor
    private LoginPage() {
    }

    private LoginPage(LoginPageGetController get, LoginPageActController act, LoginPageVerifyController verify) {
        this.get = get;
        this.act = act;
        this.verify = verify;
    }

    public static LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(LoginPageGetController.getLoginPageGetController(), LoginPageActController.getLoginPageActController(), LoginPageVerifyController.getLoginPageVerifyController());
        }
        return loginPage;
    }

}
