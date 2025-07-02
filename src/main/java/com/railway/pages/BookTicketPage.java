package com.railway.pages;

import com.railway.common.Common;
import com.railway.dataobject.Ticket;
import com.railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookTicketPage extends BasePage {

    private final By departDateDropdownMenu = By.xpath("//select[@name='Date']");
    private final By departFromDropdownMenu = By.xpath("//select[@name='DepartStation']");
    private final By arriverAtDropdownMenu = By.xpath("//select[@name='ArriveStation']");
    private final By seatTypeDropdownMenu = By.xpath("//select[@name='SeatType']");
    private final By ticketAmountDropdownMenu = By.xpath("//select[@name='TicketAmount']");
    private final By bookTicketButton = By.xpath("//input[@type='submit'][@value='Book ticket']");
    private final By successfulBookingMessage = By.xpath("//h1[text()='Ticket booked successfully!']");
    private String ticketInfo = "//tr[td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']]";


    public void bookTicket(Ticket ticket) {
        Select selectDepartDate = new Select(getWebElement(departDateDropdownMenu));
        Select selectDepartFrom = new Select(getWebElement(departFromDropdownMenu));
        Select selectSeatType = new Select(getWebElement(seatTypeDropdownMenu));
        Select selectTicketAmount = new Select(getWebElement(ticketAmountDropdownMenu));

        selectDepartDate.selectByVisibleText(ticket.getDepartDate());
        selectDepartFrom.selectByVisibleText(ticket.getDepartStation());

        Common.waitDropdownValue(arriverAtDropdownMenu, ticket.getArriveStation(),5);
        Select selectArriveAt = new Select(getWebElement(arriverAtDropdownMenu));
        selectArriveAt.selectByVisibleText(ticket.getArriveStation());

        selectSeatType.selectByVisibleText(ticket.getSeatType());
        selectTicketAmount.selectByVisibleText(ticket.getTicketAmount());
        getWebElement(bookTicketButton).click();
    }

    public String getSelectedDepartFromValue() {
        Select select = new Select(getWebElement(departFromDropdownMenu));
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedArriveAtValue() {
        Select select = new Select(getWebElement(arriverAtDropdownMenu));
        return select.getFirstSelectedOption().getText();
    }

    public String getSuccessfulBookingMessage() {
        return getWebElement(successfulBookingMessage).getText();
    }

    public int getTicketInfo(Ticket ticket) {
        return DriverManager.getDriver().findElements(By.xpath(String.format(ticketInfo, ticket.getDepartStation(), ticket.getArriveStation(), ticket.getSeatType(), ticket.getDepartDate(), ticket.getTicketAmount()))).size();
    }


}