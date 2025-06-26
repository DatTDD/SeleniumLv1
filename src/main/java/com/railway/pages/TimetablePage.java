package com.railway.pages;

import com.railway.constant.Constant;
import com.railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends BasePage {
    private final By timetableTabBy = By.xpath("//a[span='Timetable']");
    private final String bookTicketButtonStr = "//tr[td[text()='%s']//following-sibling::td[text()='%s']]//a[text() ='book ticket']";


    private WebElement loginTab() {
        return DriverManager.getDriver().findElement(timetableTabBy);
    }


    private WebElement getBookTicketButton(String departFrom, String arriveAt) {
        return DriverManager.getDriver().findElement(By.xpath(String.format(bookTicketButtonStr,departFrom,  arriveAt )));
    }

    public void goToTimetableTab() {
        loginTab().click();
    }

    public void bookTicketButton(String departFrom, String arriveAt) {
        getBookTicketButton(departFrom, arriveAt).click();
    }
}