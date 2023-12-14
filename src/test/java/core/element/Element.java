package core.element;


import core.driver.Driver;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import java.util.List;

public class Element implements WebElement {

    protected Logger logger;
    protected WebElement _webElement;
    protected List<WebElement> _webElements;
    protected By by;
    protected WebDriverWait explicitWait;
    protected long timeout = 30;
    private Actions action;

    public Element(By by) {
        this.by = by;
        _webElement = Driver.getWebDriver().findElement(by);
    }

    public Element(String xpath) {
        by = By.xpath(xpath);
        _webElement = Driver.getWebDriver().findElement(by);
    }

    public WebDriver getDriver() {
        return Driver.getWebDriver();
    }

    public void click() {
        waitForElementClickable(by);
        _webElement.click();
    }

    public void submit() {

    }

    public void sendKeys(CharSequence... charSequences) {
        clear();
        _webElement.sendKeys(charSequences);
    }

    public void clear() {
        _webElement.clear();
    }

    public String getTagName() {
        return null;
    }

    public String getAttribute(String attribute) {
        return _webElement.getAttribute(attribute);
    }

    public boolean isSelected() {
        return _webElement.isSelected();
    }

    public boolean isEnabled() {
        return _webElement.isEnabled();
    }

    public String getText() {
        return _webElement.getText();
    }

    public List<WebElement> findElements(By by) {
        return null;
    }

    public WebElement findElement(By locator) {
        return _webElement;
    }

    public boolean isElementDisplayed() {
        return _webElement.isDisplayed();
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    public void waitForElementVisible(By locator) {
        explicitWait = new WebDriverWait(getDriver(), timeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForAllElementVisible(By locator) {
        explicitWait = new WebDriverWait(getDriver(), timeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitForElementClickable(By by) {
        explicitWait = new WebDriverWait(getDriver(), timeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public void waitForElementInvisible(By by) {
        explicitWait = new WebDriverWait(getDriver(), timeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    public void doubleClickToElement(By locator) {
        action = new Actions(getDriver());
        action.doubleClick(findElement(locator)).perform();
    }

    public void rightClickToElement(By locator) {
        action = new Actions(getDriver());
        action.contextClick(findElement(locator)).perform();
    }

    public void doubleClickToElement(By sourceLocator, By targetLocator) {
        action = new Actions(getDriver());
        action.dragAndDrop(findElement(sourceLocator), findElement(targetLocator)).perform();
    }

    public void pressKeyToElement(By locator, Keys key) {
        action = new Actions(getDriver());
        action.sendKeys(findElement(locator), key).perform();
    }

    public void hoverToElement(By locator) {
        action = new Actions(getDriver());
        action.moveToElement(findElement(locator)).perform();
    }

    public List<WebElement> getElements(By locator) {
        return getDriver().findElements(locator);
    }

    public int getElementSize(By locator) {
        return getElements(locator).size();
    }

    public void moveToElement(By locator) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", findElement(locator));
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}