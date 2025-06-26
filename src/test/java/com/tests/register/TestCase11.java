package com.tests.register;

import com.railway.constant.Constant;
import com.railway.pages.RegisterPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase11 extends TestBase {

    @Test
    public void UserCannotCreateAccountWhilePasswordAndPIDFieldsAreEmpty() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.gotoRegisterTab();
        registerPage.registerAccount(Constant.Register.REGISTER_EMAIL2, "","","");

        Assert.assertEquals(registerPage.invalidPasswordErrorMessage(),Constant.Register.INVALID_PASSWORD_ERROR_MESSAGE);
        Assert.assertEquals(registerPage.pidInvalidErrorMessage(), Constant.Register.invalidIDErrorMessage);
    }
}
