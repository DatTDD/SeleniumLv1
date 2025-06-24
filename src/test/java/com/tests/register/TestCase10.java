package com.tests.register;

import com.example.Constant.Constant;
import com.example.pages.RegisterPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase10 extends TestBase {

    @Test
    public void TestCase10() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.gotoRegisterTab();

        Constant constant = new Constant();
        constant.scrollToBottom();

        registerPage.register(Constant.registerEmail2,Constant.registerPassword,Constant.registerEmail2,Constant.registerPID);

        Assert.assertEquals(registerPage.errorMessage(),Constant.registerMessageError,"");
    }
}
