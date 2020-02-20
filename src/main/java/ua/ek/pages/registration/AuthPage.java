package ua.ek.pages.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;
import ua.ek.pages.HomePage;

public class AuthPage extends BasePage {

    @FindBy(xpath = ".//div[@class='l-m']//div[2]//em[1]")
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

    //================================================================================//

    @FindBy(xpath = ".//div[@class='jclose']")
    private WebElement closeLink;

//  @FindBy(xpath = ".//div[@id='mui_user_login_window_reg']/div[@class='l-err' and contains(text(), 'Имя')]")
    @FindBy(xpath = ".//div[@class='l-err' and contains(text(), 'Имя')]")
    private WebElement loginError; // Заполните поле "Имя"

//  @FindBy(xpath = ".//div[@id='mui_user_login_window_reg']/div[@class='l-err' and contains(text(), 'email')]")
    @FindBy(xpath = ".//div[@class='l-err' and contains(text(), 'email')]")
    private WebElement emailFillError; // Заполните поле "email"

    @FindBy(xpath = ".//div[@class='l-err' and contains(text(), 'e-mail')]")
    private WebElement emailCorrectError; // Поле "e-mail" введено некорректно

//  @FindBy(xpath = ".//div[@id='mui_user_login_window_reg']/div/div")
    @FindBy(xpath = ".//div[@class='l-err' and contains(text(), 'Пароль')]")
    private WebElement passwordError; // Заполните поле "Пароль"

    //================================================================================//

    private By loginErrorElement = By.xpath(".//div[@class='l-err' and contains(text(), 'Имя')]");
    private By emailErrorElement = By.xpath(".//div[@class='l-err' and contains(text(), 'email')]");
    private By passwordErrorElement = By.xpath(".//div[@class='l-err' and contains(text(), 'Пароль')]");

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    // Click register link
    public AuthPage clickRegisterLink() {
        clickWebElement(registerLink);
        return this;
    }

    // Enter login
    public AuthPage enterLogin(String login) {
        enterTextInTextField(loginField, login);
        return this;
    }

    // Enter email
    public AuthPage enterEmail(String email) {
        enterTextInTextField(emailField, email);
        return this;
    }

    // Enter password
    public AuthPage enterPassword(String password) {
        enterTextInTextField(passwordField, password);
        return this;
    }

    // Click close link
    public BasePage clickCloseLink() {
        getWebElementText(closeLink);
        return new HomePage(driver);
    }

    // Click Submit Button
    public BasePage submit() {
        clickWebElement(submit);
        return this;
    }

    // Get login error message
    public String getLoginErrorMessage() {
        if(isWebElementPresent(loginErrorElement)) {
            return getWebElementText(loginErrorElement);
        }else{
            return "";
        }
    }

    // Get email fill error message
    public String getEmailFillErrorMessage() {
        if(isWebElementPresent(emailErrorElement)) {
            return getWebElementText(emailErrorElement);
        }else{
            return "";
        }
    }

    // Get password error message
    public String getPasswordErrorMessage() {
        if(isWebElementPresent(passwordErrorElement)) {
            return getWebElementText(passwordErrorElement);
        }else{
            return "";
        }
    }
}
