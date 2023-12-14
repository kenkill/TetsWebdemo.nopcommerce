package tests.cucumber.hooks;



import core.driver.DriverManager;
import core.driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class CucumberHooks {
    @After
    public void afterScenario(Scenario scenario){
        Driver.quitDriver();
        DriverManager.removeDriver();
    }
}
