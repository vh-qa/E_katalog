package ua.ek.bdd;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.model.User;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.DataGenerator;

public class AuthPageTestBDD extends BaseTest {

    // Positive scenario

    @Given("I am on home page")
    public void goHomePage() {

    }

    @When("I click on sign in link")
    public void clickSignInLink() {
        authStep.goAuthPage(driver);
    }

    @Then("I am on Auth form")
    public void validateAuthForm() {

    }

    @When("I click on sign in link on auth form")
    public void clickSignInLinkOnAuthForm(){
        authStep.clickAuthLink();
    }

    @And("I enter login")
    public void enterLogin() {

    }

    @And("I enter password")
    public void enterPassword() {

    }

    @And("I click submit button")
    public void clickSubmitButton() {

    }

    @Then("I should see some_login_15 link")
    public void validateUserProfile(){

    }

    @Test
    public void authSuccessfulTestWithEmail() {
        User user = DataGenerator.getPositiveUserData();

        authStep.enterLoginOrEmail(user.getEmail());
        authStep.enterPassword(user.getPassword());
        authStep.clickRememberMeCheckBoxAuth(); // uncheck checkbox
        authStep.clickSubmitButton();
        AssertUtils.makeAssert(authStep.getAuthPage().getNickLinkText(),
                "some_login_15");

        authStep.clickLogOutFromUserProfileLink();
    }

    // Negative scenario

    @Test
    public void authUnSuccessfulTestWithLogin() {
        User user = DataGenerator.getUserDataForUnSuccessfulTestWithLogin();

        authStep.enterLoginOrEmail(user.getLogin());
        authStep.enterPassword(user.getPassword());
        authStep.clickSubmitButton();

        AssertUtils.makeAssert(authStep.getErrorAuthLoginText(),
                "Введите логин/email!");

        authStep.clickCloseLinkRegistrationForm();
    }

    @Test
    public void authUnSuccessfulTestWithEmail() {
        User user = DataGenerator.getUserDataForUnSuccessfulTestWithEmail();

        authStep.enterLoginOrEmail(user.getEmail());
        authStep.enterPassword(user.getPassword());
        authStep.clickSubmitButton();

        AssertUtils.makeAssert(authStep.getErrorAuthLoginText(),
                "Введите логин/email!");

        authStep.clickCloseLinkRegistrationForm();
    }

    @Test
    public void authUnSuccessfulTestWithPassword() {
        User user = DataGenerator.getUserDataForUnSuccessfulTestWithPassword();

        authStep.enterLoginOrEmail(user.getLogin());
        authStep.enterPassword(user.getPassword());
        authStep.clickSubmitButton();
        AssertUtils.makeAssert(authStep.getErrorAuthPasswordText(),
                "Введите пароль!");

        authStep.clickCloseLinkRegistrationForm();
    }
}
