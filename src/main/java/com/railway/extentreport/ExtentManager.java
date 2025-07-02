package com.railway.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class ExtentManager {
    private static ExtentReports extent;

    private ExtentManager() {}

    public static synchronized ExtentReports getInstance(String reportBaseName) {
        if (extent == null) {
            String timestamp  = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = "test-output/reports/" + reportBaseName + "_" + timestamp + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    public static synchronized void flush() {
        if (extent != null) extent.flush();
    }
}
