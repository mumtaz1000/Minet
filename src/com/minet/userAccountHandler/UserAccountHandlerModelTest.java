package com.minet.userAccountHandler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAccountHandlerModelTest {
    private UserAccountHandlerModel model;

    @BeforeEach
    void init() {
        model = new UserAccountHandlerModel();
    }

    @Test
    void getFullnameTest(){
        model.setFullname("Fullname");
        assertEquals("Fullname",model.getFullname());
    }
    @Test
    void getUserNameTest() {
        model.setFullname("Check123");
        String Name = model.getFullname();
        assertNotNull(Name);
        assertEquals("Check123", model.getFullname());
    }


}