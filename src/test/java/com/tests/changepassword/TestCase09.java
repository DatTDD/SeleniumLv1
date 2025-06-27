package com.tests.changepassword;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.pages.ChangePasswordPage;
import com.railway.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase09 extends TestBase {

    @Test
    public void UserCanChangePassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnTab(Constants.MenuBar.LOGIN);
        loginPage.login(Constants.Account.VALID_USERNAME, Constants.Account.VALID_PASSWORD);

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.clickOnTab(Constants.MenuBar.CHANGE_PASSWORD);

        Common common = new Common();
        common.scrollToBottom();

        changePasswordPage.changePassword(Constants.Account.VALID_PASSWORD, Constants.Account.VALID_PASSWORD, Constants.Account.VALID_PASSWORD);

        Assert.assertEquals(changePasswordPage.getChangePasswordMessageSuccess(), Constants.ChangePassword.CHANGE_PASSWORD_MESSAGE_SUCCESS);
    }

}
