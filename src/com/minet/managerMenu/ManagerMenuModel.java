package com.minet.managerMenu;

import com.minet.homeMenu.HomeMenu;
import com.minet.inventory.InventoryController;
import com.minet.order.OrderController;
import com.minet.recipt.ReciptController;

import java.io.IOException;
import java.util.List;

public class ManagerMenuModel {
    OrderController orderController = new OrderController();
    InventoryController inventoryController = new InventoryController();
    private final List<String> menuOptions = List.of("View order list",
                                                    "View inventory",
                                                    "Press 0 to back to home menu");

    public List<String> getMenuOptions() {
        return menuOptions;
    }

    public void handleOption(int selectedOption) throws IndexOutOfBoundsException{
        switch (selectedOption) {
            case 1 -> orderController.viewOrderItems();
            case 2 -> inventoryController.viewInventory();
            case 0 -> new HomeMenu();
            default -> throw new IndexOutOfBoundsException();
        }
    }
}
