package ua.ek.steps.bdd.loginuserprofile;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebDriver;
import ua.ek.steps.HomeStep;
import ua.ek.utils.InitRemoteDrivers;
import ua.ek.steps.registration.AuthStep;
import ua.ek.utils.*;

public class AuthTestBdd {

    private WebDriver driver;
    private Helper helper;

    private HomeStep homeStep;
    private AuthStep authStep;

    public AuthTestBdd() {
        InitRemoteDrivers initRemoteDrivers = new InitRemoteDrivers();
        initRemoteDrivers.initWithDefaultValues();
        driver = initRemoteDrivers.getDriver();
        helper = new Helper(driver);

        StepFactory stepFactory = new StepFactory();
        homeStep = (HomeStep) stepFactory.createStep(StepType.HOME_STEP, driver);
        authStep = (AuthStep) stepFactory.createStep(StepType.AUTH_STEP, driver);
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
    public void userValidateAuthForm(String linkText) {
        AssertUtils.makeAssert(helper.getTextFromWebElement
                (authStep.getAuthPage().getAuthLinkOnAuthForm()), linkText);
    }

    @When("^User click on sign in link on auth form$")
    public void userClickSignInLinkOnAuthForm() {
        authStep.clickAuthLink();
    }

    @When("^User enter login (.*?)$")
    public void userEnterLogin(String login) {
        authStep.enterLoginOrEmail(login);
    }

    @When("^User enter password (.*?)$")
    public void userEnterPassword(String password) {
        authStep.enterPassword(password);
    }

    @And("^User click on submit button$")
    public void userClickSubmitButton() {
        authStep.clickSubmitButton();
    }

    @Then("^User should see (.*?) link$")
    public void userShouldSeeLink(String nickText) {
        AssertUtils.makeAssert(authStep.getUserProfileNickLinkText(), nickText);
    }

    // Negative scenario

    @When("^User login with credentials (.*?) and (.*?)$")
    public void userLoginWithCredentials(String login, String password) {
        authStep.enterLoginOrEmail(login);
        authStep.enterPassword(password);
    }

    @Then("^User should see (.*?) error message for password$")
    public void userShouldSeeErrorMessageForPassword(String errorMessageForPassword) {
        AssertUtils.makeAssert(authStep.getAuthPage().getErrorPasswordAuth().getText(),
                errorMessageForPassword);
    }

    @Then("^User should see (.*?) error message for login$")
    public void userShouldSeeErrorMessageForLogin(String errorMessageForLogin) {
        AssertUtils.makeAssert(authStep.getAuthPage().getErrorLoginAuth().getText(),
                errorMessageForLogin);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}