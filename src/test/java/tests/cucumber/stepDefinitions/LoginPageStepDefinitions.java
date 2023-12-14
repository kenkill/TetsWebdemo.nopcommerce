package tests.cucumber.stepDefinitions;

import io.cucumber.java.en.And;
import pageObjects.LoginPage;
import tests.cucumber.dataContext.Context;
import tests.cucumber.dataContext.TestContext;

public class LoginPageStepDefinitions {

    LoginPage loginPage;
    TestContext testContext;

    public LoginPageStepDefinitions(TestContext testContext){
        this.testContext = testContext;
        loginPage = new LoginPage();
    }


    @And("user login into system")
    public void userLoginIntoSystem() {
        loginPage.signin(testContext.getDataContext().getContext(Context.USER_EMAIL), testContext.getDataContext().getContext(Context.PASSWORD));
    }
}
