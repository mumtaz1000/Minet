package com.minet.managerMenu;

public class ManagerMenu {
    public ManagerMenu() {
        ManagerMenuModel model = new ManagerMenuModel();
        ManagerMenuView view = new ManagerMenuView(model.getMenuOptions());
        ManagerMenuController controller = new ManagerMenuController(model);

        controller.requestUserInput();
    }
}