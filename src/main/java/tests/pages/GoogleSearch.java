package tests.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.utils.SearchPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearch extends SearchPage {


    // Constructor
    public GoogleSearch(WebDriver driver) {
        super(driver,"Google Search Page");
    }


    @FindBy(name="q")
    private WebElement searchInput;

    @FindBy(css="#res a")
    private WebElement resultFirstLink;

    @FindBy(css="#botstuff p")
    private WebElement resultErrorMessage;


    public void performSearch(String searchQuery) {
        logger.info("Performed some action on " + pageName);
        searchInput.sendKeys(searchQuery);
        searchInput.sendKeys(Keys.ENTER);
    }
    public String getResultFirstLinkText() {
        logger.info("Search Result First Link Text  :   " + resultFirstLink.getText());
        return resultFirstLink.getText();
    }

    public String getResultErrorMessageText() {
        logger.info("Search Result Error Message  :   " + resultErrorMessage.getText());
        return resultErrorMessage.getText();
    }
}
