package com.tests.myticket;

import com.fasterxml.jackson.databind.JsonNode;
import com.railway.constant.Constants;
import com.railway.dataobject.Account;
import com.railway.dataobject.Ticket;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.LoginPage;
import com.railway.pages.MyTicketPage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import com.tests.ultilities.JsonDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestCase16 extends TestBase {

    @Test(dataProvider = "JsonData", dataProviderClass = JsonDataProvider.class)
    public void UserCanCancelATicket(JsonNode data) {
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


        String departStation = data.get("departStation").asText();
        String arriveStation = data.get("arriveStation").asText();
        int days = data.get("days").asInt();
        String seatType = data.get("seatType").asText();
        String ticketAmount = String.valueOf(data.get("amount").asInt());
        String departDate = LocalDate.now().plusDays(days + 3).format(DateTimeFormatter.ofPattern("M/d/yyyy"));

        Ticket ticket = new Ticket(departDate, departStation, arriveStation, seatType, ticketAmount);

        myTicketPage.useFilterToSearchTicket(departStation, arriveStation, departDate, "New");
        LogUtils.info("2. Filtering tickets with Depart From: " + departStation + ", Arrive At: " + arriveStation + ", Depart Date: " + departDate + ", Status: New");
        ExtentTestManager.getTest().info("2. Filtering tickets with Depart From: " + departStation + ", Arrive At: " + arriveStation + ", Depart Date: " + departDate + ", Status: New");

        int numberOfTicketRowsBeforeDelete = myTicketPage.getNumberOfTicketRows();
        myTicketPage.cancelTicket(ticket);
        LogUtils.info("3. Cancelling ticket with Depart From: " + departStation + ", Arrive At: " + arriveStation + ", Seat Type: " + seatType + ", Depart Date: " + departDate + ", Ticket Amount: " + ticketAmount);
        ExtentTestManager.getTest().info("3. Cancelling ticket with Depart From: " + departStation + ", Arrive At: " + arriveStation + ", Seat Type: " + seatType + ", Depart Date: " + departDate + ", Ticket Amount: " + ticketAmount);


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
