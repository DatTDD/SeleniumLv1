package com.tests.logintest;

import com.example.Constant.Constant;
import com.example.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase03 extends TestBase {

    @Test
    public void testCase03() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.validusername, "");
        loginPage.getErrorMessage();
        Assert.assertEquals(loginPage.getErrorMessage(), Constant.errormessage, "Đăng nhập thất bại");
    }
}