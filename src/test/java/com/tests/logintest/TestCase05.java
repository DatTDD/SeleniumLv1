package com.tests.logintest;

import com.railway.common.Common;
import com.railway.constant.Constant;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase05 extends TestBase {

    @Test
    public void SystemShowsMessageWhenUserEntersWrongPasswordSeveralTimes() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constant.PageTitle.LOGIN_PAGE_TITLE);

        for (int i = 1; i < 5; i++){
            Common common = new Common();
            common.scrollToBottom();
            loginPage.login(Constant.Login.VALID_USERNAME,Constant.Login.INVALID_PASSWORD);
        }

        Assert.assertEquals(loginPage.loginErrorMessage(),Constant.Login.SEVERAL_TIMES_LOGIN_FAIL_MESSAGE);
    }
}