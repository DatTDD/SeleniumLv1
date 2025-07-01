package com.tests.bookticket;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.pages.BookTicketPage;
import com.railway.pages.LoginPage;
import com.railway.pages.TimetablePage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase15 extends TestBase {

    @Test
    public void UserCanOpenBookTicketPageByClickingOnBookTicketLinkInTrainTimetablePage() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        loginPage.login(Constants.Account.VALID_USERNAME, Constants.Account.VALID_PASSWORD);

        TimetablePage timetablePage = new TimetablePage();
        timetablePage.clickOnTab(Constants.MenuBar.TIMETABLE);
        Common common = new Common();
        common.scrollToBottom();
        timetablePage.clickBookTicketButton("Huế", "Sài Gòn");

        BookTicketPage bookTicketPage = new BookTicketPage();
        common.scrollToBottom();

        Assert.assertEquals("Huế", bookTicketPage.getSelectedDepartFromValue());
        Assert.assertEquals("Sài Gòn", bookTicketPage.getSelectedArriveAtValue());
    }
}
