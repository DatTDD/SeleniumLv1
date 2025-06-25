package com.railway.common;

import com.railway.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;

public class Common {
    public void scrollToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
