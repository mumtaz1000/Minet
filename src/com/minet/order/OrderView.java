package com.minet.order;

import java.util.Scanner;

public class OrderView {
    Scanner scanner = new Scanner(System.in);

    public String orderedProductNameMessage() {

        System.out.println("Please enter product name");
        return scanner.next();
    }

    public String orderedProductAmountMessage() {

        System.out.println("Please enter product amount");
        return scanner.next();
    }
}
