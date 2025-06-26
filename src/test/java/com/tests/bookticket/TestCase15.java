package com.tests.bookticket;

import com.railway.common.Common;
import com.railway.constant.Constant;
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
        loginPage.clickOnTab(Constant.PageTitle.LOGIN_PAGE_TITLE);
        loginPage.login(Constant.Login.VALID_USERNAME, Constant.Login.VALID_PASSWORD);

        TimetablePage timetablePage = new TimetablePage();
        timetablePage.goToTimetableTab();
        Common common = new Common();
        common.scrollToBottom();
        timetablePage.bookTicketButton("Huế", "Sài Gòn");

        BookTicketPage bookTicketPage = new BookTicketPage();
        common.scrollToBottom();

        Assert.assertEquals("Huế", bookTicketPage.selectedDepartFromValue());
        Assert.assertEquals("Sài Gòn", bookTicketPage.selectedArriveAtValue());
    }
}
