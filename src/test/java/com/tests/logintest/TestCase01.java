package com.tests.logintest;

import com.railway.constant.Constants;
import com.railway.pages.HomePage;
import com.railway.pages.LoginPage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase01 extends TestBase {

    @Test
    public void UserCanLogIntoRailwayWithValidUsernameAndPassword() {
        LogUtils.info("=== START TEST: UserCanLogIntoRailwayWithValidUsernameAndPassword ===");

        LoginPage loginPage = new LoginPage();

        LogUtils.info("Navigating to Login tab...");
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        loginPage.login(Constants.Account.VALID_USERNAME, Constants.Account.VALID_PASSWORD);

        LogUtils.info("Checking welcome message: " + Constants.HomePage.WELCOME_MESSAGE);
        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.welcomeText(), Constants.HomePage.WELCOME_MESSAGE);
        LogUtils.info("Assertion passed: Welcome message matches expected.");

        LogUtils.info("=== END TEST: UserCanLogIntoRailwayWithValidUsernameAndPassword ===");

    }

}
