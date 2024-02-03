package tests.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.utils.SearchPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingSearch extends SearchPage {


    // Constructor
    public BingSearch(WebDriver driver) {
        super(driver,"Bing Search Page");
    }


    @FindBy(name="q")
    private WebElement searchInput;

    @FindBy(css="#b_results .b_algo a")
    private WebElement resultFirstLink;


    public void performSearch(String searchQuery) {
        logger.info("Performed some action on " + pageName);
        searchInput.sendKeys(searchQuery);
        searchInput.sendKeys(Keys.ENTER);
    }

    public String getResultFirstLinkText() {
        wait.until(ExpectedConditions.visibilityOf(resultFirstLink));
        logger.info("Search Result First Link Text  :   " + resultFirstLink.getText());
        return resultFirstLink.getText();
    }
}
