package com.example.pages;

import com.example.Constant.Constant;
import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    private final By actualWelcomeMessage = By.xpath("//strong[//*[contains(text(), 'Welcome')]]");

    private WebElement getWelcomeMessage() {
        return DriverManager.getDriver().findElement(actualWelcomeMessage);
    }

    public String welcomeText() {
        return getWelcomeMessage().getText();
    }

}
