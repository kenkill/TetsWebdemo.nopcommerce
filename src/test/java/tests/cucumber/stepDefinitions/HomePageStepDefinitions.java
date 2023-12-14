package tests.cucumber.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import tests.cucumber.dataContext.TestContext;

public class HomePageStepDefinitions {
    HomePage homePage;
    TestContext testContext;

    public HomePageStepDefinitions(TestContext testContext){
        this.testContext = testContext;
        homePage = new HomePage();
    }
    @Then("user can login to system successfully")
    public void userCanLoginToSystemSuccessfully() {
       // Assert.assertTrue(homePage.verifyLogOutIsDisplayed());
    }

    @When("go to the my account page")
    public void goToTheMyAccountPage() {
        homePage.myAccountButton();
    }
}
