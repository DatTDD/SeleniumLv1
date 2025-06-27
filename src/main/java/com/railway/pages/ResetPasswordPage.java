package com.railway.pages;

import com.railway.constant.Constants;
import com.railway.driver.DriverManager;
import org.openqa.selenium.By;

import java.util.Objects;

public class ResetPasswordPage extends BasePage {
    private final By newPasswordTextBox = By.id("newPassword");
    private final By confirmPasswordTextBox = By.id("confirmPassword");
    private final By resetTokenTextBox = By.id("resetToken");
    private final By submitButton = By.xpath("//input[@type='submit']");
    private final By errorMessage = By.xpath("//p[@class='message error']");
    private final By errorResetTokenMessage = By.xpath("//label[@for='resetToken' and @class='validation-error']");
    private final By errorConfirmPasswordMessage = By.xpath("//label[@for='confirmPassword' and @class='validation-error']");

    public void navigateToResetPasswordTab() {
        for(String handle : DriverManager.getDriver().getWindowHandles()) {
            DriverManager.getDriver().switchTo().window(handle);

            if(Objects.equals(DriverManager.getDriver().getTitle(), Constants.PageTitle.RESET_PASSWORD_PAGE_TITLE)) break;
        }
    }

    public void resetPassword(String newPassword, String confirmPassword, boolean isResetToken) {
        getWebElement(newPasswordTextBox).sendKeys(newPassword);
        getWebElement(confirmPasswordTextBox).sendKeys(confirmPassword);

//        if(!isResetToken) {
//            getWebElement(resetTokenTextBox).sendKeys(Keys.CONTROL + "a");
//            getWebElement(resetTokenTextBox).sendKeys(Keys.DELETE);
//        }
        getWebElement(resetTokenTextBox).clear();
        getWebElement(submitButton).click();
    }

    public boolean isOnTopErrorMessageDisplayed() {
        return !DriverManager.getDriver().findElements(errorMessage).isEmpty();
    }

    public String getErrorMessage() {
        return getWebElement(errorMessage).getText();
    }

    public String getInlineErrorMessageInvalidResetTokenField() {
        return getWebElement(errorResetTokenMessage).getText();
    }

    public String getInlineErrorMessageConfirmPasswordField() {
        return getWebElement(errorConfirmPasswordMessage).getText();
    }
}