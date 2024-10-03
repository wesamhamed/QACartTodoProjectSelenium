package com.qacart.todo.api.user.login;


public class LoginApi {

    private static LoginApi loginApi;

    private LoginApiGetController get;
    private LoginApiActController act;
    private LoginApiVerifyController verify;

    public LoginApiActController act() {
        return act;
    }

    public LoginApiVerifyController verify() {
        return verify;
    }

    public LoginApiGetController get() {
        return get;
    }

    private LoginApi() {

    }

    private LoginApi(LoginApiGetController get, LoginApiActController act, LoginApiVerifyController verify) {
        this.get = get;
        this.act = act;
        this.verify = verify;
    }

    public static LoginApi getLoginApi() {
        if (loginApi == null) {
            loginApi = new LoginApi(LoginApiGetController.getLoginApiGetController(), LoginApiActController.getLoginApiActController(), LoginApiVerifyController.getLoginApiVerifyController());
        }
        return loginApi;
    }

}
