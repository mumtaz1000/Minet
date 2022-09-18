package com.minet.cashierMenu;

import com.minet.homeMenu.HomeMenu;
import com.minet.inventory.InventoryController;
import com.minet.order.OrderController;

import java.util.List;

public class CashierMenuModel {
    InventoryController inventoryController = new InventoryController();
    OrderController orderController = new OrderController();
    private final List<String> menuOptions = List.of("View products inside an inventory",
                                                    "Add product in inventory",
                                                    "Remove product from inventory",
                                                    "Search for transaction",
                                                    "Place an order for product",
                                                    "Press 0 to back to home menu");

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException {
        switch (selectedOption) {
            case 1 -> inventoryController.viewInventory();
            case 2 -> inventoryController.addProductToInventory();
            case 3 -> inventoryController.removeProductFromInventory();
            case 4 -> System.out.println("Search for transaction");
            case 5 -> orderController.createNewOrder();
            case 0 -> new HomeMenu();
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
