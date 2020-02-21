package ua.ek.pages.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;
import ua.ek.pages.HomePage;

public class AuthPage extends BasePage {

    @FindBy(xpath = ".//em[contains(text(), 'Регистрация')]")
    private WebElement registerLink;

    @FindBy(xpath = ".//input[@placeholder='Имя']")
    private WebElement loginField;

    @FindBy(xpath = ".//input[@placeholder='e-mail']")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@placeholder='пароль']")
    private WebElement passwordField;

    @FindBy(xpath = ".//input[@name='new_reg_' and @class='l-but2']")
    private WebElement submit;

    @FindBy(xpath = ".//input[@name='rules_accepted_']")
    private WebElement userAgreement;

    @FindBy(xpath = ".//div[@class='jclose']")
    private WebElement closeLink;

    // Locators for error text links

    @FindBy(xpath = ".//div[@class='l-err' and contains(text(), 'Имя')]")
    private WebElement loginError; // Заполните поле "Имя"

    @FindBy(xpath = ".//div[@class='l-err' and contains(text(), 'email')]")
    private WebElement emailFillError; // Заполните поле "email"

    @FindBy(xpath = ".//div[@class='l-err' and contains(text(), 'e-mail')]")
    private WebElement emailCorrectError; // Поле "e-mail" введено некорректно

    @FindBy(xpath = ".//div[@class='l-err' and contains(text(), 'Пароль')]")
    private WebElement passwordError; // Заполните поле "Пароль"

    private By loginErrorElement = By.xpath(".//div[@class='l-err' and contains(text(), 'Имя')]");
    private By emailErrorElement = By.xpath(".//div[@class='l-err' and contains(text(), 'email')]");
    private By passwordErrorElement = By.xpath(".//div[@class='l-err' and contains(text(), 'Пароль')]");

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    public AuthPage clickRegisterLink() {
        clickWebElement(registerLink);
        return this;
    }

    public AuthPage enterLogin(String login) {
        enterTextInTextField(loginField, login);
        return this;
    }

    public AuthPage enterEmail(String email) {
        enterTextInTextField(emailField, email);
        return this;
    }

    public AuthPage enterPassword(String password) {
        enterTextInTextField(passwordField, password);
        return this;
    }

    public BasePage clickCloseLink() {
        getWebElementText(closeLink);
        return new HomePage(driver);
    }

    public BasePage submit() {
        clickWebElement(submit);
        return this;
    }

    public By getLoginErrorElement(){
        return loginErrorElement;
    }

    public By getEmailErrorElement(){
        return emailErrorElement;
    }

    public By getPasswordErrorElement(){
        return passwordErrorElement;
    }

    public String getLoginErrorMessage(){
        return getWebElementText(loginErrorElement);
    }

    public String getEmailErrorMessage(){
        return getWebElementText(emailErrorElement);
    }

    public String getPasswordErrorMessage(){
        return getWebElementText(passwordErrorElement);
    }
}