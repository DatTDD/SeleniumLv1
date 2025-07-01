package com.railway.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.railway.driver.DriverManager;
import com.railway.extentreport.ExtentManager;
import com.railway.extentreport.ExtentTestManager;
import com.railway.utility.LogUtils;

import org.openqa.selenium.*;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    /** Tên gốc của file report; ExtentManager sẽ thêm time‑stamp */
    private static final String REPORT_NAME = "ExtentReport";

    /* ========== SUITE ========== */
    @Override
    public void onStart(ITestContext context) {
        LogUtils.info("===== SUITE STARTED: " + context.getName() + " =====");
        // Khởi tạo report duy nhất cho suite
        ExtentManager.getInstance(REPORT_NAME);
    }

    @Override
    public void onFinish(ITestContext context) {
        LogUtils.info("===== SUITE FINISHED: " + context.getName() + " =====");
        ExtentManager.flush();              // ghi file html
    }

    /* ========== TEST METHOD ========== */
    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        LogUtils.info("START TEST: " + testName);
        ExtentTestManager.startTest(testName);        // tạo node mới
        ExtentTestManager.getTest().info("Test started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("Test PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentTestManager.getTest().fail("Test failed: " + result.getThrowable());
        LogUtils.error("FAILED: " + methodName);

        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            try {
                // Định nghĩa thời gian để đặt tên file ảnh
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName = methodName + "_" + timestamp + ".png";

                // Đường dẫn tuyệt đối để lưu ảnh
                String screenshotDir = System.getProperty("user.dir") + "/test-output/screenshots";
                File destFile = new File(screenshotDir, fileName);
                destFile.getParentFile().mkdirs();

                // Lưu ảnh
                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                com.google.common.io.Files.copy(srcFile, destFile);
                LogUtils.info("Screenshot saved to: " + destFile.getAbsolutePath());

                // Đường dẫn tương đối từ HTML report (nằm trong test-output/reports/)
                String relativePath = "../screenshots/" + fileName;

                // Gắn ảnh vào báo cáo
                ExtentTestManager.getTest().fail("Screenshot on failure",
                        MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());

            } catch (IOException e) {
                LogUtils.error("Failed to save screenshot: " + e.getMessage());
            }
        } else {
            LogUtils.warn("WebDriver is null. Screenshot was not taken.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip("Test skipped: " + result.getSkipCausedBy());
    }

    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult r) { }
    @Override public void onTestFailedWithTimeout(ITestResult r) { }
}