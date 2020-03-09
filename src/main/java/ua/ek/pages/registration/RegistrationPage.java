package ua.ek.pages.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class RegistrationPage extends BasePage {

    // 'Регистрация' link on the registration form
    @FindBy(xpath = ".//em[contains(text(), 'Регистрация')]")
    private WebElement registerLink;

    // Locators for registration form fields

    @FindBy(xpath = ".//input[@placeholder='Имя']")
    private WebElement loginField;

    @FindBy(xpath = ".//input[@placeholder='e-mail']")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@placeholder='пароль']")
    private WebElement passwordField;

    @FindBy(xpath = ".//input[@name='new_reg_' and @class='l-but2']")
    private WebElement submitButton;

    @FindBy(xpath = ".//input[@name='rules_accepted_']")
    private WebElement userAgreement;

    @FindBy(xpath = ".//div[@class='jclose']")
    private WebElement closeLinkRegistrationForm;

    // Locators for successful user registration

    @FindBy(xpath = ".//div[@class='l-div']/div[@class='l-ok']")
    private WebElement successfulUserRegistrationElement; // Регистрация прошла успешно!

    @FindBy(xpath = ".//div[@class='l-d2']")
    private WebElement successfulUserRegistrationText;

    @FindBy(xpath = ".//input[@class='l-but2']")
    private WebElement successfulUserRegistrationButton; // Подтвердить

    // Locators for error text links

    @FindBy(xpath = ".//div[@class='l-err' and contains(text(), 'Имя')]")
    private WebElement loginError; // Заполните поле "Имя"

    @FindBy(xpath = ".//div[@class='l-err' and contains(text(), 'email')]")
    private WebElement emailError; // Заполните поле "email"

    @FindBy(xpath = ".//div[@id='mui_user_login_window_reg']/div[@class='l-err' and contains(text(),'e-mail')]")
    private WebElement emailIncorrectError; // Поле "e-mail" введено некорректно

    @FindBy(xpath = ".//div[@class='l-err' and contains(text(), 'Пароль')]")
    private WebElement passwordError; // Заполните поле "Пароль"

    private By loginErrorElement = By.xpath(".//div[@class='l-err' and contains(text(), 'Имя')]");
    private By emailErrorElement = By.xpath(".//div[@class='l-err' and contains(text(), 'email')]");
    private By emailIncorrectErrorElement = By.xpath(".//div[@id='mui_user_login_window_reg']/div[@class='l-err' and contains(text(),'e-mail')]");
    private By passwordErrorElement = By.xpath(".//div[@class='l-err' and contains(text(), 'Пароль')]");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRegisterLink() {
        return registerLink;
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