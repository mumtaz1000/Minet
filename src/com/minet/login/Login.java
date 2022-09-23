package com.minet.login;

import com.minet.cashierMenu.CashierMenu;
import com.minet.managerMenu.ManagerMenu;
import com.minet.userAccountHandler.UserAccountHandlerController;
import com.minet.utils.FileHandler;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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
            System.out.println();
            System.out.println("----------------------");
            System.out.println("Login menu:");
            requestUsername();
            if (fileHandlerObject.searchDataFromFile(model.getUsername(), usernameIndex, model.getUserFileName())) {
                requestPassword();
                crypticPassword = createCrypticPassword(model.getPassword());
                allUserData = file.readFile(model.getUserFileName(), model.getUsername());
                userData = String.valueOf(fileHandlerObject.singleUserData(allUserData,1));
                isPasswordCorrect = checkPassword(userData, crypticPassword);
                if (isPasswordCorrect) {
                    userRole = fileHandlerObject.singleUserData(String.valueOf(allUserData),1).get(3);
                    handleUserMenu(userRole);
                } else {
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

    public boolean checkPassword(String userData, String passwordInput) {
        String password;
        boolean isPasswordCorrect = false;
        int passwordIndex = 2;
        String[] parts = userData.split(",");

        password = parts[passwordIndex].trim();

        if (Objects.equals(password, passwordInput)) {
            isPasswordCorrect = true;
        }
        return isPasswordCorrect;
    }

    private void handleUserMenu(String userRole) {
        switch (userRole) {
            case "Admin" -> {
                System.out.println("You are admin");
            }
            case "Manager" -> {
                new ManagerMenu();
            }
            case "Cashier" -> {
                new CashierMenu();
            }
            default -> System.out.println("Do not know abut this position");
        }
    }
}
