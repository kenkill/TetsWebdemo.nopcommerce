package core.driver.selenium.chrome;

import core.driver.BaseDriver;
import core.driver.DriverProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocalChromeDriver extends BaseDriver {

    public LocalChromeDriver(DriverProperty property) {
        super(property);
    }

    @Override
    public void createWebDriver() {
//        String driverVersion = (String) property.getCapabilities().getCapability("driverVersion");
//        WebDriverManager.chromedriver().browserVersion(driverVersion).setup();
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addExtensions(new File("src/test/java/helper/extension/uBlock-Origin.crx"));
        chromeOptions.addArguments(property.getArguments());
        chromeOptions.merge(property.getCapabilities());

        driver = new ChromeDriver(chromeOptions);
    }
}