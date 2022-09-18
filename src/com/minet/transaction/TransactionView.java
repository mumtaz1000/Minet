package com.minet.transaction;

import java.util.Scanner;

public class TransactionView {
    Scanner scanner = new Scanner(System.in);

    public String showReceiptMessage() {
        System.out.println("Enter the receipt number");

        return scanner.next();
    }
}
