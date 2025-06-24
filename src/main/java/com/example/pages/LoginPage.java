package com.example.pages;

import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final By LoginTab = By.xpath("//a[span='Login']");
    private final By UsernameTextBox = By.id("username");
    private final By PasswordTextBox = By.id("password");
    private final By Loginbutton = By.xpath("//input[@type='submit']");
    private final By LoginErrorMessage = By.xpath("//p[@class = 'message error LoginForm']");
    private final By LoginTitle = By.xpath("//h1[text()='Login page']");


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

    public void login(String username, String password) {
        getLoginTab().click();
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
}
