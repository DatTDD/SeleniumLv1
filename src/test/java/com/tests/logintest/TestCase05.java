package com.tests.logintest;

import com.railway.constant.Constant;
import com.railway.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase05 {

    @Test
    public void SystemShowsMessageWhenUserEntersWrongPasswordSeveralTimes() {
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginTab();

        for (int i = 1; i < 5; i++){
            loginPage.login(Constant.Login.VALID_USERNAME,Constant.Login.INVALID_PASSWORD);
        }

        Assert.assertEquals(loginPage.loginErrorMessage(),Constant.Login.SEVERAL_TIMES_LOGIN_FAIL_MESSAGE,"");
    }
}
