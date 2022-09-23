package com.minet.managerMenu;

import com.minet.utils.PrintHandler;

import java.util.List;

public class ManagerMenuView {
    public ManagerMenuView(List<String> menuOptions) {
        PrintHandler.clearScreen();
        PrintHandler.appTitle();
        System.out.println("Manager menu options:");
        PrintHandler.optionList(menuOptions);
        printRequest();
    }
    public void printRequest(){
        System.out.print("Choose an option press enter: ");
    }
}
