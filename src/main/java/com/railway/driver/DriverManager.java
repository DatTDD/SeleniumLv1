package com.railway.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    private static final ThreadLocal<WebDriver> _driver = new ThreadLocal<>();

    public static void createDriver() {
        if (_driver.get() == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--disable-web-security");

//            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            WebDriver newDriver = new ChromeDriver();
            newDriver.manage().window().maximize();
            _driver.set(newDriver);
        }
    }

    public static WebDriver getDriver() {
        return _driver.get();
    }

    public static void quitDriver() {
        if (_driver.get() != null) {
            _driver.get().quit();
            _driver.remove();
        }
    }

}