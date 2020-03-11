package ua.ek.bdd.userregistration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import ua.ek.steps.HomeStep;
import ua.ek.steps.registration.AuthStep;
import ua.ek.steps.registration.RegistrationStep;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.Helper;
import ua.ek.utils.InitDrivers;

public class UserRegistrationTestBdd {

    WebDriver driver;
    Helper helper;
    HomeStep homeStep;
    AuthStep authStep;
    RegistrationStep registrationStep;
    AssertUtils assertUtils;

    public UserRegistrationTestBdd() {

        InitDrivers initDrivers = new InitDrivers();
        try {
            initDrivers.setUp("chrome");
        }catch(Exception e){
            e.printStackTrace();
        }

        driver = initDrivers.getWebDriver();

        helper = new Helper(driver);
        homeStep = new HomeStep(driver);
        authStep = new AuthStep(driver);
        registrationStep = new RegistrationStep(driver);

        assertUtils = new AssertUtils();
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
        assertUtils.makeAssert(
                helper.getTextFromWebElement(registrationStep.getRegistrationPage().getRegisterLink()),
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