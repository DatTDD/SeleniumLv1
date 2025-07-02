package com.tests.logintest;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.dataobject.Account;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.LoginPage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase08 extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(TestCase08.class);

    @Test
    public void UserCannotLoginWithAnAccountHasNotBeenActivated() {
        LogUtils.info("=== START TEST: AdditionalPagesDisplayOnceUserLoggedIn ===");

        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        LogUtils.info("1. Clicking on Login tab");
        ExtentTestManager.getTest().info("1. Clicking on Login tab");

        Account account = Account.ACCOUNT_WITHOUT_ACCTIVE;
        loginPage.login(account);
        LogUtils.info("2. Login with account without acctive");
        ExtentTestManager.getTest().info("2. Login with account without acctive");

        Assert.assertEquals(loginPage.loginErrorMessage(), Constants.Message.LOGIN_WITH_INVALID_ALL_ERROR_MESSAGE, "Dang nhap that bai");
        LogUtils.info("Verifying error message is displayed");
        ExtentTestManager.getTest().info("Verifying error message is displayed");
        Common common = new Common();
        common.logExpectedAndActual("Error Message:", Constants.Message.LOGIN_WITH_INVALID_ALL_ERROR_MESSAGE, loginPage.loginErrorMessage());

        LogUtils.info("=== END TEST: AdditionalPagesDisplayOnceUserLoggedIn ===");
    }
}
