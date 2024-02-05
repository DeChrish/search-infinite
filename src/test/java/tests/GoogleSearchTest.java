package tests;

import data.TestDataProviders;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.BingSearch;
import pages.GoogleSearch;
import utils.Listeners.TestListeners;

/**
 * Unit test for simple App.
 */
@Listeners({TestListeners.class})
public class GoogleSearchTest
{
    public WebDriver driver;
    GoogleSearch googleSearch ;

    BasePage basePage;
    @BeforeMethod
    @Parameters({"browser", "hubUrl"})
    public void setUp(@Optional("chrome") String browser, @Optional("http://localhost:4444/wd/hub") String hubUrl) {
        basePage = new BasePage();
        driver = basePage.initDriver(browser,hubUrl);
        googleSearch = new GoogleSearch(driver);
    }

    @Test(dataProvider = "searchQueries",dataProviderClass = TestDataProviders.class)
    @Description("Test Description: Search scenario with valid search query")
    @Story("Story Name: To check login page title 1")
    public void verify_valid_search_results(String searchQuery) {
        googleSearch.openweb("https://www.google.com");
        googleSearch.waitForSync();
        googleSearch.performSearch(searchQuery);
        googleSearch.waitForSync();
        String resultFirstLinkText = googleSearch.getResultFirstLinkText();
        Assert.assertTrue(resultFirstLinkText.contains(searchQuery), "Search failed on Google");
    }

    @Test(dataProvider = "splCharQueries",dataProviderClass = TestDataProviders.class)
    @Description("Test Description: Search scenario with invalid search query")
    @Story("Story Name: To check login page title 2")
    public void verify_invalid_search_results(String searchQuery) {
        googleSearch.openweb("https://www.google.com");
        googleSearch.waitForSync();
        googleSearch.performSearch(searchQuery);
        googleSearch.waitForSync();
        String resultErrorMessageText = googleSearch.getResultErrorMessageText();
        String expectedText = "Your search - "+searchQuery+" - did not match any documents.";
        Assert.assertEquals(expectedText, resultErrorMessageText+"test", "Search result message does not contain the expected text.");

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}
