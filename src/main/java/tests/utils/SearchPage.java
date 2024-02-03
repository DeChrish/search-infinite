package tests.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class SearchPage extends BasePage {


    public SearchPage(WebDriver driver, String pageName) {
        super(driver,pageName);
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