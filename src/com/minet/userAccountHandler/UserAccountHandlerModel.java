package com.minet.userAccountHandler;

import com.minet.utils.PasswordHandler;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserAccountHandlerModel {

    private final String fileName = "src/assets/UserData.txt";
    private String fullname;
    private String username;
    private String password;

    public String getUserFileName() {
        return fileName;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String assignUserRole(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
            case 1 -> {
                return "Admin";
            }
            case 2 -> {
                return "Manager";
            }
            case 3 -> {
                return "Cashier";
            }
            default -> throw new IndexOutOfBoundsException();
        }
    }

    public List<String> userRoleOptions() {
        return List.of("Admin", "Manager", "Cashier");
    }

    public String createUserCredentialString(String fullname, String username, String password, String userRole) throws NoSuchAlgorithmException {
        String crypticPassword = PasswordHandler.createCrypticPassword(password);

        return fullname + "," + username + "," + crypticPassword + "," + userRole;
    }

}
