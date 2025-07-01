package com.tests.myticket;

import com.railway.constant.Constants;
import com.railway.dataobject.Account;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.LoginPage;
import com.railway.pages.MyTicketPage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase16 extends TestBase {

    @Test
    public void UserCanCancelATicket() {
        LogUtils.info("=== START TEST: UserCanCancelATicket ===");

        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        LogUtils.info("Clicking on Login tab");
        ExtentTestManager.getTest().info("Clicking on Login tab");

        Account account = Account.VALID_ACCOUNT;
        loginPage.login(account);
        LogUtils.info("1. Attempting login with valid account");
        ExtentTestManager.getTest().info("1. Attempting login with valid account");

        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.clickOnTab(Constants.MenuBar.MY_TICKET);
        myTicketPage.useFilterToSearchTicket(Constants.BookTicket.DEPART_FROM, Constants.BookTicket.ARRIVER_AT, Constants.BookTicket.DEPART_DATE, "New");
        LogUtils.info("2. Filtering tickets with Depart From: " + Constants.BookTicket.DEPART_FROM + ", Arrive At: " + Constants.BookTicket.ARRIVER_AT + ", Depart Date: " + Constants.BookTicket.DEPART_DATE + ", Status: New");
        ExtentTestManager.getTest().info("2. Filtering tickets with Depart From: " + Constants.BookTicket.DEPART_FROM + ", Arrive At: " + Constants.BookTicket.ARRIVER_AT + ", Depart Date: " + Constants.BookTicket.DEPART_DATE + ", Status: New");

        int numberOfTicketRowsBeforeDelete = myTicketPage.getNumberOfTicketRows();
        myTicketPage.cancelTicket(Constants.BookTicket.DEPART_FROM, Constants.BookTicket.ARRIVER_AT, Constants.BookTicket.SEAT_TYPE, Constants.BookTicket.DEPART_DATE, Constants.BookTicket.TICKET_AMOUNT);
        LogUtils.info("3. Cancelling ticket with Depart From: " + Constants.BookTicket.DEPART_FROM + ", Arrive At: " + Constants.BookTicket.ARRIVER_AT + ", Seat Type: " + Constants.BookTicket.SEAT_TYPE + ", Depart Date: " + Constants.BookTicket.DEPART_DATE + ", Ticket Amount: " + Constants.BookTicket.TICKET_AMOUNT);
        ExtentTestManager.getTest().info("3. Cancelling ticket with Depart From: " + Constants.BookTicket.DEPART_FROM + ", Arrive At: " + Constants.BookTicket.ARRIVER_AT + ", Seat Type: " + Constants.BookTicket.SEAT_TYPE + ", Depart Date: " + Constants.BookTicket.DEPART_DATE + ", Ticket Amount: " + Constants.BookTicket.TICKET_AMOUNT);


        myTicketPage.acceptCancelAlert();
        int numberOfTicketRowsAfterDelete = myTicketPage.getNumberOfTicketRows();
        LogUtils.info("Verifying number of ticket rows after cancellation");
        ExtentTestManager.getTest().info("Number of ticket rows before cancellation: " + numberOfTicketRowsBeforeDelete);
        ExtentTestManager.getTest().info("Number of ticket rows after cancellation: " + numberOfTicketRowsAfterDelete);


        Assert.assertEquals(numberOfTicketRowsAfterDelete, numberOfTicketRowsBeforeDelete - 1);

        LogUtils.info("Expected Number of ticket rows after cancellation: " + (numberOfTicketRowsBeforeDelete - 1));
        ExtentTestManager.getTest().info("Actual Number of ticket rows after cancellation: " + numberOfTicketRowsAfterDelete);


        LogUtils.info("=== END TEST: UserCanCancelATicket ===");
    }
}
