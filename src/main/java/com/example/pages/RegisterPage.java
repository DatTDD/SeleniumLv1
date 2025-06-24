package com.example.pages;

import com.example.Constant.Constant;
import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebElement;



public class RegisterPage {
    private final By Registertab = By.xpath("//a[span='Register']");
    private final By EmailTextBox = By.id("email");
    private final By PasswordTextBox = By.id("password");
    private final By CfPasswordTextBox = By.id("confirmPassword");
    private final By PIDTextBox = By.id("pid");
    private final By RegisterButton = By.xpath("//input[@type='submit'][@value='Register']");
    private final By ThankyouMessage = By.xpath("//h1[text()='Thank you for registering your account']");
    private final By MessageError = By.xpath("//p[@class='message error']");

    private WebElement getRegisterTab() {
        return DriverManager.getDriver().findElement(Registertab);
    }

    private WebElement getEmailTextBox() {
        return DriverManager.getDriver().findElement(EmailTextBox);
    }

    private WebElement getPasswordTextBox() {
        return DriverManager.getDriver().findElement(PasswordTextBox);
    }

    private WebElement getCfPasswordTextBox() {
        return DriverManager.getDriver().findElement(CfPasswordTextBox);
    }

    private WebElement getPidTextBox() {
        return DriverManager.getDriver().findElement(PIDTextBox);
    }

    private WebElement getRegisterButton() {
        return DriverManager.getDriver().findElement(RegisterButton);
    }

    private WebElement getThankyouMessage() {
        return DriverManager.getDriver().findElement(ThankyouMessage);
    }

    private WebElement getMessageError() {
        return DriverManager.getDriver().findElement(MessageError);
    }

    public void gotoRegisterTab() {
        getRegisterTab().click();
    }


    public void register(String email, String password, String cfpassword, String pid) {
        getEmailTextBox().sendKeys(email);
        getPasswordTextBox().sendKeys(password);
        getCfPasswordTextBox().sendKeys(cfpassword);
        getPidTextBox().sendKeys(pid);
        getRegisterButton().click();
    }

    public String thankyouMessage() {
        return getThankyouMessage().getText();
    }

    public String errorMessage() {
        return getMessageError().getText();
    }

}
