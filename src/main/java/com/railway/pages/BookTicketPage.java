package com.railway.pages;

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

    private void waitForArriveAtUpdate() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        wait.until(driver -> {
            Select select = new Select(arriveAtDropdownMenu());
            String selectedOption = select.getFirstSelectedOption().getText();
            return selectedOption.equals("Sài Gòn");
        });
    }

    public void gotoBookTicketTab() {
        getBookTicketTabBy().click();
    }

    public void bookTicket(String departdate, String departfrom, String arriveat, String seattype, String amout) {
        Select select = new Select(departDateDropdownMenu());
        Select selectDepartFrom = new Select(departFromDropdownMenu());
        Select selectSeatType = new Select(seatTypeDropdownMenu());
        Select selectTicketAmount = new Select(ticketAmountDropdownMenu());

        select.selectByVisibleText(departdate);
        selectDepartFrom.selectByVisibleText(departfrom);

        waitForArriveAtUpdate();

        Select selectArriveAt = new Select(arriveAtDropdownMenu());
        selectArriveAt.selectByVisibleText(arriveat);

        selectSeatType.selectByVisibleText(seattype);
        selectTicketAmount.selectByVisibleText(amout);
        //bookTicketButton().click();
    }
}
