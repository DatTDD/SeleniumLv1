package com.railway.pages;

import com.railway.driver.DriverManager;
import com.railway.utility.MailBox;
import org.openqa.selenium.By;

public class ForgotPasswordPage extends BasePage {

    private final By emailAddressTextBox = By.id("email");
    private final By sendInstructionsButton = By.xpath("//input[@type='submit'][@value='Send Instructions']");


    public void sendInstructions(String email) {
        getWebElement(emailAddressTextBox).sendKeys(email);
        getWebElement(sendInstructionsButton).click();
    }

    public void goToMailBox() {
        DriverManager.getDriver().get(MailBox.getMailBoxURL());
    }
}
