package com.example.pages;

import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage {

    private final By bookTicketTab = By.xpath("//a[span='Book ticket']");

    private WebElement getBookTicketTab() {
        return DriverManager.getDriver().findElement(bookTicketTab);
    }

    public void gotoBookTicketTab(){
        getBookTicketTab().click();
    }

}
