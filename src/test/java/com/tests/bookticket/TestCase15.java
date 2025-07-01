package com.tests.bookticket;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.dataobject.Account;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.BookTicketPage;
import com.railway.pages.LoginPage;
import com.railway.pages.TimetablePage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase15 extends TestBase {

    @Test
    public void UserCanOpenBookTicketPageByClickingOnBookTicketLinkInTrainTimetablePage() {
        LogUtils.info("=== START TEST: UserCanOpenBookTicketPageByClickingOnBookTicketLinkInTrainTimetablePage ===");

        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        LogUtils.info("1. Clicking on Login tab");
        ExtentTestManager.getTest().info("1. Clicking on Login tab");

        Account account = Account.VALID_ACCOUNT;
        loginPage.login(account);
        LogUtils.info("2. Attempting login with valid account");
        ExtentTestManager.getTest().info("2. Attempting login with valid account");

        TimetablePage timetablePage = new TimetablePage();
        timetablePage.clickOnTab(Constants.MenuBar.TIMETABLE);
        LogUtils.info("3. Clicking on Timetable tab");
        ExtentTestManager.getTest().info("3. Clicking on Timetable tab");

        Common common = new Common();
        common.scrollToBottom();
        timetablePage.clickBookTicketButton(Constants.BookTicket.DEPART_FROM, Constants.BookTicket.ARRIVER_AT);
        LogUtils.info("4. Clicking on Book Ticket button for Depart From: " + Constants.BookTicket.DEPART_FROM + " and Arrive At: " + Constants.BookTicket.ARRIVER_AT);
        ExtentTestManager.getTest().info("4. Clicking on Book Ticket button for Depart From: " + Constants.BookTicket.DEPART_FROM + " and Arrive At: " + Constants.BookTicket.ARRIVER_AT);

        BookTicketPage bookTicketPage = new BookTicketPage();
        common.scrollToBottom();


        Assert.assertEquals(Constants.BookTicket.DEPART_FROM, bookTicketPage.getSelectedDepartFromValue());
        Assert.assertEquals(Constants.BookTicket.ARRIVER_AT, bookTicketPage.getSelectedArriveAtValue());
        LogUtils.info("Verifying Depart From and Arrive At values are pre-selected");
        ExtentTestManager.getTest().info("Verifying Depart From and Arrive At values are pre-selected");
        common.logExpectedAndActual("Depart From:", Constants.BookTicket.DEPART_FROM, bookTicketPage.getSelectedDepartFromValue());
        ExtentTestManager.getTest().info("Expected Arrive At: " + Constants.BookTicket.ARRIVER_AT);
        ExtentTestManager.getTest().info("Actual Arrive At: " + bookTicketPage.getSelectedArriveAtValue());

        LogUtils.info("=== END TEST: UserCanOpenBookTicketPageByClickingOnBookTicketLinkInTrainTimetablePage ===");
    }
}
