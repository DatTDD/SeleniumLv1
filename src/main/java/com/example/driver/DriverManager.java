package com.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class DriverManager {

    private static WebDriver _driver;

    public static void createDriver() {
        if (_driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--disable-web-security");
            _driver = new ChromeDriver(options);
            _driver.manage().window().maximize();
        }
    }

    public static void quitDriver() {
        getDriver().quit();
        _driver = null;
    }

    public static WebDriver getDriver() {
        return _driver;
    }

}
