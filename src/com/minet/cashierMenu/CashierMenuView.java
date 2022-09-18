package com.minet.cashierMenu;

import com.minet.utils.PrintHandler;

import java.util.List;

public class CashierMenuView {
    public CashierMenuView(List<String> menuOptions) {
        PrintHandler.clearScreen();
        PrintHandler.appTitle();
        System.out.println("Cashier menu options:");
        PrintHandler.optionList(menuOptions);
        printRequest();
    }
    public void printRequest(){
        System.out.print("Choose an option press enter: ");
    }
}
