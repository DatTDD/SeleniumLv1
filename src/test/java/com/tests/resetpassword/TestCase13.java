package com.tests.resetpassword;

import com.railway.constant.Constants;
import com.railway.pages.LoginPage;
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
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

        homePage.clickOnTab(Constants.MenuBar.LOGIN);
        loginPage.gotoForgotPasswordPage();

        // Forgot password
        forgotPasswordPage.sendInstructions(Constants.Account.RESET_PASSWORD_ACCOUNT);
        forgotPasswordPage.goToMailBox();

        // Mailbox
        MailBox.clickResetPasswordLink();

        // Reset password
        resetPasswordPage.navigateToResetPasswordTab();

        resetPasswordPage.resetPassword(Constants.Account.VALID_PASSWORD, Constants.Account.VALID_PASSWORD + "0", true);

        Assert.assertEquals(resetPasswordPage.getErrorMessage(), Constants.ResetPasswordMessage.ERROR_MESSAGE_COULD_NOT_RESET_PASSWORD);
        Assert.assertEquals(resetPasswordPage.getInlineErrorMessageConfirmPasswordField(), Constants.ResetPasswordMessage.INLINE_ERROR_MESSAGE_CONFIRM_PASSWORD);
    }
}