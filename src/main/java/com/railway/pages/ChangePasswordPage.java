package com.railway.pages;

import org.openqa.selenium.By;

public class ChangePasswordPage extends BasePage {
    private final By changePasswordTitle = By.xpath("//h1[text()='Change password']");
    private final By currentPasswordTextBox = By.id("currentPassword");
    private final By newPasswordTextBox = By.id("newPassword");
    private final By cfPasswordTextBox = By.id("confirmPassword");
    private final By changePasswordButton = By.xpath("//input[@type='submit']");
    private final By changePasswordMessageSuccess = By.xpath("//p[@class='message success']");

    public String changePasswordTitle() {
        return getWebElement(changePasswordTitle).getText();
    }

    public void changePassword(String CurrentPassword, String NewPassword, String CfPassword) {
        getWebElement(currentPasswordTextBox).sendKeys(CurrentPassword);
        getWebElement(newPasswordTextBox).sendKeys(NewPassword);
        getWebElement(cfPasswordTextBox).sendKeys(CfPassword);
        getWebElement(changePasswordButton).click();
    }

    public String getChangePasswordMessageSuccess() {
        return getWebElement(changePasswordMessageSuccess).getText();
    }

}