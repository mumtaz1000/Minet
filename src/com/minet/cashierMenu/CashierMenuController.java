package com.minet.cashierMenu;

import com.minet.utils.PrintHandler;

import java.util.Scanner;

public class CashierMenuController {
    private final CashierMenuView view;
    private final CashierMenuModel model;
    private final Scanner scanner;

    public CashierMenuController(CashierMenuModel model, CashierMenuView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void requestUserInput() {
        String input = scanner.nextLine();

        try {
            int selectedOption = Integer.parseInt(input);

            model.handleOption(selectedOption);
        }
        catch (NumberFormatException | IndexOutOfBoundsException exception) {
            PrintHandler.printInvalidOption();
            PrintHandler.printRequest();
            requestUserInput();
        }
    }
}
