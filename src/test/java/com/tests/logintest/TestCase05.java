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

public class TestCase05 extends TestBase {

    @Test
    public void SystemShowsMessageWhenUserEntersWrongPasswordSeveralTimes() {
        LogUtils.info("=== START TEST: SystemShowsMessageWhenUserEntersWrongPasswordSeveralTimes ===");

        LoginPage loginPage = new LoginPage();
        Common common = new Common();
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        LogUtils.info("1. Clicking on Login tab");
        ExtentTestManager.getTest().info("1. Clicking on Login tab");

        for (int i = 1; i < 5; i++){

            common.scrollToBottom();
            Account account = Account.INVALID_PASSWORD_ACCOUNT;
            loginPage.login(account);
        }
        LogUtils.info("2. Login 4 times");
        ExtentTestManager.getTest().info("2. Login 4 times");

        Assert.assertEquals(loginPage.loginErrorMessage(), Constants.Message.SEVERAL_TIMES_LOGIN_FAIL_MESSAGE);
        LogUtils.info("Verifying error message is displayed");
        ExtentTestManager.getTest().info("Verifying error message is displayed");
        common.logExpectedAndActual("Error Message:", Constants.Message.SEVERAL_TIMES_LOGIN_FAIL_MESSAGE, loginPage.loginErrorMessage());

        LogUtils.info("=== END TEST: SystemShowsMessageWhenUserEntersWrongPasswordSeveralTimes ===");
    }
}