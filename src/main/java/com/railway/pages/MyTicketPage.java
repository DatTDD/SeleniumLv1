package com.railway.pages;

import com.railway.constant.Constants;
import com.railway.dataobject.Ticket;
import com.railway.driver.DriverManager;
import com.railway.utility.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class MyTicketPage extends BasePage {
    private final By myticketTitle = By.xpath("//h1[text()='Manage ticket']");
    private String cancelTicketButtonStr = "//tr[td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td[text()='%s']]//input[@value = 'Cancel']";
    private final By departStationFilterDropdownMenu = By.xpath("//select[@name='FilterDpStation']");
    private final By arriveStationFilterDropdownMenu = By.xpath("//select[@name='FilterArStation']");
    private final By departDateTextBox = By.xpath("//input[@name='FilterDpDate']");
    private final By statusFilterDropdownMenu = By.xpath("//select[@name='FilterStatus']");
    private final By applyFilterButton = By.xpath("//input[@type='submit'][@value= 'Apply filter']");
    private final By tableRows = By.xpath("//table[@class='MyTable']//tbody//tr");

    public String getMyTicketTitle() {
        return getWebElement(myticketTitle).getText();
    }

    public void cancelTicket(Ticket ticket) {
        getWebElement(By.xpath(String.format(cancelTicketButtonStr,ticket.getDepartStation(), ticket.getArriveStation(), ticket.getSeatType(), ticket.getDepartDate(), ticket.getTicketAmount() ))).click();
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
        Select selectDepartStation = new Select(getWebElement(departStationFilterDropdownMenu));
        Select selectArriveStation = new Select(getWebElement(arriveStationFilterDropdownMenu));
        Select selectStatus = new Select(getWebElement(statusFilterDropdownMenu));

        selectDepartStation.selectByVisibleText(departStation);
        selectArriveStation.selectByVisibleText(arriveStation);
        getWebElement(departDateTextBox).sendKeys(departDate);
        selectStatus.selectByVisibleText(status);
        getWebElement(applyFilterButton).click();
    }

    public int getNumberOfTicketRows() {
        List<WebElement> rows = DriverManager.getDriver().findElements(tableRows);
        return rows.size();
    }

}
