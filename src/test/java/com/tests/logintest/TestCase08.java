package com.tests.logintest;

import com.railway.constant.Constant;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase08 extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(TestCase08.class);

    @Test
    public void UserCannotLoginWithAnAccountHasNotBeenActivated() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constant.PageTitle.LOGIN_PAGE_TITLE);
        loginPage.login(Constant.Register.REGISTER_EMAIL, Constant.Register.REGISTER_PASSWORD);

        Assert.assertEquals(loginPage.loginErrorMessage(),Constant.Login.INVALID_ALL_ERROR_MESSAGE, "Dang nhap that bai");
    }
}
