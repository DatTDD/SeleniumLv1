package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://saferailway.somee.com/Page/HomePage.cshtml");

        // Đi đến Login
        WebElement loginmenu = driver.findElement(By.xpath("//a[span='Login']"));
        loginmenu.click();

        // Điền form Login
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit'][value='login']"));

        usernameInput.sendKeys("dattdd129@gmail.com");
        passwordInput.sendKeys("12345678");

        loginButton.click();

        // Kiểm tra sau khi đăng nhập thành công
        System.out.println("Kiểm tra sau khi đăng nhập thành công");


        WebElement Changepassword = driver.findElement(By.xpath("//a[span='Change password']"));
        WebElement Logout = driver.findElement(By.xpath("//a[span='Log out']"));

        if (Changepassword.isDisplayed() && Logout.isDisplayed()) {
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Đăng nhập thất bại.");
        }

        Logout.click();

        System.out.println("Kiểm tra sau khi đăng xuất thành công");

//        if (Changepassword.isDisplayed() && Logout.isDisplayed()) {
//            System.out.println("Đăng xuất thất bại.");
//        } else {
//            System.out.println("Đăng xuất thành công!");
//        }

        boolean isLoggedOut = driver.findElements(By.linkText("Change password")).isEmpty()
                && driver.findElements(By.linkText("Log out")).isEmpty();

        if (isLoggedOut && driver.getCurrentUrl().contains("HomePage.cshtml")) {
            System.out.println("Đăng xuất thành công");
        } else {
            System.out.println("Đăng xuất thất bại");
        }

        driver.quit();

    }
}