package com.tests.register;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.RegisterPage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase11 extends TestBase {

    @Test
    public void UserCannotCreateAccountWhilePasswordAndPIDFieldsAreEmpty() {
        LogUtils.info("=== START TEST: UserCannotCreateAccountWhilePasswordAndPIDFieldsAreEmpty ===");

        RegisterPage registerPage = new RegisterPage();
        registerPage.clickOnTab(Constants.MenuBar.REGISTER);
        LogUtils.info("1. Clicking on Register tab");
        ExtentTestManager.getTest().info("1. Clicking on Register tab");

        Common common = new Common();
        common.scrollToBottom();
        registerPage.registerAccount(Constants.Account.REGISTER_EMAIL, "","","");
        LogUtils.info("2. Registering new account with empty password and PID");
        ExtentTestManager.getTest().info("2. Registering new account with empty password and PID");

        Assert.assertEquals(registerPage.getInvalidPasswordErrorMessage(), Constants.Message.REGISTER_INVALID_PASSWORD_ERROR_MESSAGE);
        Assert.assertEquals(registerPage.getPidInvalidErrorMessage(), Constants.Message.REGISTER_INVALID_ID_ERROR_MESSAGE);

        LogUtils.info("Verifying error messages are displayed for empty password and PID");
        ExtentTestManager.getTest().info("Verifying error messages are displayed");
        common.logExpectedAndActual("Password Error:", Constants.Message.REGISTER_INVALID_PASSWORD_ERROR_MESSAGE, registerPage.getInvalidPasswordErrorMessage());
        common.logExpectedAndActual("PID Error:", Constants.Message.REGISTER_INVALID_ID_ERROR_MESSAGE, registerPage.getPidInvalidErrorMessage());

        LogUtils.info("=== END TEST: UserCannotCreateAccountWhilePasswordAndPIDFieldsAreEmpty ===");

    }
}
