package com.minet.order;

import com.minet.utils.FileHandler;

import java.io.IOException;

public class OrderController {
    OrderModel model = new OrderModel();
    OrderView view = new OrderView();

    public void requestProductName() {
        String productName = view.orderedProductNameMessage();

        model.setProductName(productName);
    }

    public void requestProductAmount() {
        String productAmount = view.orderedProductAmountMessage();

        model.setProductAmount(productAmount);
    }

    public void createNewOrder() {
        FileHandler fileHandlerObject = new FileHandler();
        String orderListString;

        try {
            requestProductName();
            requestProductAmount();
            orderListString = model.getProductName() + "," + model.getProductAmount();
            fileHandlerObject.writeToFile(orderListString, model.getOrderFilename());
        } catch (IOException exception) {
            System.out.println("Error while creating order for product. " + exception);
        }
    }

    public void viewOrderItems() {
        model.displayOrder(model.getOrderFilename());
    }

}
