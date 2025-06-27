package com.tests.logintest;

import com.railway.constant.Constants;
import com.railway.pages.BookTicketPage;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase04 extends TestBase {

    @Test
    public void LoginPageDisplaysWhenUserClicksOnBookTicketTabWithoutLogin() {
        LoginPage loginPage = new LoginPage();

        BookTicketPage bookticketPage = new BookTicketPage();
        bookticketPage.clickOnTab(Constants.MenuBar.BOOK_TICKET);

        Assert.assertEquals(loginPage.loginTitle(), Constants.PageTitle.LOGIN_PAGE_TITLE);
    }
}
