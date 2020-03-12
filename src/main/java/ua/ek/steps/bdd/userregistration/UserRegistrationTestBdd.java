package ua.ek.steps.bdd.userregistration;

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
        AssertUtils.makeAssert(
                helper.getTextFromWebElement(registrationStep.getRegistrationPage().getRegisterLinkOnRegistrationForm()),
                "Регистрация");
    }

    @When("^I click on registration link on auth form$")
    public void clickRegistrationLink() {
        registrationStep.clickRegisterLink();
    }

    @And("^I enter login \"([^\"]*)\"$")
    public void enterLogin(String login) {
        registrationStep.enterLogin(login);
    }

    @And("^I enter email \"([^\"]*)\"$")
    public void enterEmail(String email)  {
        registrationStep.enterEmail(email);
    }

    @And("^I enter password \"([^\"]*)\"$")
    public void enterPassword(String password)  {
        registrationStep.enterPassword(password);
    }

    @And("^I click submit button$")
    public void clickSubmitButton() {
        registrationStep.clickSubmitButton();
    }

    @Then("^I should see form with text \\\"([^\\\"]*)\\\"$")
    public void shouldSeeSuccessfulRegistrationMessage(String successfulRegistrationText)  {
        AssertUtils.makeAssert(registrationStep.getRegistrationPage().getSuccessfulUserRegistrationElement().getText(),
                successfulRegistrationText);
    }
}