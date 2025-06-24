package com.tests.logintest;

import com.example.Constant.Constant;
import com.example.driver.DriverManager;
import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.example.pages.MyTicketPage;
import com.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase06 extends TestBase {

    @Test
    public void testCase06() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.validusername,Constant.validpassword);

        WebElement Changepassword = DriverManager.getDriver().findElement(By.xpath("//a[span='Change password']"));
        WebElement Logout = DriverManager.getDriver().findElement(By.xpath("//a[span='Log out']"));

        if (Changepassword.isDisplayed() && Logout.isDisplayed()){
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Đăng nhập thất bại.");
        }

        MyTicketPage myTicketPage = new MyTicketPage();
        //MyTicketPage.gotoMyTicket();
    }

}
