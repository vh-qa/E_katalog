package ua.ek.steps.bdd.userregistration;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import ua.ek.steps.HomeStep;
import ua.ek.steps.base.BaseBddStep;
import ua.ek.steps.registration.AuthStep;
import ua.ek.steps.registration.RegistrationStep;
import ua.ek.utils.*;

public class UserRegistrationTestBdd {

    private WebDriver driver;
    private Helper helper;

    private HomeStep homeStep;
    private AuthStep authStep;
    private RegistrationStep registrationStep;

    public UserRegistrationTestBdd() {
        driver = BaseBddStep.getWebDriver();
        helper = new Helper(driver);

        StepFactory stepFactory = new StepFactory();
        homeStep = (HomeStep) stepFactory.createStep(StepType.HOME_STEP, driver);
        authStep = (AuthStep) stepFactory.createStep(StepType.AUTH_STEP, driver);
        registrationStep = (RegistrationStep) stepFactory.createStep(StepType.REGISTRATION_STEP, driver);
    }

    // Positive scenario

    @Given("^User open the home page$")
    public void userOpenHomePage() {
        homeStep.goHomePage();
    }

    @When("^User click on sign in link$")
    public void userClickSignInLinkOnHomePage() {
        homeStep.clickEnterLink();
    }

    @Then("^User should see (.*?) link on auth form$")
    public void userValidateRegistrationForm(String registrationLink) {
        AssertUtils.makeAssert(
                registrationStep.getRegisterLinkOnRegistrationFormText(),
                registrationLink);
    }

    @When("^User click on registration link on registration form$")
    public void userClickRegistrationLinkOnRegistrationForm() {
        registrationStep.clickRegisterLink();
    }

    @And("^User enter login (.*?)$")
    public void userEnterLogin(String login) {
        registrationStep.enterLogin(login);
    }

    @And("^User enter email (.*?)$")
    public void userEnterEmail(String email) {
        registrationStep.enterEmail(email);
    }

    @And("^User enter password (.*?)$")
    public void userEnterPassword(String password) {
        registrationStep.enterPassword(password);
    }

    @And("^User click on submit button$")
    public void userClickSubmitButton() {
        registrationStep.clickSubmitButton();
    }

    @Then("^User should see form with text (.*?)$")
    public void userShouldSeeSuccessfulRegistrationMessage(String successfulRegistrationText) {
        AssertUtils.makeAssert(
                registrationStep.getSuccessfulUserRegistrationTextFromHeaderElement(),
                successfulRegistrationText);
    }

    @Then("^User should see (.*?) error message for login$")
    public void userShouldSeeErrorMessageForLogin(String errorMessageForLogin){
        AssertUtils.makeAssert(registrationStep.getLoginErrorMessage(), errorMessageForLogin);
    }

    @Then("^User should see (.*?) error message for email$")
    public void userShouldSeeErrorMessageForEmail(String errorMessageForEmail){
        AssertUtils.makeAssert(registrationStep.getEmailErrorMessage(), errorMessageForEmail);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}