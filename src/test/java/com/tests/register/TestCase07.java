package com.tests.register;

import com.example.Constant.Constant;
import com.example.pages.RegisterPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase07 extends TestBase {

    @Test
    public void TestCase07 (){
        RegisterPage registerPage = new RegisterPage();
        registerPage.gotoRegisterTab();

        Constant constant = new Constant();
        constant.scrollToBottom();

        registerPage.register(Constant.registEremail,Constant.registerPassword,Constant.registerCfPassword,Constant.registerPID);
        Assert.assertEquals(registerPage.thankyouMessage(),Constant.thankyouText,"Dang ky thanh cong");
    }
}
