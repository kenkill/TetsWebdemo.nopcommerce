package pageObjects;

import core.driver.Driver;
import core.element.Element;
import core.utilities.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Register {

    private Element genderInput = new Element("//input[@id='gender-male']");
    public void setGenderInput(){
        genderInput.click();
    }

    public void getDayDropdown(){
        Select day = new Select(Driver.getWebDriver().findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        day.selectByValue("14");
        day.getFirstSelectedOption().getText();
        Assert.assertEquals(day.getFirstSelectedOption().getText(),"14");
    }

    public void getmonthDropdown(){
        Select month = new Select(Driver.getWebDriver().findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        month.selectByValue("6");
        month.getFirstSelectedOption().getText();
        Assert.assertEquals(month.getFirstSelectedOption().getText(),"June");
    }

    public void getYearDropdown(){
        Select year = new Select(Driver.getWebDriver().findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        year.selectByValue("1993");
        year.getFirstSelectedOption().getText();
        Assert.assertEquals(year.getFirstSelectedOption().getText(),"1993");
    }
    private Element firstNameInput = new Element(By.id("FirstName"));
    public void setFirstNameInput(){
        firstNameInput.sendKeys("duy");
    }
    private Element lastNameInput = new Element(By.id("LastName"));
    public void setLastNameInput(){
        lastNameInput.sendKeys("le");
    }
    private Element emailInput = new Element("//input[@id='Email']");
    public String emailInput(){
        String email = RandomString.generateRandomString(5)+"@gmail.com";
        emailInput.sendKeys(email);
       return email;
    }
    private Element companyInput = new Element("//input[@id='Company']");
    public void setCompanyInput(){
        companyInput.sendKeys("abc");
    }
    private Element passInput = new Element("//input[@id='Password']");
    public String passInput(){
        String password = "123456";
        passInput.sendKeys(password);
        return password;
    }
    private Element confirmPassInput = new Element("//input[@id='ConfirmPassword']");
    public String confirmPassInput(){
        String confirmPassword = "123456";
        confirmPassInput.sendKeys(confirmPassword);
        return confirmPassword;
    }

    public void loginButton() {

        Element loginButton= new Element("//a[contains(text(),'Log in')]");
        loginButton.click();
    }
    private Element registerButton = new Element("//button[@id='register-button']");
    public void registerButton() {
        registerButton.click();
    }

    public Element getFirstNameInput() {
        if (firstNameInput == null) {
            firstNameInput = new Element(By.xpath("//input[@id='FirstName']"));
        }
        return firstNameInput;
    }
    public Element getLastNameInput() {
        if (lastNameInput == null) {
            lastNameInput = new Element(By.xpath("//input[@id='LastName']"));
        }
        return lastNameInput;
    }
    public Element getEmailInput() {
        if (emailInput == null) {
            emailInput = new Element(By.xpath("//input[@id='Email']"));
        }
        return emailInput;
    }
}
