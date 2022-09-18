package com.minet.inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InventoryModelTest {
    InventoryModel model = new InventoryModel();

    @Test
    void reducedProductAmountTest() throws IOException {
        model.reduceProductAmount(model.getInventoryFileName(),"Bottle","40");
    }

}