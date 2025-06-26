package com.railway.pages;

import com.railway.constant.Constant;
import com.railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.dnd.DropTarget;
import java.time.Duration;
import java.util.List;

public class MyTicketPage extends BasePage {

    private final By myTicketTabBy = By.xpath("//a[span='My ticket']");
    private final By myticketTitleBy = By.xpath("//h1[text()='Manage ticket']");
    private String cancelTicketButtonStr = "//tr[td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']]//input[@value = 'Cancel']";
    private final By departStationFilterDropdownMenuBy = By.xpath("//select[@name='FilterDpStation']");
    private final By arriveStationFilterDropdownMenuBy = By.xpath("//select[@name='FilterArStation']");
    private final By departDateTextBox = By.xpath("//input[@name='FilterDpDate']");
    private final By statusFilterDropdownMenuBy = By.xpath("//select[@name='FilterStatus']");
    private final By applyFilterButtonBy = By.xpath("//input[@type='submit'][@value= 'Apply filter']");
    private final By tableRowsBy = By.xpath("//table[@class='MyTable']//tbody//tr");

    private WebElement myTicketTab() {
        return DriverManager.getDriver().findElement(myTicketTabBy);
    }

    private WebElement myTicketTitle() {
        return DriverManager.getDriver().findElement(myticketTitleBy);
    }

    private WebElement getCancelTicketButton(String departStation, String arriveStation, String seatType, String departDate, String amount) {
        return DriverManager.getDriver().findElement(By.xpath(String.format(cancelTicketButtonStr, Constant.BookTicket.DEPART_FROM, Constant.BookTicket.ARRIVER_AT, Constant.BookTicket.SEAT_TYPE, Constant.BookTicket.DEPART_DATE, Constant.BookTicket.TICKET_AMOUNT)));
    }

    private WebElement departStationFilterDropdownMenu() {
        return DriverManager.getDriver().findElement(departStationFilterDropdownMenuBy);
    }

    private WebElement arriveStationFilterDropdownMenu() {
        return DriverManager.getDriver().findElement(arriveStationFilterDropdownMenuBy);
    }

    private WebElement departDateTextBox() {
        return DriverManager.getDriver().findElement(departDateTextBox);
    }

    private WebElement statusFilterDropdownMenu() {
        return DriverManager.getDriver().findElement(statusFilterDropdownMenuBy);
    }

    private WebElement applyFilterButton() {
        return DriverManager.getDriver().findElement(applyFilterButtonBy);
    }

    public void goToMyTicketTab() {
        myTicketTab().click();
    }

    public String myTicketTitleText() {
        return myTicketTitle().getText();
    }

    public void cancelTicket(String departStation, String arriveStation, String seatType, String departDate, String amount) {
        getCancelTicketButton(departStation, arriveStation, seatType, departDate, amount).click();
    }

    public void acceptCancelAlert() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (Exception e) {
            System.out.println("Cannot find Cancel alert " + e.getMessage());
        }
    }

    public void useFilterToSearchTicket(String departStation, String arriveStation, String departDate, String status) {
        Select selectDepartStation = new Select(departStationFilterDropdownMenu());
        Select selectArriveStation = new Select(arriveStationFilterDropdownMenu());
        Select selectStatus = new Select(statusFilterDropdownMenu());

        selectDepartStation.selectByVisibleText(departStation);
        selectArriveStation.selectByVisibleText(arriveStation);
        departDateTextBox().sendKeys(departDate);
        selectStatus.selectByVisibleText(status);
        applyFilterButton().click();
    }

    public int getNumberOfTicketRows() {
        List<WebElement> rows = DriverManager.getDriver().findElements(tableRowsBy);
        return rows.size();
    }


}
