package com.minet.recipt;

import java.util.Scanner;

public class ReciptView {
    Scanner scanner = new Scanner(System.in);

    public String productNameMessage() {
        System.out.println("Please enter product name");

        return scanner.nextLine();
    }

    public String productPriceMessage() {
        System.out.println("Please enter purchased product price");

        return scanner.nextLine();
    }

    public String customerNameMessage() {
        System.out.println("Please enter customer name");

        return scanner.nextLine();
    }
}
