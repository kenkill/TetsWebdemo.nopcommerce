package core.driver.selenium.firefox;

import core.driver.BaseDriver;
import core.driver.DriverProperty;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteFirefoxDriver extends BaseDriver {
    public RemoteFirefoxDriver(DriverProperty property){
        super(property);
    }

    @Override
    public void createWebDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments(property.getArguments());
        firefoxOptions.merge(property.getCapabilities());
        driver = new RemoteWebDriver(firefoxOptions);
    }
}
