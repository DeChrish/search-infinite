package utils.Listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pages.BasePage;
;import java.util.logging.Logger;

public class TestListeners implements ITestListener {

    protected Logger logger = Logger.getLogger("TestListeners Logger");

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    // Text attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png",fileExtension = ".png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void onTestFailure(ITestResult iTestResult) {
        logger.info("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        WebDriver driver = BasePage.getDriver();
        if (driver instanceof WebDriver) {
            logger.info("Screenshot captured for test case:" + getTestMethodName(iTestResult));
            saveScreenshotPNG(driver);
        }

    }
}
