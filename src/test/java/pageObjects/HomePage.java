package pageObjects;

import core.element.Element;
import org.openqa.selenium.By;

public class HomePage {
    private Element logOutButton = new Element(By.xpath("//a[contains(text(),'Log out')]"));
    public boolean verifyLogOutIsDisplayed() {

        return logOutButton.isElementDisplayed();
    }
    private Element myAccountButton = new Element(By.xpath("//a[contains(text(),'My account')]"));
    public void myAccountButton(){
        myAccountButton.click();
    }
}
