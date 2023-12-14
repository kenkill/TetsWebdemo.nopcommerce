package tests.cucumber.dataContext;

import constants.GlobalConstants;
import core.driver.DriverManager;
import core.driver.Driver;
import core.utilities.ConfigReader;

public class TestContext {
    public DataContext dataContext;
    public ConfigReader configReader;
    public TestContext(){
        String browserName = System.getProperty("browser","chrome.local");
        DriverManager.initBrowser(browserName);
        Driver.maximizeWindow();
        Driver.navigateToUrl(GlobalConstants.baseUrl);
        dataContext = new DataContext();
        configReader = new ConfigReader();
    }
    public DataContext getDataContext(){
        return dataContext;
    }
}
