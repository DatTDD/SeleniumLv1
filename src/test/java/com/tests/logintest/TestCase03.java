package com.tests.logintest;

import com.railway.constant.Constants;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase03 extends TestBase {

    @Test
    public void UserCannotLogIntoRailwayWithInvalidPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        loginPage.login(Constants.Account.VALID_USERNAME, Constants.Account.INVALID_PASSWORD);
        Assert.assertEquals(loginPage.loginErrorMessage(), Constants.Login.BLANK_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
    }
}