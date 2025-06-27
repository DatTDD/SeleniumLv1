package com.tests.logintest;

import com.railway.constant.Constants;
import com.railway.pages.*;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase06 extends TestBase {

    @Test
    public void AdditionalPagesDisplayOnceUserLoggedIn() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        loginPage.login(Constants.Account.VALID_USERNAME, Constants.Account.VALID_PASSWORD);
        HomePage homepage = new HomePage();
        Assert.assertTrue(homepage.isChangePasswordTabDisplayed());
        Assert.assertTrue(homepage.isMyTicketTabDisplayed());
        Assert.assertTrue(homepage.isLogOutTabDisplayed());

        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.clickOnTab(Constants.MenuBar.MY_TICKET);
        Assert.assertEquals(myTicketPage.getMyTicketTitle(), Constants.PageTitle.MY_TICKET_TITLE);

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.clickOnTab(Constants.MenuBar.CHANGE_PASSWORD);
        Assert.assertEquals(changePasswordPage.changePasswordTitle(), Constants.PageTitle.CHANGE_PASSWORD_TITLE);
    }

}
