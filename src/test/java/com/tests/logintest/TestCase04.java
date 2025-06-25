package com.tests.logintest;

import com.railway.constant.Constant;
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
        bookticketPage.goToBookTicketTab();

        Assert.assertEquals(loginPage.loginTitle(),Constant.Login.LOGIN_PAGE_TITLE);
    }
}
