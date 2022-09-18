package com.minet.cashierMenu;

public class CashierMenu {
    public CashierMenu(){
        CashierMenuModel model = new CashierMenuModel();
        CashierMenuView view = new CashierMenuView(model.getMenuOptions());
        CashierMenuController controller = new CashierMenuController(model, view);

        controller.requestUserInput();
    }
}