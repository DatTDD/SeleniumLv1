package com.tests.logintest;

import com.railway.constant.Constants;
import com.railway.pages.LoginPage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase02 extends TestBase {

    @Test (priority = 1)
    public void UserCannotLoginWithBlankUsernameTextbox()  {
        LogUtils.info("=== START TEST: UserCannotLoginWithBlankUsernameTextbox ===");
        LoginPage loginPage = new LoginPage();

        LogUtils.info("Clicking on Login tab");
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);

        LogUtils.info("Attempt to login with blank username and valid password");
        loginPage.login("", Constants.Account.VALID_PASSWORD);

        LogUtils.info("Verifying error message is shown for blank email");
        Assert.assertEquals(loginPage.loginErrorMessage(), Constants.Login.BLANK_EMAIL_OR_PASSWORD_ERROR_MESSAGE, "Đăng nhập thất bại");

        LogUtils.info("=== END TEST: UserCannotLoginWithBlankUsernameTextbox ===");
    }

}