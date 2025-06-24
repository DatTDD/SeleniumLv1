package com.tests.logintest;

import com.example.Constant.Constant;
import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase01 extends TestBase {

    @Test
    public void testCase01() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.validUsername,Constant.validPassword);

        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.welcomeText(), Constant.welcomeMessage, "");
    }

}
