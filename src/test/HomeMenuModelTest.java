package test;

import com.minet.homeMenu.HomeMenuModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HomeMenuModelTest {

    @Test
    void homeMenuExceptionTest() {
        HomeMenuModel model = new HomeMenuModel();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> model.handleOption(9), "");

        Assertions.assertThrows(NumberFormatException.class, () -> model.handleOption(Integer.parseInt("option")), "");
    }
}