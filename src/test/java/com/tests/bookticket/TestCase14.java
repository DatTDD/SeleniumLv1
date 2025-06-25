package com.tests.bookticket;

import com.railway.common.Common;
import com.railway.constant.Constant;
import com.railway.pages.BookTicketPage;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.annotations.Test;

public class TestCase14 extends TestBase {

    @Test
    public void UserCanBook1TicketAtATime() {
        LoginPage loginPage = new LoginPage();

        loginPage.gotoLoginTab();
        loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

        BookTicketPage bookTicketPage = new BookTicketPage();
        Common common = new Common();
        common.scrollToBottom();
        bookTicketPage.gotoBookTicketTab();

        bookTicketPage.bookTicket("7/4/2025", "Đà Nẵng","Huế","Soft bed with air conditioner", "1" );
    }
}
