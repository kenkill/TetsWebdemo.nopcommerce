package core.element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Dropdown extends Element {

    private Select select;
    private JavascriptExecutor jsExecutor;

    public Dropdown(By by) {
        super(by);
    }

    public void selectDropdownByText(By locator, String itemText) {
        select = new Select(findElement(locator));
        select.selectByVisibleText(itemText);
    }

    public String getSelectedItemDropdown(By locator) {
        select = new Select(findElement(locator));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isMultipleDropdown(By locator) {
        select = new Select(findElement(locator));
        return select.isMultiple();
    }

    public void selectItemCustomDropdown(By parentLocator, By childLocator, String expectedItem) {
        findElement(parentLocator).click();

        explicitWait = new WebDriverWait(getDriver(), timeout);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(childLocator));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                jsExecutor = (JavascriptExecutor) getDriver();
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                item.click();
                break;
            }
        }
    }
}
