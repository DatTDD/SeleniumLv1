package com.railway.common;

import com.railway.driver.DriverManager;
import com.railway.extentreport.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class Common {
    public void scrollToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public String createMail(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString() + "@gmail.com";
    }

    public static void waitDropdownValue(By dropdownBy, String expectedText, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        try {
            wait.until(driver -> {
                Select select = new Select(driver.findElement(dropdownBy));
                String selectedText = select.getFirstSelectedOption().getText();
                return selectedText.equals(expectedText);
            });
        } catch (TimeoutException e) {
        }
    }

    public void logExpectedAndActual(String label, String expected, String actual) {
        ExtentTestManager.getTest().info("Expected " + label + ": " + expected);
        ExtentTestManager.getTest().info("Actual " + label + ": " + actual);
    }

    public void logGroupedComparison(List<String> expected, List<String> actual) {
        ExtentTestManager.getTest().info("Expected: " + expected);
        ExtentTestManager.getTest().info("Actual:   " + actual);
    }

//    public String generateDepartDate(int offsetDays) {
////        int offsetDays = Integer.parseInt(data.get("departDate").asText());
////        LocalDate date = LocalDate.now().plusDays(offsetDays + 3);
////        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
////        String departDate = date.format(formatter);
//        LocalDate date = LocalDate.now().plusDays(3);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
//        return date.format(formatter);
//    }

}
