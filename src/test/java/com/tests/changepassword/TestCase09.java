package com.tests.changepassword;

import com.example.Constant.Constant;
import com.example.pages.ChangePasswordPage;
import com.example.pages.LoginPage;
import com.tests.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase09 extends TestBase {

    @Test
    public void TestCase09(){
        LoginPage loginPage = new LoginPage();
        loginPage.login(Constant.validUsername, Constant.validPassword);

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.gotoChangePasswordTab();

        Constant constant = new Constant();
        constant.scrollToBottom();

        changePasswordPage.changePassword(Constant.validPassword,Constant.validPassword, Constant.validPassword);

        Assert.assertEquals(changePasswordPage.changePasswordMessageSuccess(),Constant.changePasswordMessageSuccess,"Doi mat khau thanh cong");
    }

}
