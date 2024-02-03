package tests.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.utils.SearchPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YahooSearch extends SearchPage {


    // Constructor
    public YahooSearch(WebDriver driver) {
        super(driver, "Yahoo Search Page");
    }


    @FindBy(name="p")
    private WebElement searchInput;

    @FindBy(css="#web .first a")
    private WebElement resultFirstLink;


    public void performSearch(String searchQuery) {
        logger.info("Performed some action on   :   " + pageName);
        searchInput.sendKeys(searchQuery);
        searchInput.sendKeys(Keys.ENTER);

    }

    public String getResultFirstLinkText() {
        logger.info("Search Result First Link Text  :   " + resultFirstLink.getText());
        return resultFirstLink.getText();
    }
}
