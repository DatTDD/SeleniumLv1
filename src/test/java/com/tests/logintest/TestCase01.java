package com.tests.logintest;

import com.example.Constant.Constant;
import com.example.driver.DriverManager;
import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCase01 extends TestBase {

    @Test
    public void testCase01() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.validusername,Constant.validpassword);

        //Assert.assertEquals(actualText, Constant.welcomeMessage, "Đăng nhập thành công!");
    }

}
