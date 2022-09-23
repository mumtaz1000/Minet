package com.minet.homeMenu;

import com.minet.login.Login;
import com.minet.signup.Signup;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class HomeMenuModel {
    private final List<String> menuOptions = List.of("Login", "Signup", "Exit the program press 0");

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException, NoSuchAlgorithmException, IOException {
        boolean isLogout = false;
        while (!isLogout) {
            switch (selectedOption) {
                case 1 -> {
                    Login login = new Login();
                    login.requestLogin();
                }
                case 2 -> {
                    Signup signup = new Signup();
                    signup.requestSignup();
                }
                case 0 -> {
                    isLogout = true;
                }
                default -> throw new IndexOutOfBoundsException();
            }
        }
    }
}
