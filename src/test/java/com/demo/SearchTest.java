package com.demo;

import com.utils.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class SearchTest extends BaseClass
{

    @AfterClass
    public void tearDown() {
        // Close the WebDriver instance
        quitDriver();
    }

    public SearchTest(String browserType) {
        super("chrome");
    }


    @Test
    public void verify_valid_search_results() {
        // Your Selenium test logic
        driver.get("https://www.google.com/");
        // Add assertions or other verification logic as needed
    }


}
