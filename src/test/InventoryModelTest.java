package test;

import com.minet.inventory.InventoryModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;


class InventoryModelTest {
    InventoryModel model = new InventoryModel();

    @Test
    void reducedProductAmountTest() throws IOException {
        model.reduceProductAmount(model.getInventoryFileName(),"Bottle","40");
    }

}