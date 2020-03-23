package ua.ek.steps.bdd.registration.loginuserprofile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ua.ek.steps.HomeStep;
import ua.ek.steps.base.BaseStepBdd;

import ua.ek.steps.registration.AuthStep;
import ua.ek.utils.*;

 public class AuthTestBdd extends BaseStepBdd {

    private HomeStep homeStep;
    private AuthStep authStep;

    public AuthTestBdd() {
        StepFactory stepFactory = new StepFactory();
        homeStep = (HomeStep) stepFactory.createStep(StepType.HOME_STEP, getDriver());
        authStep = (AuthStep) stepFactory.createStep(StepType.AUTH_STEP, getDriver());
    }

     // Positive scenario

    @Given("^User open the auth form$")
    public void userOpenAuthForm(){
        homeStep.goHomePage().clickEnterLink();
    }

    @When("^User click on sign in link on auth form$")
    public void userClickSignInLinkOnAuthForm() {
        authStep.clickAuthLink();
    }

    @When("^User enter login (.*?) on auth form$")
    public void userEnterLoginOnAuthForm(String login) {
        authStep.enterLoginOrEmail(login);
    }

    @When("^User enter password (.*?) on auth form$")
    public void userEnterPasswordOnAuthForm(String password) {
        authStep.enterPassword(password);
    }

    @And("^User click on submit button on auth form$")
    public void userClickSubmitButtonOnAuthForm() {
        authStep.clickSubmitButton();
    }

    @Then("^User should see (.*?) link$")
    public void userShouldSeeLinkInUserProfile(String nickText) {
        AssertUtils.makeAssert(authStep.getUserProfileNickLinkText(), nickText);
    }

    // Negative scenario

    @When("^User login with credentials (.*?) and (.*?)$")
    public void userLoginWithCredentials(String login, String password) {
        authStep.enterLoginOrEmail(login);
        authStep.enterPassword(password);
    }

    @Then("^User should see (.*?) error message for password on auth form$")
    public void userShouldSeeErrorMessageForPasswordOnAuthForm(String errorMessageForPassword) {
        AssertUtils.makeAssert(authStep.getAuthPage().getErrorPasswordAuth().getText(),
                errorMessageForPassword);
    }

    @Then("^User should see (.*?) error message for login on auth form$")
    public void userShouldSeeErrorMessageForLoginOnAuthForm(String errorMessageForLogin) {
        AssertUtils.makeAssert(authStep.getAuthPage().getErrorLoginAuth().getText(),
                errorMessageForLogin);
    }

     @And("^User close browser with auth form$")
     public void userCloseBrowserWithAuthForm(){
         getDriver().quit();
     }
}