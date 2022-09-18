package com.minet.inventory;

import java.util.Scanner;

public class InventoryView {
    Scanner scanner = new Scanner(System.in);

    public String productNameMessage() {

        System.out.println("Please enter product name");
        return scanner.next();
    }

    public String productAmountMessage() {

        System.out.println("Please enter product amount");
        return scanner.next();
    }

    public String productPriceMessage() {

        System.out.println("Please enter product price");
        return scanner.next();
    }
}
