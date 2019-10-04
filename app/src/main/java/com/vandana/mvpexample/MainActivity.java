package com.vandana.mvpexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ILoginResult {
    private EditText editUserName;
    private EditText editPassword;
    private Button btnLogin;
    private ProgressBar progressBar;
    private ILoginPresenter mLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginResult();
            }
        });
    }

    private void loginResult(){
        mLoginPresenter.setProgressBarVisiblity(View.VISIBLE);
        String userName = editUserName.getText().toString();
        String password = editPassword.getText().toString();
        mLoginPresenter.doLogin(userName,password);
    }
    private void initUI(){
        editUserName = (EditText) findViewById(R.id.et_name);
        editPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.bt_submit);
        progressBar = (ProgressBar) findViewById(R.id.progress_login);
        mLoginPresenter = new LoginPresenter(this);
        mLoginPresenter.setProgressBarVisiblity(View.INVISIBLE);

    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        mLoginPresenter.setProgressBarVisiblity(View.INVISIBLE);
        if (result){
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this,"Login Fail",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }
}
