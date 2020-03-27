package ua.ek.steps.bdd.registration.loginuserprofile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ua.ek.pages.registration.AuthPage;
import ua.ek.pages.registration.UserProfilePage;
import ua.ek.steps.base.BaseStepBdd;
import ua.ek.utils.*;

public class AuthTestBdd extends BaseStepBdd {
    private AuthPage authPage;
    private UserProfilePage userProfilePage;

    public AuthTestBdd() {
        authPage = (AuthPage) getPage(PageType.AUTH_PAGE, getDriver());
        userProfilePage = (UserProfilePage) getPage(PageType.USER_PROFILE_PAGE, getDriver());
    }

     // Positive scenario

    @Given("^User open the auth form$")
    public void userOpenAuthForm(){
        getDriver()
                .get(getHomePage()
                .getBaseUrl());
        getHelper().clickWebElement(getHomePage().getEnterLink());
    }

    @When("^User click on sign in link on auth form$")
    public void userClickSignInLinkOnAuthForm() {
        getHelper()
                .clickWebElement(authPage.getAuthLinkOnAuthForm());
    }

    @When("^User enter login (.*?) on auth form$")
    public void userEnterLoginOnAuthForm(String login) {
        getHelper()
                .enterTextInTextField(authPage.getLoginOrEmailAuthField(), login);
    }

    @When("^User enter password (.*?) on auth form$")
    public void userEnterPasswordOnAuthForm(String password) {
        getHelper()
                .enterTextInTextField(authPage.getPasswordAuthField(), password);
    }

    @And("^User click on submit button on auth form$")
    public void userClickSubmitButtonOnAuthForm() {
        getHelper()
                .clickWebElement(authPage.getSubmitButtonAuth());
    }

    @Then("^User should see (.*?) link$")
    public void userShouldSeeLinkInUserProfile(String nickText) {
        AssertUtils.makeAssert(
                getHelper()
                        .getTextFromStalenessOfWebElement
                                (userProfilePage.getNickLink()), nickText);
    }

    // Negative scenario

    @When("^User login with credentials (.*?) and (.*?)$")
    public void userLoginWithCredentials(String login, String password) {
        getHelper().enterTextInTextField(authPage.getLoginOrEmailAuthField(), login);
        getHelper().enterTextInTextField(authPage.getPasswordAuthField(), password);
    }

    @Then("^User should see (.*?) error message for password on auth form$")
    public void userShouldSeeErrorMessageForPasswordOnAuthForm(String errorMessageForPassword) {
        AssertUtils.makeAssert(authPage.getErrorPasswordAuth().getText(),
                errorMessageForPassword);
    }

    @Then("^User should see (.*?) error message for login on auth form$")
    public void userShouldSeeErrorMessageForLoginOnAuthForm(String errorMessageForLogin) {
        AssertUtils.makeAssert(authPage.getErrorLoginAuth().getText(),
                errorMessageForLogin);
    }

     @And("^User close browser with auth form$")
     public void userCloseBrowserWithAuthForm(){
         getDriver().quit();
     }
}