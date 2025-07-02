package com.tests.register;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.RegisterPage;
import com.tests.ultilities.JsonDataProvider;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class TestCase07 extends TestBase {

    @Test(dataProvider = "RegisterData", dataProviderClass = JsonDataProvider.class)
    public void User_can_create_new_account(String testCaseId, Map<String, String> data) {
        LogUtils.info("=== START TEST: User_can_create_new_account ===");

        RegisterPage registerPage = new RegisterPage();
        registerPage.clickOnTab(Constants.MenuBar.REGISTER);
        LogUtils.info("1. Clicking on Register tab");
        ExtentTestManager.getTest().info("1. Clicking on Register tab");

        Common common = new Common();
        common.scrollToBottom();
        registerPage.registerAccount(common.createMail(10), Constants.Account.REGISTER_PASSWORD, Constants.Account.REGISTER_CF_PASSWORD, Constants.Account.REGISTER_PID);
        LogUtils.info("2. Registering new account with valid information");
        ExtentTestManager.getTest().info("2. Registering new account with valid information");

        Assert.assertEquals(registerPage.getSuccessMessage(), Constants.Message.REGISTER_THANKYOU_TEXT);
        LogUtils.info("Verifying success message is displayed");
        common.logExpectedAndActual("Verifying success message is displayed", Constants.Message.REGISTER_THANKYOU_TEXT, registerPage.getSuccessMessage());

        LogUtils.info("=== END TEST: User_can_create_new_account ===");
    }
}
