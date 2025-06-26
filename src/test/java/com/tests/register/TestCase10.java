package com.tests.register;

import com.railway.common.Common;
import com.railway.constant.Constant;
import com.railway.pages.RegisterPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase10 extends TestBase {

    @Test
    public void UserCannotCreateAccountWithConfirmPasswordIsNotTheSameAsPassword() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.gotoRegisterTab();

        Common common = new Common();
        common.scrollToBottom();

        registerPage.registerAccount(Constant.Register.REGISTER_EMAIL2,Constant.Register.REGISTER_PASSWORD,Constant.Register.REGISTER_EMAIL2,Constant.Register.REGISTER_PID);

        Assert.assertEquals(registerPage.errorMessage(),Constant.Register.REGISTER_MESSAGE_ERROR,"");
    }
}
