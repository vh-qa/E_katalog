package ua.ek.pages.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

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

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getUserAgreement() {
        return userAgreement;
    }

    public WebElement getCloseLink() {
        return closeLink;
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
        return helper.getWebElementText(loginErrorElement);
    }

    public String getEmailErrorMessage(){
        return helper.getWebElementText(emailErrorElement);
    }

    public String getPasswordErrorMessage(){
        return helper.getWebElementText(passwordErrorElement);
    }
}