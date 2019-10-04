package com.vandana.mvpexample;

public class UserModel implements IUser {

    String userName;
    String password;

    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getUserPassword() {
        return password;
    }

    @Override
    public int checkValidity(String userName, String password) {
        if (userName.equals("")||password.equals("")){
            return -1;
        }
        return 0;

    }
}
