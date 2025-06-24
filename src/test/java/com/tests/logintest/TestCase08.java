package com.tests.logintest;

import com.example.Constant.Constant;
import com.example.pages.LoginPage;
import com.tests.base.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase08 extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(TestCase08.class);

    @Test
    public void TestCase08 (){
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginTab();
        loginPage.login(Constant.registEremail, Constant.registerPassword);

        Assert.assertEquals(loginPage.loginErrorMessage(),Constant.invalidAllErrormessage, "Dang nhap that bai");
    }
}
