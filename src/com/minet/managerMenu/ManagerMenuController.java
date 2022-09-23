package com.minet.managerMenu;

import com.minet.utils.PrintHandler;

import java.util.Scanner;

public class ManagerMenuController {
    private final ManagerMenuModel model;
    private final Scanner scanner;

    public ManagerMenuController(ManagerMenuModel model) {
        this.model = model;
        this.scanner = new Scanner(System.in);
    }

    public void requestUserInput() {
        String input = scanner.nextLine();

        try {
            int selectedOption = Integer.parseInt(input);

            model.handleOption(selectedOption);
        } catch (NumberFormatException | IndexOutOfBoundsException exception) {
            PrintHandler.printInvalidOption();
            PrintHandler.printRequest();
            requestUserInput();
        }
    }
}
