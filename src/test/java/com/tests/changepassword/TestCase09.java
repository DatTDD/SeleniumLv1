package com.tests.changepassword;

import com.railway.common.Common;
import com.railway.constant.Constant;
import com.railway.pages.ChangePasswordPage;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase09 extends TestBase {

    @Test
    public void UserCanChangePassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginTab();
        loginPage.login(Constant.Login.VALID_USERNAME, Constant.Login.VALID_PASSWORD);

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.gotoChangePasswordTab();

        Common common = new Common();
        common.scrollToBottom();

        changePasswordPage.changePassword(Constant.Login.VALID_PASSWORD,Constant.Login.VALID_PASSWORD, Constant.Login.VALID_PASSWORD);

        Assert.assertEquals(changePasswordPage.changePasswordMessageSuccess(),Constant.ChangePassword.CHANGE_PASSWORD_MESSAGE_SUCCESS);
    }

}
