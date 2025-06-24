package com.example.Constant;

import com.example.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;

public class Constant {

    //LoginPage
    public static final String loginPageTitle = "Login page";
    public static final String validUsername = "dattdd129@gmail.com";
    public static final String validPassword = "12345678";
    public static final String inValidPassword = "1@3#5_7!/;'";
    public static final String blankEmailOrPasswordErrorMessage = "There was a problem with your login and/or errors exist in your form.";
    public static final String invalidAllErrormessage = "Invalid username or password. Please try again.";
    public static final String fourTimesLoginFailMessage = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

    //HomePageAfterLogin
    public static final String welcomeMessage = "Welcome " + validUsername;

    //RegisterPage
    public static final String thankyouText = "Thank you for registering your account";
    public static final String registEremail = "113@gmail.com";
    public static final String registerEmail2 = "02091945@gmail.com";
    public static final String registerPassword = "12345678";
    public static final String registerCfPassword = registerPassword;
    public static final String registerPID = "12345678";
    public static final String registerMessageError = "There're errors in the form. Please correct the errors and try again.";
    public static final String invalidPasswordErrorMessage = "Invalid password length";
    public static final String invalidIDErrorMessage = "Invalid ID length";

    //ChangePasswordPage
    public static final String changePasswordTitle = "Change password";
    public static final String changePasswordMessageSuccess = "Your password has been updated!";

    //MyTicketPage
    public static final String myTicketTitle = "Manage ticket";


    public void scrollToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
