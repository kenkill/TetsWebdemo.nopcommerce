package core.driver;

import org.openqa.selenium.WebDriver;

public abstract class BaseDriver {
    protected DriverProperty property;
    protected WebDriver driver;
    public BaseDriver(DriverProperty property){
        this.property= property;
    }
    public abstract void createWebDriver();
    public WebDriver getSeleniumWebDriver(){
        return this.driver;
    }
}
