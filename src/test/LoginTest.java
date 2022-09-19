package test;

import com.minet.login.Login;
import com.minet.utils.PasswordHandler;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @Test
    void checkPasswordTest() throws NoSuchAlgorithmException {
        Login login = new Login();

        String userData = "Check,chk123,a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3,Cashier";
        String password = PasswordHandler.createCrypticPassword("123");
        assertTrue(login.checkPassword(userData,password),"Password matches");
    }

}