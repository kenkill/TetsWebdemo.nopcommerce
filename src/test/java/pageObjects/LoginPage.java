package pageObjects;

import core.element.Element;
import org.openqa.selenium.By;

public class LoginPage {

    private Element emailInput = new Element(By.xpath("//input[@id='Email']"));

    private Element passInput = new Element(By.xpath("//input[@id='Password']"));

    private Element loginButton = new Element("//button[contains(text(),'Log in')]");

    public void signin(String emailIp, String pwIp) {
        emailInput.sendKeys(emailIp);
        passInput.sendKeys(pwIp);
        loginButton.moveToElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();
    }
}