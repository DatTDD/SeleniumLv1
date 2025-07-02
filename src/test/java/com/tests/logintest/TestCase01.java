package com.tests.logintest;

import com.railway.constant.Constants;
import com.railway.dataobject.Account;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.HomePage;
import com.railway.pages.LoginPage;
import com.railway.utility.JsonDataProvider;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class TestCase01 extends TestBase {

//    @Test
//    public void UserCanLogIntoRailwayWithValidUsernameAndPassword() {
//        LogUtils.info("=== START TEST: UserCanLogIntoRailwayWithValidUsernameAndPassword ===");
//
//        LoginPage loginPage = new LoginPage();
//
//        LogUtils.info("Navigating to Login tab...");
//        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
//        loginPage.login(Constants.Account.VALID_USERNAME, Constants.Account.VALID_PASSWORD);
//
//        LogUtils.info("Checking welcome message: " + Constants.HomePage.WELCOME_MESSAGE);
//        HomePage homePage = new HomePage();
//        Assert.assertEquals(homePage.welcomeText(), Constants.HomePage.WELCOME_MESSAGE);
//        LogUtils.info("Assertion passed: Welcome message matches expected.");
//
//        LogUtils.info("=== END TEST: UserCanLogIntoRailwayWithValidUsernameAndPassword ===");
//
//    }

//    @Test(dataProvider = "LoginData", dataProviderClass = JsonDataProvider.class)
//    public void UserCanLogIntoRailwayWithValidUsernameAndPassword(String testCaseId, Map<String, String> data) {
//        LogUtils.info("=== START TEST: " + testCaseId + " ===");
//
//        LoginPage loginPage = new LoginPage();
//
//        LogUtils.info("Navigating to Login tab...");
//        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
//
//        String username = data.get("username");
//        String password = data.get("password");
//        LogUtils.info("Logging in with username: " + username + " and password: " + password);
//
//        loginPage.login(username, password);
//
//        LogUtils.info("Checking welcome message: " + Constants.HomePage.WELCOME_MESSAGE);
//        HomePage homePage = new HomePage();
//        Assert.assertEquals(homePage.welcomeText(), Constants.HomePage.WELCOME_MESSAGE);
//        LogUtils.info("Assertion passed: Welcome message matches expected.");
//
//        LogUtils.info("=== END TEST: " + testCaseId + " ===");
//    }

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
