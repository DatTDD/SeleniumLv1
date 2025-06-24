package com.tests.changepassword;

import com.example.Constant.Constant;
import com.example.pages.ChangePasswordPage;
import com.example.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.annotations.Test;

public class TestCase13 extends TestBase {

    @Test
    public void TestCase13() {
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginTab();
        loginPage.gotoForgotPasswordPage();
        loginPage.emailAddressTextBox(Constant.validUsername);
        loginPage.sendInstructionsButton();
    }
}
