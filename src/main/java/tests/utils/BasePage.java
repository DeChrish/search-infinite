package tests.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class BasePage{

    protected WebDriver driver;
    protected String pageName;
    protected WebDriverWait wait;
    protected Logger logger;

    public BasePage(WebDriver driver,String pageName) {
        this.driver = driver;
        this.pageName = pageName;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.logger = Logger.getLogger(pageName);
          PageFactory.initElements(driver, this);
    }

    public void openweb(String url){
        this.driver.get(url);
    }
}
