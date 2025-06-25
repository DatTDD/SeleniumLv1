package com.tests.register;

import com.railway.common.Common;
import com.railway.constant.Constant;
import com.railway.pages.RegisterPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase07 extends TestBase {

    @Test
    public void User_can_create_new_account() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.gotoRegisterTab();

        Common common = new Common();
        common.scrollToBottom();

        registerPage.registerAccount(Constant.REGISTER_EMAIL,Constant.REGISTER_PASSWORD,Constant.REGISTER_CF_PASSWORD,Constant.REGISTER_PID);
        Assert.assertEquals(registerPage.thankyouMessage(),Constant.THANKYOU_TEXT);
    }
}
