package com.railway.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By welcomeMessage = By.xpath("//strong[//*[contains(text(), 'Welcome')]]");

    public String welcomeText() {
        return getWebElement(welcomeMessage).getText();
    }

}
