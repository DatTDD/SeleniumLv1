package com.tests.logintest;

import com.railway.constant.Constant;
import com.railway.pages.ChangePasswordPage;
import com.railway.pages.LoginPage;
import com.railway.pages.MyTicketPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase06 extends TestBase {

    @Test
    public void AdditionalPagesDisplayOnceUserLoggedIn() {
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginTab();
        loginPage.login(Constant.Login.VALID_USERNAME,Constant.Login.VALID_PASSWORD);

        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.goToMyTicketTab();
        Assert.assertEquals(myTicketPage.myTicketTitleText(),Constant.PageTitle.MY_TICKET_TITLE);

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.gotoChangePasswordTab();

        Assert.assertEquals(changePasswordPage.changePasswordTitle(),Constant.PageTitle.CHANGE_PASSWORD_TITLE);
    }

}
