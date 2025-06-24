package com.tests.logintest;

import com.example.Constant.Constant;
import com.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase05 {

    @Test
    public void TestCase05() {
        LoginPage loginPage = new LoginPage();

        for (int i = 1; i < 5; i++){
            loginPage.login(Constant.validUsername,Constant.inValidPassword);
        }

        Assert.assertEquals(loginPage.loginErrorMessage(),Constant.fourTimesLoginFailMessage,"");
    }
}
