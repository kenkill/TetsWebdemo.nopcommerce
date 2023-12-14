package core.driver.selenium.firefox;

import core.driver.BaseDriver;
import core.driver.DriverProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LocalFirefoxDriver extends BaseDriver {
    public LocalFirefoxDriver(DriverProperty property){
        super(property);
    }

    @Override
    public void createWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        firefoxOptions.addArguments(property.getArguments());
        firefoxOptions.merge(property.getCapabilities());
        driver = new ChromeDriver(firefoxOptions);
    }
}
