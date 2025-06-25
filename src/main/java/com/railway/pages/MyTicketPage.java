package com.railway.pages;

import com.railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage {

    private final By myTicketTabBy = By.xpath("//a[span='My ticket']");
    private final By myticketTitleBy = By.xpath("//h1[text()='Manage ticket']");


    private WebElement myTicketTab() {
        return DriverManager.getDriver().findElement(myTicketTabBy);
    }

    private WebElement myTicketTitle() {
        return DriverManager.getDriver().findElement(myticketTitleBy);
    }

    public void goToMyTicketTab() {
        myTicketTab().click();
    }

    public String myTicketTitleText() {
        return myTicketTitle().getText();
    }
}
