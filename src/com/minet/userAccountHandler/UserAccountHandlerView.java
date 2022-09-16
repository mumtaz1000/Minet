package com.minet.userAccountHandler;

import java.util.Scanner;

public class UserAccountHandlerView {
    Scanner scanner = new Scanner(System.in);

    public String requestFullName() {

        System.out.println("Please enter your full name");
        return scanner.next();
    }

    public String requestUserName() {

        System.out.println("Please enter your user name");
        return scanner.next();
    }

    public String requestPassword() {

        System.out.println("Please enter your password");
        return scanner.next();
    }

}
