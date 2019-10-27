package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browser) {
        String os = System.getProperty("os.name");
        System.out.println("Your operating system is " + os);

        switch (browser.toLowerCase()) {
            case "safari":
                if(os.toLowerCase().contains("win")){
                    return null;
                }
                WebDriverManager.getInstance(SafariDriver.class).setup();
                return new SafariDriver();
            case "edge":
                if(os.toLowerCase().contains("mac")){
                    return null;
                }
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
        return null;
    }
}