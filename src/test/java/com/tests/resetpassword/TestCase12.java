package com.tests.resetpassword;

import com.railway.constant.Constants;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.*;
import com.railway.utility.LogUtils;
import com.railway.utility.MailBox;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase12 extends TestBase {

    @Test
    public void errorsDisplayWhenPasswordResetTokenIsBlank() {
        LogUtils.info("=== START TEST: errorsDisplayWhenPasswordResetTokenIsBlank ===");

        LoginPage loginPage = new LoginPage();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        loginPage.gotoForgotPasswordPage();
        LogUtils.info("1. Go to Forgot Password page");
        ExtentTestManager.getTest().info("1. Go to Forgot Password page");

        forgotPasswordPage.sendInstructions(Constants.Account.RESET_PASSWORD_ACCOUNT);
        LogUtils.info("2. Enter Email want to reset password");
        ExtentTestManager.getTest().info("2. Enter Email want to reset password");

        forgotPasswordPage.goToMailBox();
        LogUtils.info("3. Go to MailBox");
        ExtentTestManager.getTest().info("3. Go to MailBox");

        MailBox.clickResetPasswordLink();
        LogUtils.info("4. Click on reset password link");
        ExtentTestManager.getTest().info("4. Click on reset password link");

        resetPasswordPage.navigateToResetPasswordTab();
        LogUtils.info("5. Navigate to Reset Password tab");
        ExtentTestManager.getTest().info("5. Navigate to Reset Password tab");


        resetPasswordPage.resetPassword(Constants.Account.VALID_PASSWORD, Constants.Account.VALID_PASSWORD, false);
        LogUtils.info("6. Reset password with blank reset token");
        ExtentTestManager.getTest().info("6. Reset password with blank reset token");


        Assert.assertTrue(resetPasswordPage.isOnTopErrorMessageDisplayed(), "Error message does not exist");
        Assert.assertEquals(resetPasswordPage.getErrorMessage(), Constants.ResetPasswordMessage.ERROR_MESSAGE_INCORRECT_RESET_TOKEN);
        Assert.assertEquals(resetPasswordPage.getInlineErrorMessageInvalidResetTokenField(), Constants.ResetPasswordMessage.INLINE_ERROR_MESSAGE_INVALID_RESET_TOKEN);
        LogUtils.info("Verify error messages are displayed");
        ExtentTestManager.getTest().info("Verify error messages are displayed");
        ExtentTestManager.getTest().info("Expected Top Error Message: " + Constants.ResetPasswordMessage.ERROR_MESSAGE_INCORRECT_RESET_TOKEN);
        ExtentTestManager.getTest().info("Actual Top Error Message: " + resetPasswordPage.getErrorMessage());
        ExtentTestManager.getTest().info("Expected Inline Reset Token Error Message: " + Constants.ResetPasswordMessage.INLINE_ERROR_MESSAGE_INVALID_RESET_TOKEN);
        ExtentTestManager.getTest().info("Actual Inline Reset Token Error Message: " + resetPasswordPage.getInlineErrorMessageInvalidResetTokenField());

        LogUtils.info("=== END TEST: errorsDisplayWhenPasswordResetTokenIsBlank ===");

    }
}
