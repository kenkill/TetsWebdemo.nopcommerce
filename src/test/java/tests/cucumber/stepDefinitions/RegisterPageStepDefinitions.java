package tests.cucumber.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Register;
import tests.cucumber.dataContext.Context;
import tests.cucumber.dataContext.TestContext;

public class RegisterPageStepDefinitions {
    Register register;
    TestContext testContext;
    public RegisterPageStepDefinitions(TestContext testContext){
        this.testContext = testContext;
        register = new Register();
    }

    @Given("user on the register page")
    public void userOnTheRegisterPage() {
    }

    @Then("create a new valid user")
    public void createANewValidUser() {
        register.setGenderInput();
        register.setFirstNameInput();
        register.setLastNameInput();
        register.getDayDropdown();
        register.getmonthDropdown();
        register.getYearDropdown();

        String email = register.emailInput();
        testContext.getDataContext().setContext(Context.USER_EMAIL,email);
        String password = register.passInput();
        testContext.getDataContext().setContext(Context.PASSWORD,password);
        String confirmPassword = register.confirmPassInput();
        testContext.getDataContext().setContext(Context.CONFIRMPASSWORD,confirmPassword);
        register.registerButton();
    }

    @When("go to the login page")
    public void goToTheLoginPage() {
        register.loginButton();
    }

}
