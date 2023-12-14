package core.driver;

import core.driver.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Driver {
//    protected static Logger logger;

    private static Alert alert;
    private static WebDriverWait explicitWait;
    private static long timeout = 30;

    public static WebDriver getWebDriver() {
        return DriverManager.getDriver().getSeleniumWebDriver();
    }

    public static void quitDriver() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }

    public static Alert waitForAlertPresence() {
        try {
            explicitWait = new WebDriverWait(getWebDriver(), timeout);
            return explicitWait.until(ExpectedConditions.alertIsPresent());
        } catch (UnhandledAlertException f) {
            try {
                Alert alert = getWebDriver().switchTo().alert();
                alert.accept();
            } catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public static void maximizeWindow() {
        getWebDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getWebDriver().manage().window().maximize();
    }

    public void acceptAlert() {
        alert = waitForAlertPresence();
        alert.accept();
    }

    public void cancelAlert() {
        alert = waitForAlertPresence();
        alert.dismiss();
    }

    public void sendKeyToAlert(String value) {
        alert = waitForAlertPresence();
        alert.sendKeys(value);
    }

    public static String getAlertText() {
        alert = waitForAlertPresence();
        return alert.getText();
    }

    public void switchToWindowByID(String parentID) {
        Set<String> allWindowIDs = getWebDriver().getWindowHandles();
        for (String windowID : allWindowIDs) {
            if (!windowID.equals(parentID)) {
                getWebDriver().switchTo().window(windowID);
                break;
            }
        }
    }

    public void switchToWindowByTitle(String expectedWindowTitle) {
        Set<String> allWindowIDs = getWebDriver().getWindowHandles();
        for (String windowID : allWindowIDs) {
            getWebDriver().switchTo().window(windowID);
            String actualWindowTitle = getWebDriver().getTitle();
            if (actualWindowTitle.equals(expectedWindowTitle)) {
                break;
            }
        }
    }

    public void closeAllWindowExceptParent(String parentID) {
        Set<String> allWindowIDs = getWebDriver().getWindowHandles();
        for (String windowID : allWindowIDs) {
            if (!windowID.equals(parentID)) {
                getWebDriver().switchTo().window(windowID);
                getWebDriver().close();
                sleep(1);
            }

            if (getWebDriver().getWindowHandles().size() == 1) {
                getWebDriver().switchTo().window(parentID);
                break;
            }
        }
    }

    public void openPageUrl(String pageUrl) {
        getWebDriver().get(pageUrl);
    }

    public String getPageTitle() {
        return getWebDriver().getTitle();
    }

    public String getPageUrl() {
        return getWebDriver().getCurrentUrl();
    }

    public String getPageSource() {
        return getWebDriver().getPageSource();
    }

    public static void navigateToUrl(String url) {
        getWebDriver().get(url);
    }

    public void backToPage() {
        getWebDriver().navigate().back();
    }

    public void refreshCurrentPage() {
        getWebDriver().navigate().refresh();
    }

    public void forwardToPage() {
        getWebDriver().navigate().forward();
    }

    public void sleep(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
