package ua.ek.steps.bdd.registration.userregistration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ua.ek.steps.HomeStep;
import ua.ek.steps.base.BaseStepBdd;
import ua.ek.steps.registration.AuthStep;
import ua.ek.steps.registration.RegistrationStep;
import ua.ek.utils.*;

public class UserRegistrationTestBdd extends BaseStepBdd {
    private HomeStep homeStep;
    private AuthStep authStep;
    private RegistrationStep registrationStep;

    public UserRegistrationTestBdd() {
        StepFactory stepFactory = new StepFactory();
        homeStep = (HomeStep) stepFactory.createStep(StepType.HOME_STEP, getDriver());
        authStep = (AuthStep) stepFactory.createStep(StepType.AUTH_STEP, getDriver());
        registrationStep = (RegistrationStep) stepFactory.createStep(StepType.REGISTRATION_STEP, getDriver());
    }

    // Positive scenario

    @Given("^User open the registration form$")
    public void userOpenRegistrationForm(){
        homeStep.clickEnterLink();
    }

    @When("^User click on registration link on registration form$")
    public void userClickRegistrationLinkOnRegistrationForm() {
        registrationStep.clickRegisterLink();
    }

    @And("^User enter login (.*?) on registration form$")
    public void userEnterLogin(String login) {
        registrationStep.enterLogin(login);
    }

    @And("^User enter email (.*?) on registration form$")
    public void userEnterEmail(String email) {
        registrationStep.enterEmail(email);
    }

    @And("^User enter password (.*?) on registration form$")
    public void userEnterPassword(String password) {
        registrationStep.enterPassword(password);
    }

    @And("^User click on submit button on registration form$")
    public void userClickSubmitButton() {
        registrationStep.clickSubmitButton();
    }

    @Then("^User should see form with text (.*?)$")
    public void userShouldSeeSuccessfulRegistrationMessage(String successfulRegistrationText) {
        AssertUtils.makeAssert(
                registrationStep.getSuccessfulUserRegistrationTextFromHeaderElement(),
                successfulRegistrationText);
    }

    @Then("^User should see (.*?) error message for login on registration form$")
    public void userShouldSeeErrorMessageForLogin(String errorMessageForLogin){
        AssertUtils.makeAssert(registrationStep.getLoginErrorMessage(), errorMessageForLogin);
    }

    @Then("^User should see (.*?) error message for email on registration form$")
    public void userShouldSeeErrorMessageForEmail(String errorMessageForEmail){
        AssertUtils.makeAssert(registrationStep.getEmailErrorMessage(), errorMessageForEmail);

    }

    @And("^User close browser with registration form$")
    public void userCloseBrowserWithRegistrationForm(){
        getDriver().quit();
    }
}