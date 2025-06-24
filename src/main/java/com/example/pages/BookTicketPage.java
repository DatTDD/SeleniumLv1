package com.example.pages;

import com.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage {

    private final By bookTicketTab = By.xpath("//a[span='Book ticket']");
    private final By departDateDropdownMenu = By.xpath("//select[@name='Date']");
    private final By departFromDropdownMenu = By.xpath("//select[@name='DepartStation']");
    private final By arriveAtDropdownMenu = By.xpath("//select[@name='ArriveStation']");
    private final By seatTypeDropdownMenu = By.xpath("//select[@name='SeatType']");
    private final By ticketAmountDropdownMenu= By.xpath("//select[@name='TicketAmount']");
    private final By bookTicketButton= By.xpath("//input[@type='submit'][@value='Book ticket']");

    private WebElement getBookTicketTab() {
        return DriverManager.getDriver().findElement(bookTicketTab);
    }

    private WebElement getDepartDateDropdownMenu() {
        return DriverManager.getDriver().findElement(departDateDropdownMenu );
    }

    private WebElement getDepartFromDropdownMenu(){
        return DriverManager.getDriver().findElement(departFromDropdownMenu);
    }

    private WebElement getArriveAtDropdownMenu() {
        return DriverManager.getDriver().findElement(arriveAtDropdownMenu);
    }

    private WebElement getSeatTypeDropdownMenu() {
        return DriverManager.getDriver().findElement(seatTypeDropdownMenu);
    }

    private WebElement getTicketAmountDropdownMenu() {
        return DriverManager.getDriver().findElement(ticketAmountDropdownMenu);
    }

    private WebElement getBookTicketButton() {
        return DriverManager.getDriver().findElement(bookTicketButton);
    }

    public void gotoBookTicketTab() {
        getBookTicketTab().click();
    }

    public void bookTicket() {

    }

    public void bookTicketButton() {
        getBookTicketButton().click();
    }

}
