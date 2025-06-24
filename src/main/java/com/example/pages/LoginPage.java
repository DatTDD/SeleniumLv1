package com.example.pages;

import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final By loginTab = By.xpath("//a[span='Login']");
    private final By usernameTextBox = By.id("username");
    private final By passwordTextBox = By.id("password");
    private final By loginbutton = By.cssSelector("input[type='submit'][value='login']");
    private final By loginErrorMessage = By.xpath("//p[@class = 'message error LoginForm']");


    private WebElement getLoginTab() {
        return DriverManager.getDriver().findElement(loginTab);
    }

    private WebElement getUserNameTextBox() {
        return DriverManager.getDriver().findElement(usernameTextBox);
    }

    private WebElement getPasswordTextBox() {
        return DriverManager.getDriver().findElement(passwordTextBox);
    }

    private WebElement getLoginButton(){
        return DriverManager.getDriver().findElement(loginbutton);
    }

    public void login(String username, String password) {
        getLoginTab().click();
        getUserNameTextBox().sendKeys(username);
        getPasswordTextBox().sendKeys(password);
        getLoginButton().click();
    }

    public String getErrorMessage () {
        String strErrorMessage = null;
        WebElement ErrorMessage = DriverManager.getDriver().findElement(loginErrorMessage);
        if (ErrorMessage.isDisplayed() && ErrorMessage.isEnabled())
            strErrorMessage = ErrorMessage.getText();
        return strErrorMessage;
    }
}
