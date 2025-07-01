package com.tests.resetpassword;

import com.railway.constant.Constants;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.LoginPage;
import com.railway.utility.LogUtils;
import com.railway.utility.MailBox;
import com.tests.base.TestBase;
import org.testng.annotations.Test;
import com.railway.pages.ForgotPasswordPage;
import com.railway.pages.HomePage;
import com.railway.pages.ResetPasswordPage;
import org.testng.Assert;

public class TestCase13 extends TestBase {
    @Test
    public void errorsDisplayIfPasswordAndConfirmPasswordDontMatchWhenResettingPassword() {
        LogUtils.info("=== START TEST: errorsDisplayIfPasswordAndConfirmPasswordDontMatchWhenResettingPassword ===");

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

        homePage.clickOnTab(Constants.MenuBar.LOGIN);
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


        resetPasswordPage.resetPassword(Constants.Account.VALID_PASSWORD, Constants.Account.VALID_PASSWORD + "0", true);
        LogUtils.info("6. Reset password with password and confirm password don't match");
        ExtentTestManager.getTest().info("6. Reset password with password and confirm password don't match");

        Assert.assertEquals(resetPasswordPage.getErrorMessage(), Constants.ResetPasswordMessage.ERROR_MESSAGE_COULD_NOT_RESET_PASSWORD);
        Assert.assertEquals(resetPasswordPage.getInlineErrorMessageConfirmPasswordField(), Constants.ResetPasswordMessage.INLINE_ERROR_MESSAGE_CONFIRM_PASSWORD);
        LogUtils.info("Verify error messages are displayed");
        ExtentTestManager.getTest().info("Verify error messages are displayed");
        ExtentTestManager.getTest().info("Expected OnTop Error Message: " + Constants.ResetPasswordMessage.ERROR_MESSAGE_COULD_NOT_RESET_PASSWORD);
        ExtentTestManager.getTest().info("Actual OnTop Error Message: " + resetPasswordPage.getErrorMessage());
        ExtentTestManager.getTest().info("Expected Inline Confirm Password Error Message: " + Constants.ResetPasswordMessage.INLINE_ERROR_MESSAGE_CONFIRM_PASSWORD);
        ExtentTestManager.getTest().info("Actual Inline Confirm Password Error Message: " + resetPasswordPage.getInlineErrorMessageConfirmPasswordField());

        LogUtils.info("=== END TEST: errorsDisplayIfPasswordAndConfirmPasswordDontMatchWhenResettingPassword ===");

    }
}