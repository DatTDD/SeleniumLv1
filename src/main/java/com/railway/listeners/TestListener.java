package com.railway.listeners;

import com.railway.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String methodName = result.getMethod().getMethodName();
            String filename = "screenshot_" + methodName + "_" + timestamp + ".png";
            File destFile = new File("screenshots/" + filename);

            // Tạo thư mục nếu chưa tồn tại
            File directory = destFile.getParentFile();
            if (!directory.exists() && !directory.mkdirs()) {
                System.err.println("Failed to create screenshot directory: " + directory.getAbsolutePath());
                return;
            }

            try {
                com.google.common.io.Files.copy(srcFile, destFile);
                System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Failed to save screenshot: " + e.getMessage());
            }
        }
    }
}
