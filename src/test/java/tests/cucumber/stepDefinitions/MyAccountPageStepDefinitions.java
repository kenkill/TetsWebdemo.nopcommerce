package tests.cucumber.stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.MyAccountPage;
import tests.cucumber.dataContext.Context;
import tests.cucumber.dataContext.TestContext;

public class MyAccountPageStepDefinitions {
    MyAccountPage myAccountPage;
    TestContext testContext;
    public MyAccountPageStepDefinitions(TestContext testContext){
        this.testContext = testContext;
        myAccountPage = new MyAccountPage();
    }
    @Then("verify valid credentials")
    public void verifyValidCredentials() {

        Assert.assertTrue(myAccountPage.setGenderInput());
        Assert.assertEquals(myAccountPage.setFirstNameInput(),"duy");

        Assert.assertEquals(myAccountPage.setLastNameInput(),"le");

        Assert.assertEquals(myAccountPage.getDayDropdown(),"14");

        Assert.assertEquals(myAccountPage.getmonthDropdown(),"6");

        Assert.assertEquals(myAccountPage.getYearDropdown(),"1993");

        Assert.assertEquals(myAccountPage.setEmailInput(),testContext.getDataContext().getContext(Context.USER_EMAIL));
        myAccountPage.saveButton();
    }
}
