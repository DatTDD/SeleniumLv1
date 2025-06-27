package com.tests.logintest;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase05 extends TestBase {

    @Test
    public void SystemShowsMessageWhenUserEntersWrongPasswordSeveralTimes() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);

        for (int i = 1; i < 5; i++){
            Common common = new Common();
            common.scrollToBottom();
            loginPage.login(Constants.Account.VALID_USERNAME, Constants.Account.INVALID_PASSWORD);
        }

        Assert.assertEquals(loginPage.loginErrorMessage(), Constants.Login.SEVERAL_TIMES_LOGIN_FAIL_MESSAGE);
    }
}