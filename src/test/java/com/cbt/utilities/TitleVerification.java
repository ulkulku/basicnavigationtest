package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;


public class TitleVerification {

    public static void main(String[] args) {
        // 2.Add this ArrayList declaration to the main method
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                                          "http://practice.cybertekschool.com/dropdown",
                                          "http://practice.cybertekschool.com/login");

        // 3.Open chrome browser
        WebDriver driver = BrowserFactory.getDriver("chrome");

        // 4.Visit all the websitesfrom step 3 and verify that they all have the same title.

        String title;
        driver.get(urls.get(0));
        title = driver.getTitle(); // title = 1st url's title (home)

        driver.get(urls.get(1));
        StringUtility.verifyEquals(title , driver.getTitle()) ;   // verify if the 1st and 2nd urls' titles are the same
        driver.get(urls.get(2));
        StringUtility.verifyEquals(title, driver.getTitle());   // verify if the 1st and 3rd urls' titles are the same

        title =driver.getTitle(); // title =3rd url's title (login)

        driver.navigate().back();
        StringUtility.verifyEquals(title, driver.getTitle() );  // verify if the 3rd and 2nd urls' titles are the same

        // 5.Verify that all URLs of all pages start with http://practice.cybertekschool.com.
        driver.get(urls.get(0));
        isURLStartsWith(driver.getCurrentUrl());

        driver.get(urls.get(1));
        isURLStartsWith(driver.getCurrentUrl());

        driver.get(urls.get(2));
        isURLStartsWith(driver.getCurrentUrl());

        // 6.Close the browser at the end of the test.
        driver.close();

    }


    public static void isURLStartsWith(String currentURL){
        String startURLWith = "http://practice.cybertekschool.com";

        if(currentURL.startsWith(startURLWith)) {
            System.out.println("PASS: 1st URL starts with " + startURLWith );
        }else {
            System.out.println("FAIL: 1st URL does not start with " + startURLWith );
        }
    }
}
