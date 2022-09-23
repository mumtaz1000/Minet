package com.minet.cashierMenu;

import com.minet.utils.PrintHandler;

import java.io.IOException;
import java.util.Scanner;

public class CashierMenuController {
    private final CashierMenuModel model;
    private final Scanner scanner;

    public CashierMenuController(CashierMenuModel model) {
        this.model = model;
        this.scanner = new Scanner(System.in);
    }

    public void requestUserInput() {
        String input = scanner.nextLine();

        try {
            int selectedOption = Integer.parseInt(input);

            model.handleOption(selectedOption);
        }
        catch (NumberFormatException | IndexOutOfBoundsException | IOException exception) {
            PrintHandler.printInvalidOption();
            PrintHandler.printRequest();
            requestUserInput();
        }
    }

}
