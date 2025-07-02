package com.tests.bookticket;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestCase14 extends TestBase {

    @Test
    public void UserCanBook1TicketAtATime() {
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
        bookTicketPage.bookTicket(Ticket.VALID_TICKET);
        //bookTicketPage.bookTicket(Constants.BookTicket.DEPART_DATE, Constants.BookTicket.DEPART_FROM, Constants.BookTicket.ARRIVER_AT, Constants.BookTicket.SEAT_TYPE, Constants.BookTicket.TICKET_AMOUNT);

        LogUtils.info("4. Booking ticket with Depart Date: " + Constants.BookTicket.DEPART_DATE + ", Depart From: " + Constants.BookTicket.DEPART_FROM + ", Arrive At: " + Constants.BookTicket.ARRIVER_AT + ", Seat Type: " + Constants.BookTicket.SEAT_TYPE + ", Ticket Amount: " + Constants.BookTicket.TICKET_AMOUNT);
        ExtentTestManager.getTest().info("4. Booking ticket with Depart Date: " + Constants.BookTicket.DEPART_DATE + ", Depart From: " + Constants.BookTicket.DEPART_FROM + ", Arrive At: " + Constants.BookTicket.ARRIVER_AT + ", Seat Type: " + Constants.BookTicket.SEAT_TYPE + ", Ticket Amount: " + Constants.BookTicket.TICKET_AMOUNT);


        Assert.assertEquals(bookTicketPage.getSuccessfulBookingMessage(), Constants.BookTicket.SUCCESSFUL_BOOKING_MESSAGE);
        Assert.assertEquals(bookTicketPage.getDepartDateInforBookedTicket(), Constants.BookTicket.DEPART_DATE);
        Assert.assertEquals(bookTicketPage.getDepartFromInforBookedTicket(), Constants.BookTicket.DEPART_FROM);
        Assert.assertEquals(bookTicketPage.getArriverAtInforBookedTicket(), Constants.BookTicket.ARRIVER_AT);
        Assert.assertEquals(bookTicketPage.getSeatTypeInforBookedTicket(), Constants.BookTicket.SEAT_TYPE);
        Assert.assertEquals(bookTicketPage.ticketAmountInforBookedTicket(), Constants.BookTicket.TICKET_AMOUNT);

        LogUtils.info("Verifying successful booking message and ticket information");
        ExtentTestManager.getTest().info("Verifying successful booking message and ticket information");

        List<String> expected = Arrays.asList(
                Constants.BookTicket.DEPART_DATE,
                Constants.BookTicket.DEPART_FROM,
                Constants.BookTicket.ARRIVER_AT,
                Constants.BookTicket.SEAT_TYPE,
                Constants.BookTicket.TICKET_AMOUNT
        );

        List<String> actual = Arrays.asList(
                bookTicketPage.getDepartDateInforBookedTicket(),
                bookTicketPage.getDepartFromInforBookedTicket(),
                bookTicketPage.getArriverAtInforBookedTicket(),
                bookTicketPage.getSeatTypeInforBookedTicket(),
                bookTicketPage.ticketAmountInforBookedTicket()
        );
        common.logGroupedComparison(expected, actual);


        myTicketPage.clickOnTab(Constants.MenuBar.MY_TICKET);

        Assert.assertEquals(myTicketPage.getNumberOfTicketRows(), count + 1);
        LogUtils.info("Verifying number of ticket rows after booking");
        ExtentTestManager.getTest().info("Number of ticket rows before booking: " + count);
        ExtentTestManager.getTest().info("Number of ticket rows after booking: " + myTicketPage.getNumberOfTicketRows());

        LogUtils.info("=== END TEST: UserCanBook1TicketAtATime ===");
    }
}
