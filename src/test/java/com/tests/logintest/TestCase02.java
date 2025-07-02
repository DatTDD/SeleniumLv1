package com.tests.logintest;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.dataobject.Account;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.LoginPage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase02 extends TestBase {

    @Test
    public void UserCannotLoginWithBlankUsernameTextbox() {
        LogUtils.info("=== START TEST: UserCannotLoginWithBlankUsernameTextbox ===");

        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        LogUtils.info("1. Clicking on Login tab");
        ExtentTestManager.getTest().info("1. Clicking on Login tab");

        Account account = Account.BLANK_USERNAME_ACCOUNT;
        loginPage.login(account);
        ExtentTestManager.getTest().info("2. Attempting login with blank username and valid password");

        Assert.assertEquals(loginPage.loginErrorMessage(), Constants.Message.LOGIN_WITH_BLANK_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
        LogUtils.info("Verifying error message is shown");
        ExtentTestManager.getTest().info("Verifying error message is displayed");
        Common common = new Common();
        common.logExpectedAndActual("Error Message:", Constants.Message.LOGIN_WITH_BLANK_EMAIL_OR_PASSWORD_ERROR_MESSAGE, loginPage.loginErrorMessage());

        LogUtils.info("=== END TEST: UserCannotLoginWithBlankUsernameTextbox ===");
    }
}