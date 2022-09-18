package com.minet.order;

import com.minet.utils.FileHandler;

public class OrderModel {
    private static final String orderFilename = "src/assets/OrderItems.txt";
    private String productName;
    private String productAmount;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(String productAmount) {
        this.productAmount = productAmount;
    }

    public String getOrderFilename(){
        return orderFilename;
    }
    public void displayOrder(String filename) {
        FileHandler fileHandlerObject = new FileHandler();

        fileHandlerObject.readFromFile(filename);
    }

}
