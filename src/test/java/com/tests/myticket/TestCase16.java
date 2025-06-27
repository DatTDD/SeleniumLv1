package com.tests.myticket;

import com.railway.constant.Constants;
import com.railway.pages.LoginPage;
import com.railway.pages.MyTicketPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase16 extends TestBase {

    @Test
    public void UserCanCancelATicket() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        loginPage.login(Constants.Account.VALID_USERNAME, Constants.Account.VALID_PASSWORD);

        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.clickOnTab(Constants.MenuBar.MY_TICKET);
        myTicketPage.useFilterToSearchTicket(Constants.BookTicket.DEPART_FROM, Constants.BookTicket.ARRIVER_AT, Constants.BookTicket.DEPART_DATE, "New");
        int numberOfTicketRowsBeforeDelete = myTicketPage.getNumberOfTicketRows();
        myTicketPage.cancelTicket(Constants.BookTicket.DEPART_FROM, Constants.BookTicket.ARRIVER_AT, Constants.BookTicket.SEAT_TYPE, Constants.BookTicket.DEPART_DATE, Constants.BookTicket.TICKET_AMOUNT);
        myTicketPage.acceptCancelAlert();
        int numberOfTicketRowsAfterDelete = myTicketPage.getNumberOfTicketRows();

        Assert.assertEquals(numberOfTicketRowsAfterDelete, numberOfTicketRowsBeforeDelete - 1);


    }
}
