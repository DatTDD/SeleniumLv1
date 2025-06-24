package com.example.pages;

import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class RegisterPage {
    private final By registertab = By.xpath("//a[span='Register']");
    private final By emailTextBox = By.id("email");
    private final By passwordTextBox = By.id("password");
    private final By cfpasswordTextBox = By.id("confirmPassword");
    private final By pidTextBox = By.id("pid");
    private final By registerButton = By.xpath("//input[@type='submit'][@value='Register']");
    private final By thankyouMessage = By.xpath("//h1[text()='Thank you for registering your account']");

    private WebElement getRegisterTab() {
        return DriverManager.getDriver().findElement(registertab);
    }

    private WebElement getEmailTextBox() {
        return DriverManager.getDriver().findElement(emailTextBox);
    }

    private WebElement getPasswordTextBox() {
        return DriverManager.getDriver().findElement(passwordTextBox);
    }

    private WebElement getCfPasswordTextBox() {
        return DriverManager.getDriver().findElement(cfpasswordTextBox);
    }

    private WebElement getPidTextBox() {
        return DriverManager.getDriver().findElement(pidTextBox);
    }

    private WebElement getRegisterButton() {
        return DriverManager.getDriver().findElement(registerButton);
    }


    public void register(String email, String password, String cfpassword, String pid) {
        getRegisterTab().click();
        getEmailTextBox().sendKeys(email);
        getPasswordTextBox().sendKeys(password);
        getCfPasswordTextBox().sendKeys(cfpassword);
        getPidTextBox().sendKeys(pid);
        getRegisterButton().click();
    }

    public String thankyouText () {
        String strThankyouText = null;
        WebElement thankyouText = DriverManager.getDriver().findElement(thankyouMessage);
        if (thankyouText.isDisplayed() && thankyouText.isEnabled())
            strThankyouText = thankyouText.getText();
        return strThankyouText;
    }

}
