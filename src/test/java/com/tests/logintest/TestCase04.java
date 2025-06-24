package com.tests.logintest;

import com.example.Constant.Constant;
import com.example.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.annotations.Test;

public class TestCase04 extends TestBase {

    @Test
    public void TestCase04(){
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.validusername,"12345678901234567890");

    }
}
