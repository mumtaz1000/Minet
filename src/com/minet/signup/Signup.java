package com.minet.signup;

import com.minet.userAccountHandler.UserAccountHandlerController;
import com.minet.utils.FileHandler;
import com.minet.utils.PrintHandler;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Signup extends UserAccountHandlerController {


    public void requestSignup() {
        FileHandler fileHandlerObject = new FileHandler();
        String userRole;
        int userNameIndex = 2;

        try {
            requestFullname();
            requestUsername();
            if (fileHandlerObject.searchDataFromFile(model.getUsername(), userNameIndex, model.getUserFileName())) {
                System.out.println("User name already exist");
                requestSignup();
            } else {
                requestPassword();
                userRole = requestUserRole();
                String userCredentialString = model.createUserCredentialString(model.getFullname(), model.getUsername(), model.getPassword(), userRole);
                fileHandlerObject.writeToFile(userCredentialString, model.getUserFileName());
            }
        } catch (IOException exception) {
            System.out.println("Error while taking user input for signup. " + exception);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
