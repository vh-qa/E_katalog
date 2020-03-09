package ua.ek.steps.registration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import ua.ek.steps.HomeStep;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.AssertUtils;

public class RegistrationStep extends BaseStep {

    HomeStep homeStep;
    AuthStep authStep;
    AssertUtils assertUtils;

    public RegistrationStep(WebDriver driver) {
        super(driver);

        homeStep = new HomeStep(driver);
        authStep = new AuthStep(driver);

        assertUtils = new AssertUtils();
    }

    public RegistrationStep goAuthPage(){
        getHelper().clickWebElement(getHomePage().getEnterLink());
        return this;
    }

    public RegistrationStep clickRegisterLink() {
        getHelper().clickWebElement(getRegistrationPage().getRegisterLink());
        return this;
    }

    public RegistrationStep enterLogin(String login) {
        getHelper().enterTextInTextField(getRegistrationPage().getLoginField(), login);
        return this;
    }

    public RegistrationStep enterEmail(String email) {
        getHelper().enterTextInTextField(getRegistrationPage().getEmailField(), email);
        return this;
    }

    public RegistrationStep enterPassword(String password) {
        getHelper().enterTextInTextField(getRegistrationPage().getPasswordField(), password);
        return this;
    }

    public RegistrationStep clickCloseLink() {
        getHelper().getTextFromWebElement(getRegistrationPage().getCloseLinkRegistrationForm());
        return this;
    }

    public RegistrationStep clickSubmitButton() {
        getHelper().clickWebElement(getRegistrationPage().getSubmitButton());
        return this;
    }

    public String getSuccessfulUserRegistrationTextFromWebElement() {
        return getHelper().getTextFromWebElement(getRegistrationPage().getSuccessfulUserRegistrationElement());
    }

    public String getLoginErrorMessage(){
        return getHelper().getTextFromWebElement(getRegistrationPage().getLoginErrorElement());
    }

    public String getEmailErrorMessage(){
        return getHelper().getTextFromWebElement(getRegistrationPage().getEmailErrorElement());
    }

    public String getEmailIncorrectErrorMessage(){
        return getHelper().getTextFromWebElement(getRegistrationPage().getEmailIncorrectErrorElement());
    }

    public String getPasswordErrorMessage(){
        return getHelper().getTextFromWebElement(getRegistrationPage().getPasswordErrorElement());
    }

    // Methods for BDD

    // Positive scenario

    @Given("^I am on home page$")
    public void goHomePage() {
        homeStep.goHomePage();
    }

    @When("^I click on sign in link$")
    public void clickSignInLink() {
        homeStep.clickEnterLink();
    }

    @Then("^I should see 'Регистрация' link on auth form$")
    public void validateRegistrationForm() {
        assertUtils.makeAssert(
                getHelper().getTextFromWebElement(this.getRegistrationPage().getRegisterLink()),
                "Регистрация");
    }

    @When("^I click on registration link on auth form$")
    public void clickRegistrationLink() {
        this.clickRegisterLink();
    }

    @And("^I enter login \"([^\"]*)\"$")
    public void enterLoginBDD(String login) {
        this.enterLogin(login);
    }

    @And("^I enter email \"([^\"]*)\"$")
    public void enterEmailBDD(String email)  {
        this.enterEmail(email);
    }

    @And("^I enter password \"([^\"]*)\"$")
    public void enterPasswordBDD(String password)  {
        this.enterPassword(password);
    }

    @And("^I click submit button$")
    public void clickSubmitButtonBDD() {
        this.clickSubmitButton();
    }

    @Then("^I should see form with text \\\"([^\\\"]*)\\\"$")
    public void shouldSeeSuccessfulRegistrationMessage(String successfulRegistrationText)  {
        AssertUtils.makeAssert(this.getRegistrationPage().getSuccessfulUserRegistrationElement().getText(),
                successfulRegistrationText);
    }
}