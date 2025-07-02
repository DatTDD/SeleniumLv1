package com.tests.changepassword;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.dataobject.Account;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.ChangePasswordPage;
import com.railway.pages.LoginPage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase09 extends TestBase {

    @Test
    public void UserCanChangePassword() {
        LogUtils.info("=== START TEST: UserCanChangePassword ===");

        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        LogUtils.info("1. Clicking on Login tab");
        ExtentTestManager.getTest().info("1. Clicking on Login tab");

        Account account = Account.VALID_ACCOUNT;
        loginPage.login(account);
        LogUtils.info("2. Attempting login with valid account");
        ExtentTestManager.getTest().info("2. Attempting login with valid account");


        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.clickOnTab(Constants.MenuBar.CHANGE_PASSWORD);
        LogUtils.info("3. Clicking on Change Password tab");
        ExtentTestManager.getTest().info("3. Clicking on Change Password tab");


        Common common = new Common();
        common.scrollToBottom();

        changePasswordPage.changePassword(Constants.Account.VALID_PASSWORD, Constants.Account.VALID_PASSWORD, Constants.Account.VALID_PASSWORD);
        LogUtils.info("4. Changing password: " + Constants.Account.VALID_PASSWORD + ", New Password: " + Constants.Account.VALID_PASSWORD + ", Confirm Password: " + Constants.Account.VALID_PASSWORD);
        ExtentTestManager.getTest().info("4. Changing password: " + Constants.Account.VALID_PASSWORD + ", New Password: " + Constants.Account.VALID_PASSWORD + ", Confirm Password: " + Constants.Account.VALID_PASSWORD);

        Assert.assertEquals(changePasswordPage.getChangePasswordMessageSuccess(), Constants.ChangePassword.CHANGE_PASSWORD_MESSAGE_SUCCESS);
        LogUtils.info("Verifying change password success message");
        ExtentTestManager.getTest().info("Expected: " + Constants.ChangePassword.CHANGE_PASSWORD_MESSAGE_SUCCESS);
        ExtentTestManager.getTest().info("Actual: " + changePasswordPage.getChangePasswordMessageSuccess());

        LogUtils.info("=== END TEST: UserCanChangePassword ===");
    }

}
