package com.minet.userAccountHandler;

import com.minet.utils.PrintHandler;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class UserAccountHandlerController {
    protected final UserAccountHandlerModel model = new UserAccountHandlerModel();
    private final UserAccountHandlerView view = new UserAccountHandlerView();
    private final Scanner scanner = new Scanner(System.in);

    public void requestFullname() {
        String fullname = view.requestFullName();

        model.setFullname(fullname);
    }

    public void requestUsername() {
        String username = view.requestUserName();

        model.setUsername(username);
    }

    public void requestPassword() {
        String password = view.requestPassword();

        model.setPassword(password);
    }

    public String requestUserRole() {
        String role = null;

        System.out.println("Please choose a user role");
        PrintHandler.optionList(model.userRoleOptions());

        String input = scanner.nextLine();
        try {
            int userRole = Integer.parseInt(input);

            role = model.assignUserRole(userRole);
        } catch (NumberFormatException | IndexOutOfBoundsException exception) {
            PrintHandler.printInvalidOption();
            requestUserRole();
        }
        return role;
    }

}
