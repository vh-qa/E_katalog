package ua.ek.bdd.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ua.ek.base.BaseTest;

public class AuthTestSteps extends BaseTest {

    // Positive scenario

    @Given("^I am on home page$")
    public void goHomePage() {

    }

    @When("^I click on sign in link$")
    public void clickSignInLink() {
        authStep.goAuthPage(driver);
    }

    @Then("^I am on Auth form$")
    public void validateAuthForm() {

    }

    @When("^I click on sign in link on auth form$")
    public void clickSignInLinkOnAuthForm(){
        authStep.clickAuthLink();
    }

    @And("^I enter login '(.*?)'$")
    public void enterLogin(String login) {
        authStep.enterLoginOrEmail(login);
    }

    @And("^I enter password '(.*?)'$")
    public void enterPassword(String password) {
        authStep.enterPassword(password);
    }

    @And("^I unchecked 'remember me' checkbox$")
    public void uncheckedRememberMeCheckbox(){
        authStep.clickRememberMeCheckBoxAuth();
    }

    @And("^I click submit button$")
    public void clickSubmitButton() {
        authStep.clickSubmitButton();
    }

    @Then("^I should see '(.*?)' link$")
    public void validateUserProfile(){

    }
}
