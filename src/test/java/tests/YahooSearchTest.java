package tests;

import data.TestDataProviders;
import io.qameta.allure.Description;
import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.GoogleSearch;
import pages.YahooSearch;
import utils.Listeners.TestListeners;

/**
 * Unit test for simple App.
 */
@Listeners({TestListeners.class})
public class YahooSearchTest {

    public WebDriver driver;
    YahooSearch yahooSearch;
    BasePage basePage;
    @BeforeMethod
    @Parameters({"browser", "hubUrl"})
    public void setUp(@Optional("chrome") String browser, @Optional("http://localhost:4444/wd/hub") String hubUrl) {
        basePage = new BasePage();
        driver = basePage.initDriver(browser,hubUrl);
        yahooSearch = new YahooSearch(driver);
    }

    @Test(dataProvider = "searchQueries",dataProviderClass = TestDataProviders.class)
    @Description("Test Description: Search scenario with valid search query")

    public void verify_valid_search_results(String searchQuery) {
        SoftAssert softAssert = new SoftAssert();
        yahooSearch = new YahooSearch(driver);
        yahooSearch.openweb("https://www.yahoo.com");
        yahooSearch.waitForSync();
        yahooSearch.performSearch(searchQuery);
        yahooSearch.waitForSync();
        String resultFirstLinkText = yahooSearch.getResultFirstLinkText();
        softAssert.assertTrue(resultFirstLinkText.contains(searchQuery), "Search failed on Yahoo");
        softAssert.assertAll();
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}
