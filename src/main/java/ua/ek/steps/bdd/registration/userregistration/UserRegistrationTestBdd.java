package ua.ek.steps.bdd.registration.userregistration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ua.ek.pages.registration.AuthPage;
import ua.ek.pages.registration.RegistrationPage;
import ua.ek.steps.base.BaseStepBdd;
import ua.ek.utils.*;

public class UserRegistrationTestBdd extends BaseStepBdd {
    private AuthPage authPage;
    private RegistrationPage registrationPage;

    public UserRegistrationTestBdd() {
        authPage = (AuthPage) getPage(PageType.AUTH_PAGE, getDriver());
        registrationPage = (RegistrationPage) getPage(PageType.REGISTRATION_PAGE, getDriver());
    }

    // Positive scenario

    @Given("^User open the registration form$")
    public void userOpenRegistrationForm(){
        getDriver()
                .get(getHomePage()
                        .getBaseUrl());
        getHelper().clickWebElement(getHomePage().getEnterLink());
    }

    @When("^User click on registration link on registration form$")
    public void userClickRegistrationLinkOnRegistrationForm() {
        getHelper().clickWebElement(registrationPage.getRegisterLinkOnRegistrationForm());
    }

    @And("^User enter login (.*?) on registration form$")
    public void userEnterLogin(String login) {
        getHelper().enterTextInTextField(registrationPage.getLoginField(), login);
    }

    @And("^User enter email (.*?) on registration form$")
    public void userEnterEmail(String email) {
        getHelper().enterTextInTextField(registrationPage.getEmailField(), email);
    }

    @And("^User enter password (.*?) on registration form$")
    public void userEnterPassword(String password) {
        getHelper().enterTextInTextField(registrationPage.getPasswordField(), password);
    }

    @And("^User click on submit button on registration form$")
    public void userClickSubmitButton() {
        getHelper().clickWebElement(registrationPage.getSubmitButton());
    }

    @Then("^User should see form with text (.*?)$")
    public void userShouldSeeSuccessfulRegistrationMessage(String successfulRegistrationText) {
        AssertUtils.makeAssert(
                getHelper().getTextFromStalenessOfWebElement(registrationPage.getSuccessfulUserRegistrationHeaderElement()),
                                                             successfulRegistrationText);
    }

    @Then("^User should see (.*?) error message for login on registration form$")
    public void userShouldSeeErrorMessageForLogin(String errorMessageForLogin){
        AssertUtils.makeAssert(getHelper().getTextFromWebElement(registrationPage.getLoginErrorElement()),
                                                                 errorMessageForLogin);
    }

    @Then("^User should see (.*?) error message for email on registration form$")
    public void userShouldSeeErrorMessageForEmail(String errorMessageForEmail){
        AssertUtils.makeAssert(getHelper().getTextFromWebElement(registrationPage.getEmailErrorElement()),
                                                                errorMessageForEmail);
    }

    @And("^User close browser with registration form$")
    public void userCloseBrowserWithRegistrationForm(){
        getDriver().quit();
    }
}