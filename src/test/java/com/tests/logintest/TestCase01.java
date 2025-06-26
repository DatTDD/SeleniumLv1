package com.tests.logintest;

import com.railway.constant.Constant;
import com.railway.pages.HomePage;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import com.railway.listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestCase01 extends TestBase {

    @Test
    public void UserCanLogIntoRailwayWithValidUsernameAndPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constant.PageTitle.LOGIN_PAGE_TITLE);
        loginPage.login(Constant.Login.VALID_USERNAME,Constant.Login.VALID_PASSWORD);

        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.welcomeText(), Constant.WELCOME_MESSAGE);
    }

}
