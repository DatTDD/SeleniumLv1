package com.tests.resetpassword;

import com.railway.constant.Constants;
import com.railway.pages.*;
import com.railway.utility.MailBox;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase12 extends TestBase {

    @Test
    public void errorsDisplayWhenPasswordResetTokenIsBlankUseUI() {
        LoginPage loginPage = new LoginPage();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        loginPage.gotoForgotPasswordPage();

        forgotPasswordPage.sendInstructions(Constants.Account.RESET_PASSWORD_ACCOUNT);
        forgotPasswordPage.goToMailBox();

        MailBox.clickResetPasswordLink();

        resetPasswordPage.navigateToResetPasswordTab();

        resetPasswordPage.resetPassword(Constants.Account.VALID_PASSWORD, Constants.Account.VALID_PASSWORD, false);

        Assert.assertTrue(resetPasswordPage.isOnTopErrorMessageDisplayed(), "Error message does not exist");
        Assert.assertEquals(resetPasswordPage.getErrorMessage(), Constants.ResetPasswordMessage.ERROR_MESSAGE_INCORRECT_RESET_TOKEN);
        Assert.assertEquals(resetPasswordPage.getInlineErrorMessageInvalidResetTokenField(), Constants.ResetPasswordMessage.INLINE_ERROR_MESSAGE_INVALID_RESET_TOKEN);
    }
}
