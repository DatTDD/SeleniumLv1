package com.tests.register;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.pages.RegisterPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase11 extends TestBase {

    @Test
    public void UserCannotCreateAccountWhilePasswordAndPIDFieldsAreEmpty() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.clickOnTab(Constants.MenuBar.REGISTER);

        Common common = new Common();
        common.scrollToBottom();

        registerPage.registerAccount(Constants.Account.REGISTER_EMAIL, "","","");

        Assert.assertEquals(registerPage.getInvalidPasswordErrorMessage(), Constants.Register.INVALID_PASSWORD_ERROR_MESSAGE);
        Assert.assertEquals(registerPage.getPidInvalidErrorMessage(), Constants.Register.INVALID_ID_ERROR_MESSAGE);
    }
}
