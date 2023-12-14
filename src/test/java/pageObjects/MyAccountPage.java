package pageObjects;

import core.driver.Driver;
import core.element.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class MyAccountPage {
    private Element genderInput = new Element("//input[@id='gender-male']");
    public boolean setGenderInput(){
      return   genderInput.isSelected();

    }
    private Element firstNameInput = new Element("//input[@id='FirstName']");
    public String setFirstNameInput(){
    return firstNameInput.getAttribute("value");
    }
    private Element lastNameInput = new Element("//input[@id='LastName']");
    public String setLastNameInput(){
      return   lastNameInput.getAttribute("value");
    }
    public String getDayDropdown(){
        Select day = new Select(Driver.getWebDriver().findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        day.getFirstSelectedOption().getAttribute("value");
       return day.getFirstSelectedOption().getAttribute("value");
    }
    public String getmonthDropdown(){
        Select month = new Select(Driver.getWebDriver().findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        month.getFirstSelectedOption().getAttribute("value");
       return month.getFirstSelectedOption().getAttribute("value");
    }

    public String getYearDropdown(){
        Select year = new Select(Driver.getWebDriver().findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        year.getFirstSelectedOption().getAttribute("value");
        return year.getFirstSelectedOption().getAttribute("value");
    }
    private Element emailInput = new Element("//input[@id='Email']");
    public String setEmailInput(){
        emailInput.getAttribute("value");
        return emailInput.getAttribute("value");
    }
    private Element saveButton = new Element("//button[@id='save-info-button']");
    public void saveButton() {
        saveButton.click();
    }
}
