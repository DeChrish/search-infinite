package tests;

import data.TestDataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.pages.BingSearch;
import tests.pages.YahooSearch;

/**
 * Unit test for simple App.
 */
public class YahooSearchTest extends BaseTest
{

    YahooSearch yahooSearch;

    @Test(dataProvider = "searchQueries",dataProviderClass = TestDataProviders.class)
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





}
