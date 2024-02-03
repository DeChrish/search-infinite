package data;

import org.testng.annotations.DataProvider;

public class TestDataProviders {
    @DataProvider(name = "searchQueries")
    public Object[][] getSearchQueries() {

        return new Object[][]{
                {"Selenium"},
                {"Clover"}
                // Add more search queries as needed
        };
    }

    @DataProvider(name = "splCharQueries")
    public Object[][] getsplCharQueries() {

        return new Object[][]{
                {"!@@##!@"}
                // Add more search queries as needed
        };
    }
}
