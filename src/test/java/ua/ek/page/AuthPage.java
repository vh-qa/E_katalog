package ua.ek.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;
import ua.ek.base.BaseTest;
import ua.ek.utils.Helper;
import ua.ek.utils.ITimeOfWait;

public class AuthPage extends BasePage {

    @FindBy(xpath = "//div[@class='l-m']//div[2]//em[1]")
//    @FindBy(xpath = "//div[contains(@class,'l-m')]//div[contains(@class,'ac')]//em")
    private WebElement registerLink;

    @FindBy(xpath = "//input[@placeholder='Имя']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@placeholder='e-mail']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='пароль']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='new_reg_' and @class='l-but2']")
    private WebElement submit;

    @FindBy(xpath = "//input[@name='rules_accepted_']")
    private WebElement userAgreement;

    @FindBy(xpath = "//div[@class='jclose']")
    private WebElement closeLink;

//    @FindBy(xpath = "//body[@class='nt wide-view page-list--catalog']/div[@id='mui_user_login']/div[@id='mui_user_login_window-outer']/div[@id='mui_user_login_window']/div[@class='help_content']/div[@class='l-div']/form[@class='l-f']/div[@id='mui_user_login_window_reg']/div[1]")
//    @FindBy(xpath = "//*[@id='mui_user_login_window_reg']/div[1]")
//    @FindBy(xpath = "//div[@id='mui_user_login_window_reg']/div")
//    @FindBy(xpath="//div[@id='mui_user_login_window_reg']//div[text()='Заполните поле \"Имя\"']")
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/form/div[1]/div[1]")
    private WebElement loginError; // Заполните поле "Имя"

    //    @FindBy(xpath = "//input[@class='warn' and @name='p_[NikName]']/following::div[@class='l-err']")
//    @FindBy(xpath = "//input[@class='warn' and @name='p_[NikName]']/following-sibling::*[1]")
//   @FindBy(xpath = "//div[@id='mui_user_login_window_reg']/following::div[@class='l-err']")
//  @FindBy(xpath = "//div[@id='mui_user_login_window_reg']/div[1]")
//    @FindBy(xpath = "//div[@id='mui_user_login_window_reg']/div[2]")
//    @FindBy(xpath = "//div[@id='mui_user_login_window_reg']//div[text()='Заполните поле \"email\"']")
//    @FindBy(xpath = "//div[@id='mui_user_login_window_reg']/div")
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/form/div[1]/div[2]")
    private WebElement emailFillError; // Заполните поле "email"

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div/form/div[1]/div[1]")
    private WebElement emailCorrectError; // Поле "e-mail" введено некорректно

    @FindBy(xpath = "//div[@id='mui_user_login_window_reg']/div/div")
//            @FindBy(xpath="//div[@id='mui_user_login_window_reg']//div[text()='Заполните поле \"Пароль\"']")
    private WebElement passwordError; // Заполните поле "Пароль"

    private String loginErrorLink = "/html/body/div[1]/div/div/div/div/form/div[1]/div[1]";
    private String emailFillErrorLink = "/html/body/div[1]/div/div/div/div/form/div[1]/div[2]";
    private String emailCorrectErrorLink = "/html/body/div[1]/div/div/div/div/form/div[1]/div[1]";
    private String passwordErrorLink = "//div[@id='mui_user_login_window_reg']/div/div";

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    // Click register link
    public AuthPage clickRegisterLink() {
        Helper.clickWebElement(registerLink);
        return this;
    }

    // Enter login
    public AuthPage enterLogin(String login) {
        Helper.enterTextInTextField(loginField, login);
        return this;
    }

    // Enter email
    public AuthPage enterEmail(String email) {
        Helper.enterTextInTextField(emailField, email);
        return this;
    }

    // Enter password
    public AuthPage enterPassword(String password) {
        Helper.enterTextInTextField(passwordField, password);
        return this;
    }

    // Click close link
    public BasePage clickCloseLink() {
        Helper.getWebElementText(closeLink);
        return new HomePage(driver);
    }

    // Click Submit Button
    public BasePage submit() {
        Helper.clickWebElement(submit);
        return this;
    }

    // Get loginErrorLink
    public String getLoginErrorLink() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, loginError);
        return loginErrorLink;
    }

    // Get emailFillErrorLink
    public String getEmailFillErrorLink() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, emailFillError);
        return emailFillErrorLink;
    }

    // Get emailCorrectErrorLink
    public String getEmailCorrectErrorLink() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, emailCorrectError);
        return emailCorrectErrorLink;
    }

    // Get password error link
    public String getPasswordErrorLink() {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, passwordError);
        return passwordErrorLink;
    }

    // Get login error message
    public String getLoginErrorMessage() {
        return Helper.getWebElementText(loginError);
    }

    // Get email fill error message
    public String getEmailFillErrorMessage() {
        return Helper.getWebElementText(emailFillError);
    }

    // Get email correct error message
    public String getEmailCorrectErrorMessage() {
        return Helper.getWebElementText(emailCorrectError);
    }

    // Get password error message
    public String getPasswordErrorMessage() {
        return Helper.getWebElementText(passwordError);
    }
}
