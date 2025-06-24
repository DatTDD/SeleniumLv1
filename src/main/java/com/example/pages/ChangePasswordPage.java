package com.example.pages;

import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {
    private final By changePasswordTab = By.xpath("//a[span='Change password']");
    private final By changePasswordTitle = By.xpath("//h1[text()='Change password']");
    private final By currentPasswordTextBox = By.id("currentPassword");
    private final By newPasswordTextBox = By.id("newPassword");
    private final By cfPasswordTextBox = By.id("confirmPassword");
    private final By changePasswordButton = By.xpath("//input[@type='submit']");
    private final By changePasswordMessageSuccess = By.xpath("//p[@class='message success']");

    private WebElement getChangePasswordTab() {
        return DriverManager.getDriver().findElement(changePasswordTab);
    }

    private WebElement getChangePasswordTitle() {
        return DriverManager.getDriver().findElement(changePasswordTitle);
    }

    private WebElement getCurrentPasswordTextBox () {
        return DriverManager.getDriver().findElement(currentPasswordTextBox);
    }

    private WebElement getNewPasswordTextBox () {
        return DriverManager.getDriver().findElement(newPasswordTextBox);
    }

    private WebElement getCfPasswordTextBox () {
        return DriverManager.getDriver().findElement(cfPasswordTextBox);
    }

    private WebElement getChangePasswordButton () {
        return DriverManager.getDriver().findElement(changePasswordButton);
    }

    private WebElement getChangePasswordMessageSuccess() {
        return DriverManager.getDriver().findElement(changePasswordMessageSuccess);
    }

    public void gotoChangePasswordTab() {
        getChangePasswordTab().click();
    }

    public String changePasswordTitle() {
        return getChangePasswordTitle().getText();
    }

    public void changePassword(String CurrentPassword, String NewPassword, String CfPassword) {
        getCurrentPasswordTextBox().sendKeys(CurrentPassword);
        getNewPasswordTextBox().sendKeys(NewPassword);
        getCfPasswordTextBox().sendKeys(CfPassword);
        getChangePasswordButton().click();
    }

    public String changePasswordMessageSuccess() {
        return getChangePasswordMessageSuccess().getText();
    }

}
