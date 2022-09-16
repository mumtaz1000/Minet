package com.minet.login;

import com.minet.userAccountHandler.UserAccountHandlerController;
import com.minet.utils.FileHandler;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.minet.utils.PasswordHandler.createCrypticPassword;

public class Login extends UserAccountHandlerController {
    public void requestLogin() {
        FileHandler file = new FileHandler();
        String allUserData;
        FileHandler fileHandlerObject = new FileHandler();
        String crypticPassword, userData, userRole;
        final int usernameIndex = 2;
        boolean isPasswordCorrect;

        try {
            requestUsername();
            if (fileHandlerObject.searchDataFromFile(model.getUsername(), usernameIndex, model.getUserFileName())) {
                requestPassword();
                crypticPassword = createCrypticPassword(model.getPassword());
                allUserData = file.readFile(model.getUserFileName(), model.getUsername());         userData = String.valueOf(fileHandlerObject.singleUserData(allUserData));
                isPasswordCorrect = checkPassword(userData, crypticPassword);
                if(isPasswordCorrect){
                    userRole = fileHandlerObject.singleUserData(String.valueOf(allUserData)).get(3);
                    System.out.println("You are  "+userRole);
                }else{
                    System.out.println("Incorrect password");
                }
            } else {
                System.out.println("Username does not exist");
                requestLogin();
            }

        } catch (NoSuchAlgorithmException | IOException exception) {
            System.out.println("Error while taking user input for signup. " + exception);
        }
    }

    private boolean checkPassword(String userData, String passwordInput) {
        String password;
        boolean isPasswordCorrect = false;
        int passwordIndex = 2;
        String[] parts = userData.split(",");

        password = parts[passwordIndex].trim();

        if (Objects.equals(password,passwordInput)) {
            isPasswordCorrect = true;
        }
        return isPasswordCorrect;
    }
}
