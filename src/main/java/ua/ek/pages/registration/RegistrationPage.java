package ua.ek.pages.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = ".//div[@class='signin-with signin-with-reg d-flex justify-content-center align-items-center']/span[@class='j-wrap orange']")
    private WebElement registerLinkOnRegistrationForm;

    // Locators for registration form fields

    @FindBy(xpath = ".//div[@class='registration-name ek-form-group']/input[@class='ek-form-control']")
    private WebElement loginField;

    @FindBy(xpath = ".//div[@class='registration-email ek-form-group']/input[@class='ek-form-control']")
    private WebElement emailField;

    @FindBy(xpath = ".//div[@class='registration-password ek-form-group']/input[@class='ek-form-control']")
    private WebElement passwordField;

    @FindBy(xpath = ".//div[@class='registration-actions r-text']/button[@class='ek-form-btn']")
    private WebElement backButtonRegistration;

    @FindBy(xpath = ".//div[@class='registration-actions r-text']/button[@class='ek-form-btn blue']")
    private WebElement submitButton;

    @FindBy(xpath = ".//input[@name='rules_accepted_']")
    private WebElement userAgreement;

    @FindBy(xpath = ".//div[@class='jclose']")
    private WebElement closeLinkRegistrationForm;

    // Locators for successful user registration

    @FindBy(xpath = ".//div[@id='mui_user_login_window']/div[@class='modal-header']")
    private WebElement successfulUserRegistrationElement;

    @FindBy(xpath = ".//div[@class='ek-form-group']/div[@class='ek-form-text']")
    private WebElement successfulUserRegistrationText;

    @FindBy(xpath = ".//div[@class='d-flex justify-content-end']")
    private WebElement successfulUserRegistrationButton;

    // Locators for error text links

    @FindBy(xpath = ".//div[@class='registration-name ek-form-group invalid']/div[@class='ek-form-text']")
    private WebElement loginError;

    @FindBy(xpath = ".//div[@class='registration-email ek-form-group invalid']/div[@class='ek-form-text']")
    private WebElement emailError;

    @FindBy(xpath = ".//div[@class='registration-email ek-form-group invalid']/div[@class='ek-form-text']")
    private WebElement emailIncorrectError;

    @FindBy(xpath = ".//div[@class='registration-password ek-form-group invalid']/div[@class='ek-form-text']")
    private WebElement passwordError;

    private By loginErrorElement = By.xpath(".//div[@class='registration-name ek-form-group invalid']/div[@class='ek-form-text']");
    private By emailErrorElement = By.xpath(".//div[@class='registration-email ek-form-group invalid']/div[@class='ek-form-text']");
    private By emailIncorrectErrorElement = By.xpath(".//div[@class='registration-email ek-form-group invalid']/div[@class='ek-form-text']");
    private By passwordErrorElement = By.xpath(".//div[@class='registration-password ek-form-group invalid']/div[@class='ek-form-text']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRegisterLinkOnRegistrationForm() {
        return registerLinkOnRegistrationForm;
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getBackButtonRegistration() {
        return backButtonRegistration;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getUserAgreement() {
        return userAgreement;
    }

    public WebElement getCloseLinkRegistrationForm() {
        return closeLinkRegistrationForm;
    }

    public WebElement getSuccessfulUserRegistrationElement() {
        return successfulUserRegistrationElement;
    }

    public WebElement getSuccessfulUserRegistrationButton() {
        return successfulUserRegistrationButton;
    }

    public By getLoginErrorElement(){
        return loginErrorElement;
    }

    public By getEmailErrorElement(){
        return emailErrorElement;
    }

    public By getEmailIncorrectErrorElement() {
        return emailIncorrectErrorElement;
    }

    public By getPasswordErrorElement(){
        return passwordErrorElement;
    }
}