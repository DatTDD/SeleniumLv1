package com.example.pages;

import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage {

    private final By MyTicketTab = By.xpath("//a[span='My ticket']");

    private WebElement getMyTicketTab() {
        return DriverManager.getDriver().findElement(MyTicketTab);
    }

    public void gotoMyticketTab() {
        getMyTicketTab().click();
    }
}
