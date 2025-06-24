package com.tests.logintest;

import com.example.Constant.Constant;
import com.example.pages.LoginPage;
import com.example.pages.RegisterPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase07 extends TestBase {

    @Test
    public void TestCase07 (){
        RegisterPage registerPage = new RegisterPage();
        registerPage.register(Constant.registeremail,Constant.registerpassword,Constant.registercfpassword,Constant.registerpid);
        Assert.assertEquals(registerPage.thankyouText(),Constant.thankyouText,"Dang ky thanh cong");
    }
}
