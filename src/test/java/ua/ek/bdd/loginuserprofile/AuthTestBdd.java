package ua.ek.bdd.loginuserprofile;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.ek.base.BaseTest;
import ua.ek.steps.HomeStep;
import ua.ek.steps.registration.AuthStep;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.Helper;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AuthTestBdd extends BaseTest {

    WebDriver driver;
    Helper helper;
    HomeStep homeStep;
    AuthStep authStep;
    AssertUtils assertUtils;

    public AuthTestBdd() {
        initDrivers("chrome");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        helper = new Helper(driver);
        homeStep = new HomeStep(driver);
        authStep = new AuthStep(driver);
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

    //  @Then("^I am on auth form$")
    @Then("^I should see 'Войти' link on auth form$")
    public void validateAuthForm() {
        assertUtils.makeAssert(helper.getTextFromWebElement(authStep.getAuthPage().getAuthLink()),
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
    public void closeBrowser(){
        driver.close();
    }

    // Negative scenario

    @When("^I login with credentials (.*?) and (.*?)$")
    public void loginWithCredentials(String login, String password) {
        authStep.enterLoginOrEmail(login);
        authStep.enterPassword(password);
    }

    @Then("^I should see (.*?) error message for password$")
    public void shouldSeeErrorMessageForPassword(String errorMessageForPassword)  {
        AssertUtils.makeAssert(authStep.getAuthPage().getErrorPasswordAuth().getText(),
                errorMessageForPassword);
    }

    @Then("^I should see (.*?) error message for login$")
    public void shouldSeeErrorMessageForLogin(String errorMessageForLogin)  {
        AssertUtils.makeAssert(authStep.getAuthPage().getErrorLoginAuth().getText(),
                errorMessageForLogin);
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