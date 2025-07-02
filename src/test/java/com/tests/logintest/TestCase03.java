package com.tests.logintest;

import com.railway.constant.Constants;
import com.railway.dataobject.Account;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.LoginPage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase03 extends TestBase {

    @Test
    public void UserCannotLogIntoRailwayWithInvalidPassword() {
        LogUtils.info("=== START TEST: UserCannotLogIntoRailwayWithInvalidPassword ===");

        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        LogUtils.info("1. Clicking on Login tab");
        ExtentTestManager.getTest().info("1. Clicking on Login tab");

        Account account = Account.INVALID_PASSWORD_ACCOUNT;
        loginPage.login(account);
        LogUtils.info("2. Attempting to login with valid username and INVALID password...");
        ExtentTestManager.getTest().info("2. Attempting login with invalid password");

        Assert.assertEquals(loginPage.loginErrorMessage(), Constants.Login.BLANK_EMAIL_OR_PASSWORD_ERROR_MESSAGE);

        LogUtils.info("Verifying error message is displayed for invalid password...");
        ExtentTestManager.getTest().info("Verifying error message is displayed");
        ExtentTestManager.getTest().info("Expected: " + Constants.Login.BLANK_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
        ExtentTestManager.getTest().info("Actual: " + loginPage.loginErrorMessage());

        LogUtils.info("=== END TEST: UserCannotLogIntoRailwayWithInvalidPassword ===");
    }
}