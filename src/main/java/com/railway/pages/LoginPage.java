package com.railway.pages;

import com.railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final By loginTabBy = By.xpath("//a[span='Login']");
    private final By usernameTextBoxBy = By.id("username");
    private final By passwordTextBoxBy = By.id("password");
    private final By loginbuttonBy = By.xpath("//input[@type='submit']");
    private final By loginErrorMessageBy = By.xpath("//p[@class = 'message error LoginForm']");
    private final By loginTitleBy = By.xpath("//h1[text()='Login page']");
    private final By forgotPasswordPageBy = By.xpath("//a[text()='Forgot Password page']");
    private final By emailAddressTextBoxBy = By.id("email");
    private final By sendInstructionsButtonBy = By.xpath("//input[@type='submit'][@value='Send Instructions']");


    private WebElement loginTab() {
        return DriverManager.getDriver().findElement(loginTabBy);
    }

    private WebElement userNameTextBox() {
        return DriverManager.getDriver().findElement(usernameTextBoxBy);
    }

    private WebElement passwordTextBox() {
        return DriverManager.getDriver().findElement(passwordTextBoxBy);
    }

    private WebElement loginButton(){
        return DriverManager.getDriver().findElement(loginbuttonBy);
    }

    private WebElement loginErrorMessageText(){
        return DriverManager.getDriver().findElement(loginErrorMessageBy);
    }

    private WebElement loginTitleText() {
        return DriverManager.getDriver().findElement(loginTitleBy);
    }

    private WebElement forgotPasswordPage() {
        return DriverManager.getDriver().findElement(forgotPasswordPageBy);
    }

    private WebElement emailAddressTextBox() {
        return DriverManager.getDriver().findElement(emailAddressTextBoxBy);
    }

    private WebElement sendInstructionsButton() {
        return DriverManager.getDriver().findElement(sendInstructionsButtonBy);
    }

    public void gotoLoginTab() {
        loginTab().click();
    }

    public void login(String username, String password) {
        userNameTextBox().sendKeys(username);
        passwordTextBox().sendKeys(password);
        loginButton().click();
    }

    public String loginErrorMessage () {
        return loginErrorMessageText().getText();
    }

    public String loginTitle() {
        return loginTitleText().getText();
    }

    public void gotoForgotPasswordPage() {
        forgotPasswordPage().click();
    }

    public void emailAddressTextBox(String email) {
        emailAddressTextBox().sendKeys(email);
    }

    public void sendInstructions() {
        sendInstructionsButton().click();
    }

}
