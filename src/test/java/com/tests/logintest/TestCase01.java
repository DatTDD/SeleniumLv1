package com.tests.logintest;

import com.fasterxml.jackson.databind.JsonNode;
import com.railway.constant.Constants;
import com.railway.dataobject.Account;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.HomePage;
import com.railway.pages.LoginPage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import com.tests.ultilities.JsonDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase01 extends TestBase {

    @Test
    public void UserCanLogIntoRailwayWithValidUsernameAndPassword() {
        LogUtils.info("=== START TEST: UserCanLogIntoRailwayWithValidUsernameAndPassword ===");

        LoginPage loginPage = new LoginPage();

        LogUtils.info("1. Clicking on Login tab");
        ExtentTestManager.getTest().info("1. Clicking on Login tab");
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);

        ExtentTestManager.getTest().info("2. Attempting login with valid account");
        Account account = Account.VALID_ACCOUNT;
        loginPage.login(account);


        ExtentTestManager.getTest().info("Checking welcome message");
        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.welcomeText(), Constants.HomePage.WELCOME_MESSAGE);

        LogUtils.info("Checking welcome message: " + Constants.HomePage.WELCOME_MESSAGE);
        LogUtils.info("Assertion passed: Welcome message matches expected.");
        ExtentTestManager.getTest().info("Expected: " + homePage.welcomeText());
        ExtentTestManager.getTest().info("Actual: " + Constants.HomePage.WELCOME_MESSAGE);

        LogUtils.info("=== END TEST: UserCanLogIntoRailwayWithValidUsernameAndPassword ===");
    }

}
