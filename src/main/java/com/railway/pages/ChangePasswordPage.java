package com.railway.pages;

import com.railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {
    private final By changePasswordTabBy = By.xpath("//a[span='Change password']");
    private final By changePasswordTitleBy = By.xpath("//h1[text()='Change password']");
    private final By currentPasswordTextBoxBy = By.id("currentPassword");
    private final By newPasswordTextBoxBy = By.id("newPassword");
    private final By cfPasswordTextBoxBy = By.id("confirmPassword");
    private final By changePasswordButtonBy = By.xpath("//input[@type='submit']");
    private final By changePasswordMessageSuccessBy = By.xpath("//p[@class='message success']");

    private WebElement getChangePasswordTab() {
        return DriverManager.getDriver().findElement(changePasswordTabBy);
    }

    private WebElement changePasswordTitleText() {
        return DriverManager.getDriver().findElement(changePasswordTitleBy);
    }

    private WebElement currentPasswordTextBox () {
        return DriverManager.getDriver().findElement(currentPasswordTextBoxBy);
    }

    private WebElement newPasswordTextBox () {
        return DriverManager.getDriver().findElement(newPasswordTextBoxBy);
    }

    private WebElement cfPasswordTextBox () {
        return DriverManager.getDriver().findElement(cfPasswordTextBoxBy);
    }

    private WebElement changePasswordButton () {
        return DriverManager.getDriver().findElement(changePasswordButtonBy);
    }

    private WebElement changePasswordMessageSuccessText() {
        return DriverManager.getDriver().findElement(changePasswordMessageSuccessBy);
    }

    public void gotoChangePasswordTab() {
        getChangePasswordTab().click();
    }

    public String changePasswordTitle() {
        return changePasswordTitleText().getText();
    }

    public void changePassword(String CurrentPassword, String NewPassword, String CfPassword) {
        currentPasswordTextBox().sendKeys(CurrentPassword);
        newPasswordTextBox().sendKeys(NewPassword);
        cfPasswordTextBox().sendKeys(CfPassword);
        changePasswordButton().click();
    }

    public String changePasswordMessageSuccess() {
        return changePasswordMessageSuccessText().getText();
    }

}
