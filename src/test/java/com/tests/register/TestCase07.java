package com.tests.register;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.pages.RegisterPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase07 extends TestBase {

    @Test
    public void User_can_create_new_account() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.clickOnTab(Constants.MenuBar.REGISTER);

        Common common = new Common();
        common.scrollToBottom();

        registerPage.registerAccount(common.createMail(10), Constants.Account.REGISTER_PASSWORD, Constants.Account.REGISTER_CF_PASSWORD, Constants.Account.REGISTER_PID);
        Assert.assertEquals(registerPage.getSuccessMessage(), Constants.Register.THANKYOU_TEXT);
    }
}
