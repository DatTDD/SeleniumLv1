package com.railway.pages;

import com.railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private final By welcomeMessageBy = By.xpath("//strong[//*[contains(text(), 'Welcome')]]");

    private WebElement welcomeMessage() {
        return DriverManager.getDriver().findElement(welcomeMessageBy);
    }

    public String welcomeText() {
        return welcomeMessage().getText();
    }

}
