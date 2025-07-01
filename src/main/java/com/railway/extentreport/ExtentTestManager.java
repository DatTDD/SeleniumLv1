package com.railway.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestManager {
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private ExtentTestManager() {}

    public static synchronized void startTest(String testName) {
        ExtentReports report = ExtentManager.getInstance("ExtentReport");
        test.set(report.createTest(testName));
    }

    public static ExtentTest getTest() {
        return test.get();
    }
}