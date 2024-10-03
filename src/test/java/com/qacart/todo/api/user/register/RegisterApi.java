package com.qacart.todo.api.user.register;


public class RegisterApi {

    private static RegisterApi registerApi;

    private RegisterApiGetController get;
    private RegisterApiActController act;
    private RegisterApiVerifyController verify;


    public RegisterApiActController act() {
        return act;
    }

    public RegisterApiVerifyController verify() {
        return verify;
    }

    public RegisterApiGetController get() {
        return get;
    }

    private RegisterApi() {

    }

    private RegisterApi(RegisterApiGetController get, RegisterApiActController act, RegisterApiVerifyController verify) {
        this.get = get;
        this.act = act;
        this.verify = verify;
    }

    public static RegisterApi getRegisterApi() {
        if (registerApi == null) {
            registerApi = new RegisterApi(RegisterApiGetController.getRegisterApiGetController(), RegisterApiActController.getRegisterApiActController(), RegisterApiVerifyController.getRegisterApiVerifyController());
        }
        return registerApi;
    }

}
