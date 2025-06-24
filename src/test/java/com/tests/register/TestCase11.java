package com.tests.register;

import com.example.Constant.Constant;
import com.example.pages.LoginPage;
import com.example.pages.RegisterPage;
import com.tests.base.TestBase;
import com.tests.logintest.TestCase01;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase11 extends TestBase {

    @Test
    public void TestCase11() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.gotoRegisterTab();
        registerPage.register(Constant.registerEmail2, "","","");

        Assert.assertEquals(registerPage.passwordInvalidError(),Constant.invalidPasswordErrorMessage,"");
        Assert.assertEquals(registerPage.pidInvalidError(), Constant.invalidIDErrorMessage,"");
    }
}
