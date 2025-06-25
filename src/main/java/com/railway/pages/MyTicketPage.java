package com.railway.pages;

import com.railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage {

    private final By myTicketTab = By.xpath("//a[span='My ticket']");
    private final By myticketTitle = By.xpath("//h1[text()='Manage ticket']");


    private WebElement getMyTicketTab() {
        return DriverManager.getDriver().findElement(myTicketTab);
    }

    private WebElement getMyticketTitle() {
        return DriverManager.getDriver().findElement(myticketTitle);
    }

    public void gotoMyticketTab() {
        getMyTicketTab().click();
    }

    public String myticketTitleText() {
        return getMyticketTitle().getText();
    }
}
