package com.minet.utils;

import java.io.IOException;
import java.util.List;

public class PrintHandler {
    public static void appTitle() {
        System.out.println("Welcome to MiNet's Warehouse Management System");
        System.out.println(); // on purpose to make a space between the title
    }

    public static void clearScreen() {
        String OperatingSystem = System.getProperty("os.name");

        if (OperatingSystem.equals("Windows")) {
            clearScreenWindows();
        } else {
            clearScreenUnix();
        }
    }

    public static void optionBackToMainMenu() {
        System.out.println("[0] Back to main menu");
    }

    public static void optionList(List<String> options) {
        for (int index = 0; index < options.size(); index++) {
            int number = index + 1;
            String label = options.get(index);

            System.out.println("[" + number + "] " + label);
        }
    }

    private static void clearScreenUnix() {
        String clearScreenASCIICode = "\033[H\033[2J";

        System.out.print(clearScreenASCIICode);
        System.out.flush();
    }

    private static void clearScreenWindows() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException error) {
            System.out.println("A minor problem happened with the app. It will work but may not display correctly");

        }
    }

    public static void printRequest() {
        System.out.print("Choose an option press enter: ");
    }

    public static void printInvalidOption() {
        System.out.println("⚠️ Invalid option");
    }

    public static String splitFileString(List<String> listString, int option) {
        String requiredData = null;

        for (String data : listString) {
            String[] elements = data.split(",");
            requiredData = elements[option];
        }
        return requiredData;
    }
}
