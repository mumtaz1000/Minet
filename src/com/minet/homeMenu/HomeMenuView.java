package com.minet.homeMenu;

import com.minet.utils.PrintHandler;

import java.util.List;


public class HomeMenuView {
    public HomeMenuView(List<String> menuOptions) {
        PrintHandler.clearScreen();
        PrintHandler.appTitle();
        System.out.println("Main menu options:");
        PrintHandler.optionList(menuOptions);
        PrintHandler.printRequest();
    }

}
