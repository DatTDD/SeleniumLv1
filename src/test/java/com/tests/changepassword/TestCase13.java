package com.tests.changepassword;

import com.railway.constant.Constant;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.annotations.Test;

public class TestCase13 extends TestBase {

    @Test
    public void ErrorMessagesDisplayIfPasswordAndConfirmPasswordDoNotMatchWhenResettingPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constant.PageTitle.LOGIN_PAGE_TITLE);
        loginPage.gotoForgotPasswordPage();
        loginPage.emailAddressTextBox(Constant.Login.VALID_USERNAME);
        loginPage.sendInstructions();

    }
}
