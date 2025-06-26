package com.railway.pages;

import com.railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class RegisterPage extends BasePage {
    private final By registerTabBy = By.xpath("//a[span='Register']");
    private final By emailTextBoxBy = By.id("email");
    private final By passwordTextBoxBy = By.id("password");
    private final By cfPasswordTextBoxBy = By.id("confirmPassword");
    private final By pidTextBoxBy = By.id("pid");
    private final By registerButtonBy = By.xpath("//input[@type='submit'][@value='Register']");
    private final By successMessageTextBy = By.xpath("//h1[text()='Thank you for registering your account']");
    private final By messageErrorTextBy = By.xpath("//p[@class='message error']");
    private final By passwordInvalidErrorMessageTextBy = By.xpath("//label[@for='password'][@class='validation-error']");
    private final By pidInvalidErrorMessageTextBy = By.xpath("//label[@for='pid'][@class='validation-error']");

    private WebElement registerTab() {
        return DriverManager.getDriver().findElement(registerTabBy);
    }

    private WebElement emailTextBox() {
        return DriverManager.getDriver().findElement(emailTextBoxBy);
    }

    private WebElement passwordTextBox() {
        return DriverManager.getDriver().findElement(passwordTextBoxBy);
    }

    private WebElement cfPasswordTextBox() {
        return DriverManager.getDriver().findElement(cfPasswordTextBoxBy);
    }

    private WebElement pidTextBox() {
        return DriverManager.getDriver().findElement(pidTextBoxBy);
    }

    private WebElement registerButton() {
        return DriverManager.getDriver().findElement(registerButtonBy);
    }

    private WebElement successMessageText() {
        return DriverManager.getDriver().findElement(successMessageTextBy);
    }

    private WebElement errorMessageText() {
        return DriverManager.getDriver().findElement(messageErrorTextBy);
    }

    private WebElement passwordInvalidErrorMessageText() {
        return DriverManager.getDriver().findElement(passwordInvalidErrorMessageTextBy);
    }

    private WebElement pidInvalidErrorMessgaeText() {
        return DriverManager.getDriver().findElement(pidInvalidErrorMessageTextBy);
    }

    public void gotoRegisterTab() {
        registerTab().click();
    }

    public void registerAccount(String email, String password, String cfpassword, String pid) {
        emailTextBox().sendKeys(email);
        passwordTextBox().sendKeys(password);
        cfPasswordTextBox().sendKeys(cfpassword);
        pidTextBox().sendKeys(pid);
        registerButton().click();
    }

    public String successMessage() {
        return successMessageText().getText();
    }

    public String errorMessage() {
        return errorMessageText().getText();
    }

    public String invalidPasswordErrorMessage(){
        return passwordInvalidErrorMessageText().getText();
    }

    public String pidInvalidErrorMessage() {
        return pidInvalidErrorMessgaeText().getText();
    }

}
