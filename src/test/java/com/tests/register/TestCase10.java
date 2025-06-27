package com.tests.register;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.pages.RegisterPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase10 extends TestBase {

    @Test
    public void UserCannotCreateAccountWithConfirmPasswordIsNotTheSameAsPassword() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.clickOnTab(Constants.MenuBar.REGISTER);

        Common common = new Common();
        common.scrollToBottom();

        registerPage.registerAccount(Constants.Account.REGISTER_EMAIL, Constants.Account.REGISTER_PASSWORD, Constants.Account.REGISTER_EMAIL, Constants.Account.REGISTER_PID);

        Assert.assertEquals(registerPage.getErrorMessage(), Constants.Register.REGISTER_MESSAGE_ERROR,"");
    }
}
