package com.tests.logintest;

import com.railway.constant.Constant;
import com.railway.listeners.TestListener;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TestCase03 extends TestBase {

    @Test
    public void UserCannotLogIntoRailwayWithInvalidPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constant.PageTitle.LOGIN_PAGE_TITLE);
        loginPage.login(Constant.Login.VALID_USERNAME, Constant.Login.INVALID_PASSWORD);
        Assert.assertEquals(loginPage.loginErrorMessage(), Constant.Login.BLANK_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
    }
}