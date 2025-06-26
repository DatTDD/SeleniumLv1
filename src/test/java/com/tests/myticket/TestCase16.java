package com.tests.myticket;

import com.railway.constant.Constant;
import com.railway.pages.LoginPage;
import com.railway.pages.MyTicketPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase16 extends TestBase {

    @Test
    public void UserCanCancelATicket() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constant.PageTitle.LOGIN_PAGE_TITLE);
        loginPage.login(Constant.Login.VALID_USERNAME, Constant.Login.VALID_PASSWORD);

        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.goToMyTicketTab();
        myTicketPage.useFilterToSearchTicket(Constant.BookTicket.DEPART_FROM, Constant.BookTicket.ARRIVER_AT, Constant.BookTicket.DEPART_DATE, "New");
        int numberOfTicketRowsBeforeDelete = myTicketPage.getNumberOfTicketRows();
        myTicketPage.cancelTicket(Constant.BookTicket.DEPART_FROM, Constant.BookTicket.ARRIVER_AT, Constant.BookTicket.SEAT_TYPE, Constant.BookTicket.DEPART_DATE, Constant.BookTicket.TICKET_AMOUNT);
        myTicketPage.acceptCancelAlert();
        int numberOfTicketRowsAfterDelete = myTicketPage.getNumberOfTicketRows();

        Assert.assertEquals(numberOfTicketRowsAfterDelete, numberOfTicketRowsBeforeDelete - 1);


    }
}
