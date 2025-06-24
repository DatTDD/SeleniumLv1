package com.tests.logintest;

import com.example.Constant.Constant;
import com.example.pages.ChangePasswordPage;
import com.example.pages.LoginPage;
import com.example.pages.MyTicketPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase06 extends TestBase {

    @Test
    public void testCase06() {
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginTab();
        loginPage.login(Constant.validUsername,Constant.validPassword);

        MyTicketPage myTicketPage = new MyTicketPage();
        myTicketPage.gotoMyticketTab();
        Assert.assertEquals(myTicketPage.myticketTitleText(),Constant.myTicketTitle,"Ban dang o trang My Ticket");

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.gotoChangePasswordTab();

        Assert.assertEquals(changePasswordPage.changePasswordTitle(),Constant.changePasswordTitle, "Ban dang o trang Change Password");
    }

}
