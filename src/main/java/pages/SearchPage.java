package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public abstract class SearchPage extends BasePage {

    protected Logger logger;

    protected String pageName;

    public SearchPage(WebDriver driver, String pageName) {
        this.driver = driver;
        this.pageName = pageName;
        this.logger = Logger.getLogger(pageName);
        PageFactory.initElements(driver, this);
    }

    public abstract void performSearch(String searchQuery);

    public void waitForSync() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}