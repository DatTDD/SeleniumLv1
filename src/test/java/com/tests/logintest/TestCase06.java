package com.tests.logintest;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.dataobject.Account;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.*;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase06 extends TestBase {

    @Test
    public void AdditionalPagesDisplayOnceUserLoggedIn() {
        LogUtils.info("=== START TEST: AdditionalPagesDisplayOnceUserLoggedIn ===");

        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        LogUtils.info("1. Clicking on Login tab");
        ExtentTestManager.getTest().info("1. Clicking on Login tab");

        Account account = Account.VALID_ACCOUNT;
        loginPage.login(account);
        LogUtils.info("2. Login with a valid account");
        ExtentTestManager.getTest().info("2. Login with a valid account");

        HomePage homepage = new HomePage();
        Assert.assertTrue(homepage.isChangePasswordTabDisplayed());
        Assert.assertTrue(homepage.isMyTicketTabDisplayed());
        Assert.assertTrue(homepage.isLogOutTabDisplayed());
        LogUtils.info("Verifying additional pages are displayed");
        ExtentTestManager.getTest().info("Verifying additional pages are displayed");

        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.clickOnTab(Constants.MenuBar.MY_TICKET);
        Assert.assertEquals(myTicketPage.getMyTicketTitle(), Constants.PageTitle.MY_TICKET_TITLE);
        LogUtils.info("Verifying My Ticket page is displayed");
        ExtentTestManager.getTest().info("Verifying My Ticket page is displayed");
        Common common = new Common();
        common.logExpectedAndActual("My Ticket Page Title:", Constants.PageTitle.MY_TICKET_TITLE, myTicketPage.getMyTicketTitle());

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.clickOnTab(Constants.MenuBar.CHANGE_PASSWORD);
        Assert.assertEquals(changePasswordPage.changePasswordTitle(), Constants.PageTitle.CHANGE_PASSWORD_TITLE);
        LogUtils.info("Verifying Change Password page is displayed");
        ExtentTestManager.getTest().info("Verifying Change Password page is displayed");
        common.logExpectedAndActual("Change Password Page Title:", Constants.PageTitle.CHANGE_PASSWORD_TITLE, changePasswordPage.changePasswordTitle());

        LogUtils.info("=== END TEST: AdditionalPagesDisplayOnceUserLoggedIn ===");

    }

}
