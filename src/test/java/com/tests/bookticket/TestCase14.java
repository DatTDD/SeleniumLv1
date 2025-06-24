package com.tests.bookticket;

import com.example.Constant.Constant;
import com.example.pages.BookTicketPage;
import com.example.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.annotations.Test;

public class TestCase14 extends TestBase {

    @Test
    public void TestCase14(){
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginTab();
        loginPage.login(Constant.validUsername, Constant.validPassword);

        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.gotoBookTicketTab();


    }
}
