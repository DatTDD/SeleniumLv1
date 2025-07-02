package com.tests.base;

import com.railway.driver.DriverManager;
import com.railway.extentreport.ExtentTestManager;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestBase {

    @BeforeMethod
    public void beforeTest() {
        DriverManager.createDriver();
        DriverManager.getDriver().get("http://saferailway.somee.com");
    }

    @AfterMethod
    public void after(ITestResult result) {
        // Ghi log và lưu report của test case

        // Đóng trình duyệt
        DriverManager.quitDriver();
    }

}