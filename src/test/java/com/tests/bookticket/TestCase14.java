package com.tests.bookticket;

import com.railway.common.Common;
import com.railway.constant.Constant;
import com.railway.pages.BookTicketPage;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase14 extends TestBase {

    @Test
    public void UserCanBook1TicketAtATime() {
        LoginPage loginPage = new LoginPage();

        loginPage.clickOnTab(Constant.PageTitle.LOGIN_PAGE_TITLE);
        loginPage.login(Constant.Login.VALID_USERNAME, Constant.Login.VALID_PASSWORD);

        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.goToBookTicketTab();

        Common common = new Common();
        common.scrollToBottom();
        bookTicketPage.bookTicket(Constant.BookTicket.DEPART_DATE, Constant.BookTicket.DEPART_FROM, Constant.BookTicket.ARRIVER_AT, Constant.BookTicket.SEAT_TYPE, Constant.BookTicket.TICKET_AMOUNT);

        Assert.assertEquals(bookTicketPage.successfulBookingMessage(), Constant.BookTicket.SUCCESSFUL_BOOKING_MESSAGE);
        Assert.assertEquals(bookTicketPage.departDateInforBookedTicket(),Constant.BookTicket.DEPART_DATE);
        Assert.assertEquals(bookTicketPage.departFromInforBookedTicket(),Constant.BookTicket.DEPART_FROM);
        Assert.assertEquals(bookTicketPage.arriverAtInforBookedTicket(),Constant.BookTicket.ARRIVER_AT);
        Assert.assertEquals(bookTicketPage.seatTypeInforBookedTicket(),Constant.BookTicket.SEAT_TYPE);
        Assert.assertEquals(bookTicketPage.ticketAmountInforBookedTicket(),Constant.BookTicket.TICKET_AMOUNT);
    }
}
