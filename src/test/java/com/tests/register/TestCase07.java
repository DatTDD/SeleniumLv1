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

        registerPage.registerAccount(common.createMail(10), Constant.Register.REGISTER_PASSWORD,Constant.Register.REGISTER_CF_PASSWORD,Constant.Register.REGISTER_PID);
        Assert.assertEquals(registerPage.successMessage(),Constant.Register.THANKYOU_TEXT);
    }
}
