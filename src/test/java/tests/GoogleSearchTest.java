package tests;

import data.TestDataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import tests.pages.BingSearch;
import tests.pages.GoogleSearch;

/**
 * Unit test for simple App.
 */
public class GoogleSearchTest extends BaseTest
{

    GoogleSearch googleSearch ;

    @Test(dataProvider = "searchQueries",dataProviderClass = TestDataProviders.class)
    public void verify_valid_search_results(String searchQuery) {

        googleSearch = new GoogleSearch(driver);
        googleSearch.openweb("https://www.google.com");
        googleSearch.waitForSync();
        googleSearch.performSearch(searchQuery);
        googleSearch.waitForSync();
        String resultFirstLinkText = googleSearch.getResultFirstLinkText();
        Assert.assertTrue(resultFirstLinkText.contains(searchQuery), "Search failed on Google");
    }

    @Test(dataProvider = "splCharQueries",dataProviderClass = TestDataProviders.class)
    public void verify_invalid_search_results(String searchQuery) {

        googleSearch = new GoogleSearch(driver);
        googleSearch.openweb("https://www.google.com");
        googleSearch.waitForSync();
        googleSearch.performSearch(searchQuery);
        googleSearch.waitForSync();
        String resultErrorMessageText = googleSearch.getResultErrorMessageText();
        String expectedText = "Your search - "+searchQuery+" - did not match any documents.";
        Assert.assertEquals(expectedText, resultErrorMessageText, "Search result message does not contain the expected text.");

    }



}
