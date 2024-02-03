package tests;

import data.TestDataProviders;
import tests.pages.BingSearch;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class BingSearchTest extends BaseTest
{

    BingSearch bingSearch ;

    @Test(dataProvider = "searchQueries",dataProviderClass = TestDataProviders.class)
    public void verify_valid_search_results(String searchQuery) {

        bingSearch = new BingSearch(driver);
        bingSearch.openweb("https://www.bing.com");
        bingSearch.waitForSync();
        bingSearch.performSearch(searchQuery);
        bingSearch.waitForSync();
        String resultFirstLinkText = bingSearch.getResultFirstLinkText();
        Assert.assertTrue(resultFirstLinkText.contains(searchQuery), "Search failed on Bing");

    }





}
