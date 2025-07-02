package com.tests.logintest;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.BookTicketPage;
import com.railway.pages.LoginPage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase04 extends TestBase {

    @Test
    public void LoginPageDisplaysWhenUserClicksOnBookTicketTabWithoutLogin() {
        LogUtils.info("=== START TEST: LoginPageDisplaysWhenUserClicksOnBookTicketTabWithoutLogin ===");

        LoginPage loginPage = new LoginPage();

        BookTicketPage bookticketPage = new BookTicketPage();
        bookticketPage.clickOnTab(Constants.MenuBar.BOOK_TICKET);
        LogUtils.info("1. Clicking on Book ticket tab");
        ExtentTestManager.getTest().info("1. Clicking on Book ticket tab");

        Assert.assertEquals(loginPage.loginTitle(), Constants.PageTitle.LOGIN_PAGE_TITLE);
        LogUtils.info("Verifying Login page is displayed");
        ExtentTestManager.getTest().info("Verifying Login page is displayed");
        Common common = new Common();
        common.logExpectedAndActual("Login Page Title:", Constants.PageTitle.LOGIN_PAGE_TITLE, loginPage.loginTitle());

        LogUtils.info("=== END TEST: LoginPageDisplaysWhenUserClicksOnBookTicketTabWithoutLogin ===");

    }
}
