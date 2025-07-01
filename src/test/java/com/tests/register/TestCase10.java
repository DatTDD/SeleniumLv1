package com.tests.register;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.RegisterPage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase10 extends TestBase {

    @Test
    public void UserCannotCreateAccountWithConfirmPasswordIsNotTheSameAsPassword() {
        LogUtils.info("=== START TEST: UserCannotCreateAccountWithConfirmPasswordIsNotTheSameAsPassword ===");

        RegisterPage registerPage = new RegisterPage();
        registerPage.clickOnTab(Constants.MenuBar.REGISTER);
        LogUtils.info("1. Clicking on Register tab");
        ExtentTestManager.getTest().info("1. Clicking on Register tab");

        Common common = new Common();
        common.scrollToBottom();
        registerPage.registerAccount(Constants.Account.REGISTER_EMAIL, Constants.Account.REGISTER_PASSWORD, Constants.Account.REGISTER_EMAIL, Constants.Account.REGISTER_PID);
        LogUtils.info("2. Registering new account with confirm password is not the same as password");
        ExtentTestManager.getTest().info("2. Registering new account with confirm password is not the same as password");

        Assert.assertEquals(registerPage.getErrorMessage(), Constants.Register.REGISTER_MESSAGE_ERROR,"");
        LogUtils.info("Verifying error message is displayed");
        ExtentTestManager.getTest().info("Verifying error message is displayed");
        ExtentTestManager.getTest().info("Expected: " + Constants.Register.REGISTER_MESSAGE_ERROR);
        ExtentTestManager.getTest().info("Actual: " + registerPage.getErrorMessage());

        LogUtils.info("=== END TEST: User_can_create_new_account ===");

    }
}
