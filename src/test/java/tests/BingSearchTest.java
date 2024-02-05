package tests;

import data.TestDataProviders;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.BasePage;
import pages.BingSearch;
import org.testng.Assert;
import utils.Listeners.TestListeners;

/**
 * Unit test for simple App.
 */
@Listeners({TestListeners.class})
public class BingSearchTest
{
    public WebDriver driver;
    BingSearch bingSearch ;
    BasePage basePage;
    @BeforeMethod
    @Parameters({"browser", "hubUrl"})
    public void setUp(@Optional("chrome") String browser, @Optional("http://localhost:4444/wd/hub") String hubUrl) {
        basePage = new BasePage();
        driver = basePage.initDriver(browser,hubUrl);
        bingSearch = new BingSearch(driver);
    }



    @Test(dataProvider = "searchQueries",dataProviderClass = TestDataProviders.class)
    @Description("Test Description: Search scenario with valid search query")
    public void verify_valid_search_results(String searchQuery) {
        bingSearch.openweb("https://www.bing.com");
        bingSearch.waitForSync();
        bingSearch.performSearch(searchQuery);
        bingSearch.waitForSync();
        String resultFirstLinkText = bingSearch.getResultFirstLinkText();
        Assert.assertTrue(resultFirstLinkText.contains(searchQuery), "Search failed on Bing");

    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}
