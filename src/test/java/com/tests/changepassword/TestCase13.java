package com.tests.changepassword;

import com.railway.constant.Constant;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.annotations.Test;

public class TestCase13 extends TestBase {

    @Test
    public void ErrorMessagesDisplayIfPasswordAndConfirmPasswordDoNotMatchWhenResettingPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginTab();
        loginPage.gotoForgotPasswordPage();
        loginPage.emailAddressTextBox(Constant.VALID_USERNAME);
        loginPage.sendInstructions();
    }
}
