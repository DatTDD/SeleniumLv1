package com.railway.pages;

import com.railway.constant.Constants;
import com.railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    private final String tabXpath = "//a//span[text()='%s']";

    private WebElement getTab(String tab) {
        return DriverManager.getDriver().findElement(By.xpath(String.format(tabXpath, tab)));
    }

    protected static WebElement getWebElement(By element) {
        return DriverManager.getDriver().findElement(element);
    }

    public boolean isMyTicketTabDisplayed() {
        return getTab(Constants.MenuBar.MY_TICKET).isDisplayed();
    }

    public boolean isChangePasswordTabDisplayed() {
        return getTab(Constants.MenuBar.CHANGE_PASSWORD).isDisplayed();
    }

    public boolean isLogOutTabDisplayed() {
        return getTab(Constants.MenuBar.LOGOUT).isDisplayed();
    }

    public void clickOnTab(String tabName) {
        getTab(tabName).click();
    }

}