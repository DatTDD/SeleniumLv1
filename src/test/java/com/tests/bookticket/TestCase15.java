package com.tests.bookticket;

import com.fasterxml.jackson.databind.JsonNode;
import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.dataobject.Account;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.BookTicketPage;
import com.railway.pages.LoginPage;
import com.railway.pages.TimetablePage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import com.tests.ultilities.JsonDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase15 extends TestBase {

    @Test(dataProvider = "JsonData", dataProviderClass = JsonDataProvider.class)
    public void UserCanOpenBookTicketPageByClickingOnBookTicketLinkInTrainTimetablePage(JsonNode data) {
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
        String departStation = data.get("departStation").asText();
        String arriveStation = data.get("arriveStation").asText();
        timetablePage.clickBookTicketButton(departStation, arriveStation);
        LogUtils.info("4. Clicking on Book Ticket button for Depart From: " + departStation + " and Arrive At: " + arriveStation);
        ExtentTestManager.getTest().info("4. Clicking on Book Ticket button for Depart From: " + departStation + " and Arrive At: " + arriveStation);

        BookTicketPage bookTicketPage = new BookTicketPage();
        common.scrollToBottom();


        Assert.assertEquals(departStation, bookTicketPage.getSelectedDepartFromValue());
        Assert.assertEquals(arriveStation, bookTicketPage.getSelectedArriveAtValue());
        LogUtils.info("Verifying Depart From and Arrive At values are pre-selected");
        ExtentTestManager.getTest().info("Verifying Depart From and Arrive At values are pre-selected");
        common.logExpectedAndActual("Depart From:", bookTicketPage.getSelectedDepartFromValue(), departStation);
        common.logExpectedAndActual("Arrive At:", bookTicketPage.getSelectedArriveAtValue(), arriveStation);

        LogUtils.info("=== END TEST: UserCanOpenBookTicketPageByClickingOnBookTicketLinkInTrainTimetablePage ===");
    }
}
