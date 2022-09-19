package test;

import com.minet.order.OrderModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderModelTest {
    OrderModel model = new OrderModel();

    @Test
    void ProductNameTest() {
        model.setProductName("New Product");
        assertEquals(model.getProductName(),"New Product");
    }

    @Test
    void ProductAmountTest() {
        model.setProductAmount("12");
        assertEquals(model.getProductAmount(),"12");
    }

    @Test
    void getOrderFilenameTest() {
        assertNotNull(model.getOrderFilename());
    }
}