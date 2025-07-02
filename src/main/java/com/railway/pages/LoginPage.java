package com.railway.pages;

import com.railway.constant.Constants;
import org.openqa.selenium.By;
import com.railway.dataobject.Account;


public class LoginPage extends BasePage {
    private final By usernameTextBox = By.id("username");
    private final By passwordTextBox = By.id("password");
    private final By loginButton = By.xpath("//input[@type='submit']");
    private final By loginErrorMessage = By.xpath("//p[@class = 'message error LoginForm']");
    private final By loginTitle = By.xpath("//h1[text()='Login page']");
    private final By forgotPasswordPage = By.xpath("//a[text()='Forgot Password page']");

    public void login(Account account) {
        //clickOnTab(Constants.MenuBar.LOGIN);
        if (!getWebElement(usernameTextBox).getAttribute("value").isEmpty()) {
            getWebElement(usernameTextBox).clear();
        }
        getWebElement(usernameTextBox).sendKeys(account.getUsername());
        getWebElement(passwordTextBox).sendKeys(account.getPassword());
        getWebElement(loginButton).click();
    }

    public String loginErrorMessage() {
        return getWebElement(loginErrorMessage).getText();
    }

    public String loginTitle() {
        return getWebElement(loginTitle).getText();
    }

    public void gotoForgotPasswordPage() {
        getWebElement(forgotPasswordPage).click();
    }
}
