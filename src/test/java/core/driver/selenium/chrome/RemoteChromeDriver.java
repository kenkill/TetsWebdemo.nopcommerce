package core.driver.selenium.chrome;

import core.driver.BaseDriver;
import core.driver.DriverProperty;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteChromeDriver extends BaseDriver {

    public RemoteChromeDriver(DriverProperty property) {
        super(property);
    }

    @Override
    public void createWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments(property.getArguments());
        chromeOptions.merge(property.getCapabilities());

//        driver = new RemoteWebDriver(property.getRemoteUrl(), chromeOptions);
        driver = new RemoteWebDriver(chromeOptions);
    }
}