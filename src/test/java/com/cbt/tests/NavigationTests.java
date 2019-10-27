package com.cbt.tests;

import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

import static com.cbt.utilities.BrowserFactory.getDriver;

public class NavigationTests {

    public static void main(String[] args) {
        // 1- Test 1 with CHROME
        navigationTest("chrome");

        // 2- Test 1 with FIREFOX
        navigationTest("firefox");

        // 3- Test 1 with SAFARI
        navigationTest("safari");




    }


    public static void navigationTest(String browser){
        // 1.Open	browser
        WebDriver driver  = getDriver(browser);

        // 2.Go	to	website	https://google.com
        String url_1 = "https://google.com";
        driver.get(url_1);

        // 3.Save the title in a string variable
        String title_1 = driver.getTitle();

        // 4.Go to https://etsy.com
        String url_2 = "https://etsy.com";
        driver.get(url_2);

        // 5.Save the title in a string variable
        String title_2 = driver.getTitle();

        // 6.Navigate back to previous page
        driver.navigate().back();

        // 7.Verify that title is same is in step3
        StringUtility.verifyEquals(title_1, driver.getTitle());

        // 8.Navigate forward to previous page
        driver.navigate().forward();

        // 9.Verify that title is same is in step 5
        StringUtility.verifyEquals(title_2,driver.getTitle());

        driver.quit();
    }
}
