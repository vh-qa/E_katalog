package ua.ek.bdd.userregistration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.ek.steps.HomeStep;
import ua.ek.steps.registration.AuthStep;
import ua.ek.steps.registration.RegistrationStep;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.Helper;
import ua.ek.utils.IWaitTimes;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class UserRegistrationTestBdd {

    WebDriver driver;
    Helper helper;
    HomeStep homeStep;
    AuthStep authStep;
    RegistrationStep registrationStep;
    AssertUtils assertUtils;

    public UserRegistrationTestBdd() {
        initDrivers("chrome");

        driver.manage().timeouts().implicitlyWait(IWaitTimes.THREE_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();

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

    private void initDrivers(String browser) {

        Properties properties = new Properties();
        try {
            properties.load(new InputStreamReader(this.getClass().getResourceAsStream("/properties/common.properties"), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.driver"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unknown browser " + browser);
        }
    }
}