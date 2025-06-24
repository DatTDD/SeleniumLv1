package com.tests.logintest;

import com.example.Constant.Constant;
import com.example.pages.BookTicketPage;
import com.example.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase04 extends TestBase {

    @Test
    public void TestCase04(){
        LoginPage loginPage = new LoginPage();

        BookTicketPage bookticketPage = new BookTicketPage();
        bookticketPage.gotoBookTicketTab();

        Assert.assertEquals(loginPage.loginTitleText(),Constant.loginPageTitle,"Ban dang o trang Login");
    }
}
