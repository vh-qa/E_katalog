package ua.ek.steps.bdd.loginuserprofile;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import ua.ek.steps.HomeStep;
import ua.ek.steps.base.BaseBddStep;
import ua.ek.steps.registration.AuthStep;
import ua.ek.utils.*;

public class AuthTestBdd {

    private WebDriver driver;
    private Helper helper;

    private HomeStep homeStep;
    private AuthStep authStep;

    public AuthTestBdd() {
        driver = BaseBddStep.getWebDriver();
        helper = new Helper(driver);

        StepFactory stepFactory = new StepFactory();
        homeStep = (HomeStep) stepFactory.createStep(StepType.HOME_STEP, driver);
        authStep = (AuthStep) stepFactory.createStep(StepType.AUTH_STEP, driver);
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

    @Then("^I should see 'Войти' link on auth form$")
    public void validateAuthForm() {
        AssertUtils.makeAssert(helper.getTextFromWebElement(authStep.getAuthPage().getAuthLinkOnAuthForm()),
                "Войти");
    }

    @When("^I click on sign in link on auth form$")
    public void clickSignInLinkOnAuthForm() {
        authStep.clickAuthLink();
    }

    @When("^I enter login \"([^\"]*)\"$")
    public void enterLogin(String login) {
        authStep.enterLoginOrEmail(login);
    }

    @When("^I enter password \"([^\"]*)\"$")
    public void enterPassword(String password) {
        authStep.enterPassword(password);
    }

    @And("^I click submit button$")
    public void clickSubmitButton() {
        authStep.clickSubmitButton();
    }

    @Then("^I should see \"([^\"]*)\" link$")
    public void shouldSeeLink(String nickText) {
        AssertUtils.makeAssert(authStep.getUserProfilePage().getNickLink().getText(), nickText);
    }

    @And("^I close browser$")
    public void closeBrowser() {
        driver.close();
    }

    // Negative scenario

    @When("^I login with credentials (.*?) and (.*?)$")
    public void loginWithCredentials(String login, String password) {
        authStep.enterLoginOrEmail(login);
        authStep.enterPassword(password);
    }

    @Then("^I should see (.*?) error message for password$")
    public void shouldSeeErrorMessageForPassword(String errorMessageForPassword) {
        AssertUtils.makeAssert(authStep.getAuthPage().getErrorPasswordAuth().getText(),
                errorMessageForPassword);
    }

    @Then("^I should see (.*?) error message for login$")
    public void shouldSeeErrorMessageForLogin(String errorMessageForLogin) {
        AssertUtils.makeAssert(authStep.getAuthPage().getErrorLoginAuth().getText(),
                errorMessageForLogin);
    }
}