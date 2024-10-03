package com.qacart.todo.pages.register;


public class RegisterPage {

    private static RegisterPage registerPage;

    private RegisterPageGetController get;
    private RegisterPageActController act;
    private RegisterPageVerifyController verify;

    public RegisterPageActController act() {
        return act;
    }

    public RegisterPageVerifyController verify() {
        return verify;
    }

    public RegisterPageGetController get() {
        return get;
    }


    // Constructor
    private RegisterPage() {
    }

    private RegisterPage(RegisterPageGetController get, RegisterPageActController act, RegisterPageVerifyController verify) {
        this.get = get;
        this.act = act;
        this.verify = verify;
    }

    public static RegisterPage getRegisterPage() {
        if (registerPage == null) {
            registerPage = new RegisterPage(RegisterPageGetController.getRegisterPageGetController(), RegisterPageActController.getRegisterPageActController(), RegisterPageVerifyController.getRegisterPageVerifyController());
        }
        return registerPage;
    }

}
