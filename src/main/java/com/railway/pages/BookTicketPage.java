package com.railway.pages;

import com.railway.common.Common;
import com.railway.constant.Constants;
import com.railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends BasePage {

    private final By departDateDropdownMenu = By.xpath("//select[@name='Date']");
    private final By departFromDropdownMenu = By.xpath("//select[@name='DepartStation']");
    private final By arriverAtDropdownMenu = By.xpath("//select[@name='ArriveStation']");
    private final By seatTypeDropdownMenu = By.xpath("//select[@name='SeatType']");
    private final By ticketAmountDropdownMenu = By.xpath("//select[@name='TicketAmount']");
    private final By bookTicketButton = By.xpath("//input[@type='submit'][@value='Book ticket']");
    private final By successfulBookingMessage = By.xpath("//h1[text()='Ticket booked successfully!']");
    private By departDateInforBookedTicket = By.xpath(String.format("//td[text()='%s']", Constants.BookTicket.DEPART_DATE));
    private By departFromInforBookedTicket = By.xpath(String.format("//td[text()='%s']", Constants.BookTicket.DEPART_FROM));
    private By arriverAtInforBookedTicket = By.xpath(String.format("//td[text()='%s']", Constants.BookTicket.ARRIVER_AT));
    private By seatTypeInforBookedTicket = By.xpath(String.format("//td[text()='%s']", Constants.BookTicket.SEAT_TYPE));
    private By ticketAmountInforBookedTicket = By.xpath(String.format("//td[text()='%s']", Constants.BookTicket.TICKET_AMOUNT));

    public void bookTicket(String departdate, String departfrom, String arriveat, String seattype, String amout) {
        Select selectDepartDate = new Select(getWebElement(departDateDropdownMenu));
        Select selectDepartFrom = new Select(getWebElement(departFromDropdownMenu));
        Select selectSeatType = new Select(getWebElement(seatTypeDropdownMenu));
        Select selectTicketAmount = new Select(getWebElement(ticketAmountDropdownMenu));

        selectDepartDate.selectByVisibleText(departdate);
        selectDepartFrom.selectByVisibleText(departfrom);

        Common.waitDropdownValue(arriverAtDropdownMenu, arriveat, 3);
        Select selectArriveAt = new Select(getWebElement(arriverAtDropdownMenu));
        selectArriveAt.selectByVisibleText(arriveat);

        selectSeatType.selectByVisibleText(seattype);
        selectTicketAmount.selectByVisibleText(amout);
        getWebElement(bookTicketButton).click();
    }

    public String getSelectedDepartFromValue() {
        return getWebElement(departFromDropdownMenu).getText();
    }

    public String getSelectedArriveAtValue() {
        return getWebElement(arriverAtDropdownMenu).getText();
    }

    public String getSuccessfulBookingMessage() {
        return getWebElement(successfulBookingMessage).getText();
    }

    public String getDepartDateInforBookedTicket() {
        return getWebElement(departDateInforBookedTicket).getText();
    }

    public String getDepartFromInforBookedTicket() {
        return getWebElement(departFromInforBookedTicket).getText();
    }

    public String getArriverAtInforBookedTicket() {
        return getWebElement(arriverAtInforBookedTicket).getText();
    }

    public String getSeatTypeInforBookedTicket() {
        return getWebElement(seatTypeInforBookedTicket).getText();
    }

    public String ticketAmountInforBookedTicket() {
        return getWebElement(ticketAmountInforBookedTicket).getText();
    }

}
