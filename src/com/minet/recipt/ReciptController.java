package com.minet.recipt;

import com.minet.utils.FileHandler;

import java.io.IOException;

public class ReciptController {
    ReciptView view = new ReciptView();
    ReciptModel model = new ReciptModel();

    private void requestProductName() {
        String productName = view.productNameMessage();

        model.setProductName(productName);
    }

    private void requestProductPrice() {
        String productPrice = view.productPriceMessage();

        model.setProductPrice(productPrice);
    }

    private void requestCustomerName() {
        String customerName = view.customerNameMessage();

        model.setCustomerName(customerName);
    }

    private void requestReciptNumber() {
        String reciptNumber = view.reciptNumberMessage();

        model.setRequiredReciptNumber(reciptNumber);
    }
    public void createNewRecipt() throws IOException {
        String recipeNo = model.createReciptNumber();
        FileHandler file = new FileHandler();
        String reciptData;

        requestProductName();
        requestProductPrice();
        requestCustomerName();

        reciptData = model.createReciptString(recipeNo, model.getCustomerName(), model.getProductName(), model.getProductPrice());
        file.writeToFile(reciptData, model.getFilename());
    }

    public void requestReciptNumberToSearch(){

        requestReciptNumber();
        model.searchReciptNumber(model.getFilename(),model.getRequiredReciptNumber());
    }
}
