package com.minet.recipt;

import com.minet.utils.FileHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReciptModel {
    private final String filename = "src/assets/Recipts.txt";
    private String productName;
    private String productPrice;
    private String CustomerName;

    public String getFilename(){
        return filename;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String createReciptNumber() {
        LocalDateTime date = LocalDateTime.now();
        String reciptNumber;

        DateTimeFormatter requiredFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        reciptNumber = date.format(requiredFormat);
        return reciptNumber;
    }

    public String createReciptString(String reciptNo, String customerName, String productName, String productPrice) {
        return reciptNo + "," + customerName + "," + productName + "," + productPrice;
    }

    public void searchReciptNumber (String filename,String reciptNumber){
        FileHandler file = new FileHandler();

        file.readFile(filename, reciptNumber);
    }

}
