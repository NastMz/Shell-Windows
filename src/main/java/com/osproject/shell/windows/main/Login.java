package com.osproject.shell.windows.main;

public class Login {

    private boolean login = false;

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public boolean login(String userName, String password) {
        boolean flag = false;
        if (userName.equals("a") && password.equals("a")) {
            flag = true;
        }
        return flag;
    }

}
