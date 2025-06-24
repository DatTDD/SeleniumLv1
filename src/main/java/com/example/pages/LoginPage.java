package com.example.pages;

import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class LoginPage {

    private final By LoginTab = By.xpath("//a[span='Login']");
    private final By UsernameTextBox = By.id("username");
    private final By PasswordTextBox = By.id("password");
    private final By Loginbutton = By.xpath("//input[@type='submit']");
    private final By LoginErrorMessage = By.xpath("//p[@class = 'message error LoginForm']");
    private final By LoginTitle = By.xpath("//h1[text()='Login page']");
    private final By forgotPasswordPage = By.xpath("//a[text()='Forgot Password page']");
    private final By emailAddressTextBox = By.id("email");
    private final By sendInstructionsButton = By.xpath("//input[@type='submit'][@value='Send Instructions']");


    private WebElement getLoginTab() {
        return DriverManager.getDriver().findElement(LoginTab);
    }

    private WebElement getUserNameTextBox() {
        return DriverManager.getDriver().findElement(UsernameTextBox);
    }

    private WebElement getPasswordTextBox() {
        return DriverManager.getDriver().findElement(PasswordTextBox);
    }

    private WebElement getLoginButton(){
        return DriverManager.getDriver().findElement(Loginbutton);
    }

    private WebElement getLoginErrorMessage(){
        return DriverManager.getDriver().findElement(LoginErrorMessage);
    }

    private WebElement getLoginTitle() {
        return DriverManager.getDriver().findElement(LoginTitle);
    }

    private WebElement getForgotPasswordPage() {
        return DriverManager.getDriver().findElement(forgotPasswordPage);
    }

    private WebElement getEmailAddressTextBox() {
        return DriverManager.getDriver().findElement(emailAddressTextBox);
    }

    private WebElement getSendInstructionsButton() {
        return DriverManager.getDriver().findElement(sendInstructionsButton);
    }

    public void gotoLoginTab() {
        getLoginTab().click();
    }

    public void login(String username, String password) {
        getUserNameTextBox().sendKeys(username);
        getPasswordTextBox().sendKeys(password);
        getLoginButton().click();
    }

    public String loginErrorMessage () {
        return getLoginErrorMessage().getText();
    }

    public String loginTitleText () {
        return getLoginTitle().getText();
    }

    public void gotoForgotPasswordPage() {
        getForgotPasswordPage().click();
    }

    public void emailAddressTextBox(String email) {
        getEmailAddressTextBox().sendKeys(email);
    }

    public void sendInstructionsButton() {
        getSendInstructionsButton().click();
    }

}
