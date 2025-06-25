package com.tests.logintest;

import com.railway.constant.Constant;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase02 extends TestBase {

    @Test
    public void UserCannotLoginWithBlankUsernameTextbox() {
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginTab();
        loginPage.login("",Constant.VALID_PASSWORD);
        Assert.assertEquals(loginPage.loginErrorMessage(), Constant.BLANK_EMAIL_OR_PASSWORD_ERROR_MESSAGE, "Đăng nhập thất bại");
    }

//    @Test
//    public void testCase03() {
//        LoginPage loginPage = new LoginPage();
//        loginPage.login(Constant.validUsername, "");
//        Assert.assertEquals(loginPage.loginErrorMessage(), Constant.blankEmailOrPasswordErrorMessage, "Đăng nhập thất bại");
//    }

}
