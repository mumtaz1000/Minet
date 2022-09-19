package test;

import com.minet.cashierMenu.CashierMenuModel;
import com.minet.homeMenu.HomeMenuModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierMenuModelTest {

    @Test
    void CashierMenuModelExceptionTest() {
        CashierMenuModel model = new CashierMenuModel();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> model.handleOption(9), "");

        Assertions.assertThrows(NumberFormatException.class, () -> model.handleOption(Integer.parseInt("option")), "");
    }


}