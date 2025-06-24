package com.tests.logintest;

import com.example.Constant.Constant;
import com.example.pages.LoginPage;
import com.tests.base.TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase02 extends TestBase {

    @Test
    public void testCase02() {
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginTab();
        loginPage.login("",Constant.validPassword);
        Assert.assertEquals(loginPage.loginErrorMessage(), Constant.blankEmailOrPasswordErrorMessage, "Đăng nhập thất bại");
    }

//    @Test
//    public void testCase03() {
//        LoginPage loginPage = new LoginPage();
//        loginPage.login(Constant.validUsername, "");
//        Assert.assertEquals(loginPage.loginErrorMessage(), Constant.blankEmailOrPasswordErrorMessage, "Đăng nhập thất bại");
//    }

}
