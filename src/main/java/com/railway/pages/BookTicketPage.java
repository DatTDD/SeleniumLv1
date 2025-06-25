package com.railway.pages;

import com.railway.constant.Constant;
import com.railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class BookTicketPage {

    private final By bookTicketTabBy = By.xpath("//a[span='Book ticket']");
    private final By departDateDropdownMenuBy = By.xpath("//select[@name='Date']");
    private final By departFromDropdownMenuBy = By.xpath("//select[@name='DepartStation']");
    private final By arriveAtDropdownMenuBy = By.xpath("//select[@name='ArriveStation']");
    private final By seatTypeDropdownMenuBy = By.xpath("//select[@name='SeatType']");
    private final By ticketAmountDropdownMenuBy = By.xpath("//select[@name='TicketAmount']");
    private final By bookTicketButtonBy = By.xpath("//input[@type='submit'][@value='Book ticket']");
    private final By successfulBookingMessageBy = By.xpath("//h1[text()='Ticket booked successfully!']");
    private By departDateInforBookedTicketdBy = By.xpath(String.format("//td[text()='%s']", Constant.BookTicket.DEPART_DATE));
    private By departFromInforBookedTicketdBy = By.xpath(String.format("//td[text()='%s']", Constant.BookTicket.DEPART_FROM));
    private By arriverAtInforBookedTicketdBy = By.xpath(String.format("//td[text()='%s']", Constant.BookTicket.ARRIVER_AT));
    private By seatTypeInforBookedTicketdBy = By.xpath(String.format("//td[text()='%s']", Constant.BookTicket.SEAT_TYPE));
    private By ticketAmountInforBookedTicketdBy = By.xpath(String.format("//td[text()='%s']", Constant.BookTicket.TICKET_AMOUNT));


    private WebElement getBookTicketTabBy() {
        return DriverManager.getDriver().findElement(bookTicketTabBy);
    }

    private WebElement departDateDropdownMenu() {
        return DriverManager.getDriver().findElement(departDateDropdownMenuBy);
    }

    private WebElement departFromDropdownMenu(){
        return DriverManager.getDriver().findElement(departFromDropdownMenuBy);
    }

    private WebElement arriveAtDropdownMenu() {
        return DriverManager.getDriver().findElement(arriveAtDropdownMenuBy);
    }

    private WebElement seatTypeDropdownMenu() {
        return DriverManager.getDriver().findElement(seatTypeDropdownMenuBy);
    }

    private WebElement ticketAmountDropdownMenu() {
        return DriverManager.getDriver().findElement(ticketAmountDropdownMenuBy);
    }

    private WebElement bookTicketButton() {
        return DriverManager.getDriver().findElement(bookTicketButtonBy);
    }

    private WebElement successfulBookingMessageText() {
        return DriverManager.getDriver().findElement(successfulBookingMessageBy);
    }

    private WebElement departDateInforBookedTicketText(){
        return DriverManager.getDriver().findElement(departDateInforBookedTicketdBy);
    }

    private WebElement departFromInforBookedTicketText() {
        return DriverManager.getDriver().findElement(departFromInforBookedTicketdBy);
    }

    private WebElement arriverAtInforBookedTicketText(){
        return DriverManager.getDriver().findElement(arriverAtInforBookedTicketdBy);
    }

    private WebElement seatTypeInforBookedTicketText(){
        return DriverManager.getDriver().findElement(seatTypeInforBookedTicketdBy);
    }

    private WebElement ticketAmountInforBookedTicketText(){
        return DriverManager.getDriver().findElement(ticketAmountInforBookedTicketdBy);
    }

    public void goToBookTicketTab() {
        getBookTicketTabBy().click();
    }

    public void bookTicket(String departdate, String departfrom, String arriveat, String seattype, String amout) {
        Select select = new Select(departDateDropdownMenu());
        Select selectDepartFrom = new Select(departFromDropdownMenu());
        Select selectSeatType = new Select(seatTypeDropdownMenu());
        Select selectTicketAmount = new Select(ticketAmountDropdownMenu());

        select.selectByVisibleText(departdate);
        selectDepartFrom.selectByVisibleText(departfrom);

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        wait.until(driver -> true);

        Select selectArriveAt = new Select(arriveAtDropdownMenu());
        selectArriveAt.selectByVisibleText(arriveat);

        selectSeatType.selectByVisibleText(seattype);
        selectTicketAmount.selectByVisibleText(amout);
        bookTicketButton().click();
    }

    public String successfulBookingMessage() {
        return successfulBookingMessageText().getText();
    }

    public String departDateInforBookedTicket() {
        return departDateInforBookedTicketText().getText();
    }

    public String departFromInforBookedTicket() {
        return departFromInforBookedTicketText().getText();
    }

    public String arriverAtInforBookedTicket() {
        return arriverAtInforBookedTicketText().getText();
    }

    public String seatTypeInforBookedTicket() {
        return seatTypeInforBookedTicketText().getText();
    }

    public String ticketAmountInforBookedTicket() {
        return ticketAmountInforBookedTicketText().getText();
    }


}
