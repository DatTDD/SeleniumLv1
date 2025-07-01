package com.railway.pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    private final By emailTextBox = By.id("email");
    private final By passwordTextBox = By.id("password");
    private final By cfPasswordTextBox = By.id("confirmPassword");
    private final By pidTextBox = By.id("pid");
    private final By registerButton = By.xpath("//input[@type='submit'][@value='Register']");
    private final By successMessage = By.xpath("//h1[text()='Thank you for registering your account']");
    private final By messageErrorText = By.xpath("//p[@class='message error']");
    private final By passwordInvalidErrorMessage = By.xpath("//label[@for='password'][@class='validation-error']");
    private final By pidInvalidErrorMessage = By.xpath("//label[@for='pid'][@class='validation-error']");

    public void registerAccount(String email, String password, String cfpassword, String pid) {
        getWebElement(emailTextBox).sendKeys(email);
        getWebElement(passwordTextBox).sendKeys(password);
        getWebElement(cfPasswordTextBox).sendKeys(cfpassword);
        getWebElement(pidTextBox).sendKeys(pid);
        getWebElement(registerButton).click();
    }

    public String getSuccessMessage() {
        return getWebElement(successMessage).getText();
    }

    public String getErrorMessage() {
        return getWebElement(messageErrorText).getText();
    }

    public String getInvalidPasswordErrorMessage(){
        return getWebElement(passwordInvalidErrorMessage).getText();
    }

    public String getPidInvalidErrorMessage() {
        return getWebElement(pidInvalidErrorMessage).getText();
    }

}
