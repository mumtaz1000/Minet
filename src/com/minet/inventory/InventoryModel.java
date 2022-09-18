package com.minet.inventory;

import com.minet.utils.FileHandler;

import java.io.IOException;
import java.util.List;

public class InventoryModel {
    private final String fileName = "src/assets/Inventory.txt";
    private String productName;
    private String productQuantity;
    private String singleProductPrice;

    public String getInventoryFileName() {
        return fileName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getSingleProductPrice() {
        return singleProductPrice;
    }

    public void setSingleProductPrice(String singleProductPrice) {
        this.singleProductPrice = singleProductPrice;
    }

    public String createProductString(String productName, String productPrice, String productAmount) {
        return productName + "," + productAmount + "," + productPrice;
    }

    public void addProductAmount(String filename, String productName, String productAmountToAdd) throws IOException {
        FileHandler fileHandlerObject = new FileHandler();
        String updatedString;
        int productQuantityIndex = 2;
        String productString = fileHandlerObject.readFile(filename, productName);
        List<String> productList = fileHandlerObject.singleUserData(productString, 0);
        int totalProductAmount = Integer.parseInt(productList.get(productQuantityIndex));
        int updateAmount = totalProductAmount + Integer.parseInt(productAmountToAdd);

        productList.set(productQuantityIndex, String.valueOf(updateAmount));
        updatedString = String.join(",", productList);
        fileHandlerObject.updateFile(productString, updatedString, getInventoryFileName());
    }

    public void reduceProductAmount(String filename, String productName, String productAmountToRemove) throws IOException{
        FileHandler fileHandlerObject = new FileHandler();
        String updatedString;
        int productQuantityIndex = 2;
        String productString = fileHandlerObject.readFile(filename, productName);
        List<String> productList = fileHandlerObject.singleUserData(productString, 0);
        int totalProductAmount = Integer.parseInt(productList.get(productQuantityIndex));
        int updatedAmount = totalProductAmount - Integer.parseInt(productAmountToRemove);

        if (updatedAmount > 1 ) {
            productList.set(productQuantityIndex, String.valueOf(updatedAmount));
            updatedString = String.join(",",productList);
            fileHandlerObject.updateFile(productString, updatedString, getInventoryFileName());
        } else {
            System.out.println("Product is out of stock!!!");
        }
    }

    public void reduceProductAmount() {
    }
}
