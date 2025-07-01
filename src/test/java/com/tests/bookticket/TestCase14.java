package com.tests.bookticket;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.pages.BookTicketPage;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase14 extends TestBase {

    @Test
    public void UserCanBook1TicketAtATime() {
        LoginPage loginPage = new LoginPage();

//        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        loginPage.login(Constants.Account.VALID_USERNAME, Constants.Account.VALID_PASSWORD);

        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.clickOnTab(Constants.MenuBar.BOOK_TICKET);

        Common common = new Common();
        common.scrollToBottom();
        bookTicketPage.bookTicket(Constants.BookTicket.DEPART_DATE, Constants.BookTicket.DEPART_FROM, Constants.BookTicket.ARRIVER_AT, Constants.BookTicket.SEAT_TYPE, Constants.BookTicket.TICKET_AMOUNT);

        Assert.assertEquals(bookTicketPage.getSuccessfulBookingMessage(), Constants.BookTicket.SUCCESSFUL_BOOKING_MESSAGE);
        Assert.assertEquals(bookTicketPage.getDepartDateInforBookedTicket(), Constants.BookTicket.DEPART_DATE);
        Assert.assertEquals(bookTicketPage.getDepartFromInforBookedTicket(), Constants.BookTicket.DEPART_FROM);
        Assert.assertEquals(bookTicketPage.getArriverAtInforBookedTicket(), Constants.BookTicket.ARRIVER_AT);
        Assert.assertEquals(bookTicketPage.getSeatTypeInforBookedTicket(), Constants.BookTicket.SEAT_TYPE);
        Assert.assertEquals(bookTicketPage.ticketAmountInforBookedTicket(), Constants.BookTicket.TICKET_AMOUNT);
    }
}
