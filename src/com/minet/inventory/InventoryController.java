package com.minet.inventory;

import com.minet.utils.FileHandler;

import java.io.IOException;

public class InventoryController {
    protected InventoryModel model = new InventoryModel();
    private InventoryView view = new InventoryView();

    public void requestProductName() {
        String productName = view.productNameMessage();

        model.setProductName(productName);
    }

    public void requestProductAmount() {
        String productAmount = view.productAmountMessage();

        model.setProductQuantity(productAmount);
    }

    public void requestProductPrice() {
        String productName = view.productPriceMessage();

        model.setSingleProductPrice(productName);
    }

    public void viewInventory(){
        FileHandler fileHandlerObject = new FileHandler();

        fileHandlerObject.readFromFile(model.getInventoryFileName());
    }
    public void addProductToInventory() {
        FileHandler fileHandlerObject = new FileHandler();
        String productString;
        int productNameIndex = 1;

        try {
            requestProductName();
            requestProductAmount();
            if (fileHandlerObject.searchDataFromFile(model.getProductName(), productNameIndex, model.getInventoryFileName())) {
                System.out.println("Product found");
                model.addProductAmount(model.getInventoryFileName(), model.getProductName(), model.getProductQuantity());
            } else {
                requestProductPrice();
                productString = model.createProductString(model.getProductName(), model.getSingleProductPrice(), model.getProductQuantity());
                fileHandlerObject.writeToFile(productString, model.getInventoryFileName());
            }
        } catch (IOException exception) {
            System.out.println("Error while adding product to inventory. " + exception);
        }
    }

    public void removeProductFromInventory() {
        FileHandler fileHandlerObject = new FileHandler();
        String productString;
        int productNameIndex = 1;
        try {
            requestProductName();
            requestProductAmount();
            if (fileHandlerObject.searchDataFromFile(model.getProductName(), productNameIndex, model.getInventoryFileName())) {
                System.out.println("Product found!");
                model.reduceProductAmount(model.getInventoryFileName(), model.getProductName(), model.getProductQuantity());
            } else {
                System.out.println("Required product is out of stock");
            }
        } catch (IOException exception) {
            System.out.println("Error while removing product from inventory. " + exception);
        }
    }

}
