package pages;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class BasePage{

    protected WebDriver driver;

    protected WebDriverWait wait;


    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal();

//    public BasePage(WebDriver driver,String pageName) {
//        this.driver = driver;
//        this.pageName = pageName;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        this.logger = Logger.getLogger(pageName);
//          PageFactory.initElements(driver, this);
//    }

    public WebDriver initDriver(String browser, String hubURL) {



        if ("chrome".equalsIgnoreCase(browser)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else if ("firefox".equalsIgnoreCase(browser)) {
            driver = new FirefoxDriver();
        } else if ("remote".equalsIgnoreCase(browser)) {
            // remote capability setup needed
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }



        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.manage().window().fullscreen();
        threadLocal.set(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return getDriver();
    }



    public void openweb(String url){
        this.driver.get(url);
    }

    public static synchronized WebDriver getDriver() {
        return threadLocal.get();
    }
}
