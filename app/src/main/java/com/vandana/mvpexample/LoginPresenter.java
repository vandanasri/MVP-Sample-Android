package com.vandana.mvpexample;

import android.os.Handler;
import android.os.Looper;

public class LoginPresenter implements ILoginPresenter {

    ILoginResult iLoginResult;
    IUser user;
    Handler handler;

    public LoginPresenter(ILoginResult iLoginResult) {
        this.iLoginResult = iLoginResult;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLogin(String userName, String passwordd) {
        user = new UserModel(userName,passwordd);
        Boolean isLoginSuccess = true;
        final int code = user.checkValidity(userName,passwordd);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginResult.onLoginResult(result, code);
            }
        }, 2000);
    }

    @Override
    public void setProgressBarVisiblity(int visiblity) {
        iLoginResult.onSetProgressBarVisibility(visiblity);

    }

}
