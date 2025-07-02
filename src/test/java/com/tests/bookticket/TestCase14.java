package com.tests.bookticket;

import com.fasterxml.jackson.databind.JsonNode;
import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.dataobject.Account;
import com.railway.dataobject.Ticket;
import com.railway.extentreport.ExtentTestManager;
import com.railway.pages.BookTicketPage;
import com.railway.pages.LoginPage;
import com.railway.pages.MyTicketPage;
import com.railway.utility.LogUtils;
import com.tests.base.TestBase;
import com.tests.ultilities.JsonDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class TestCase14 extends TestBase {

  @Test(dataProvider = "JsonData", dataProviderClass = JsonDataProvider.class)
  public void UserCanBook1TicketAtATime(JsonNode data) {
    LogUtils.info("=== START TEST: UserCanBook1TicketAtATime ===");

    LoginPage loginPage = new LoginPage();
    loginPage.clickOnTab(Constants.MenuBar.LOGIN);
    LogUtils.info("1. Clicking on Login tab");
    ExtentTestManager.getTest().info("1. Clicking on Login tab");

    Account account = Account.VALID_ACCOUNT;
    loginPage.login(account);
    LogUtils.info("2. Attempting login with valid account");
    ExtentTestManager.getTest().info("2. Attempting login with valid account");

    MyTicketPage myTicketPage = new MyTicketPage();
    myTicketPage.clickOnTab(Constants.MenuBar.MY_TICKET);
    int count = myTicketPage.getNumberOfTicketRows();


    BookTicketPage bookTicketPage = new BookTicketPage();
    bookTicketPage.clickOnTab(Constants.MenuBar.BOOK_TICKET);
    LogUtils.info("3. Clicking on Book Ticket tab");
    ExtentTestManager.getTest().info("3. Clicking on Book Ticket tab");

    Common common = new Common();
    common.scrollToBottom();

    String departStation = data.get("departStation").asText();
    String arriveStation = data.get("arriveStation").asText();
    int days = data.get("days").asInt();
    String seatType = data.get("seatType").asText();
    String ticketAmount = String.valueOf(data.get("amount").asInt());

    String departDate = LocalDate.now().plusDays(days + 3).format(DateTimeFormatter.ofPattern("M/d/yyyy"));

    Ticket ticket = new Ticket(departDate, departStation, arriveStation, seatType, ticketAmount);

    BookTicketPage bookTicket = new BookTicketPage();
    bookTicket.bookTicket(ticket);

    List<String> TicketInfo = Arrays.asList(departDate, departStation, arriveStation, seatType, ticketAmount);
    LogUtils.info("4. Booking ticket with details: " + TicketInfo);
    ExtentTestManager.getTest().info("4. Booking ticket with details: " + TicketInfo);


    Assert.assertEquals(bookTicketPage.getSuccessfulBookingMessage(), Constants.Message.SUCCESSFUL_BOOKING_MESSAGE);
    Assert.assertEquals(bookTicket.getTicketInfo(ticket), 1);


    LogUtils.info("Verifying successful booking message and ticket information");
    ExtentTestManager.getTest().info("Verifying successful booking message and ticket information");

    List<String> actual = Arrays.asList(departDate, departStation, arriveStation, seatType, ticketAmount);
    ExtentTestManager.getTest().info("Actual ticket info: " + actual);

    myTicketPage.clickOnTab(Constants.MenuBar.MY_TICKET);

    Assert.assertEquals(myTicketPage.getNumberOfTicketRows(), count + 1);
    LogUtils.info("Verifying number of ticket rows after booking");
    ExtentTestManager.getTest().info("Number of ticket rows before booking: " + count);
    ExtentTestManager.getTest().info("Number of ticket rows after booking: " + myTicketPage.getNumberOfTicketRows());

    LogUtils.info("=== END TEST: UserCanBook1TicketAtATime ===");
  }
}