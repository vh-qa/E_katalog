package ua.ek.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;
import ua.ek.base.BaseTest;
import ua.ek.utils.Helper;

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

    @FindBy(xpath = "//body[@class='nt wide-view page-list--catalog']/div[@id='mui_user_login']/div[@id='mui_user_login_window-outer']/div[@id='mui_user_login_window']/div[@class='help_content']/div[@class='l-div']/form[@class='l-f']/div[@id='mui_user_login_window_reg']/div[1]")
//    @FindBy(xpath = "//div[@id='mui_user_login_window_reg']/div")
//    @FindBy(xpath="//div[@id='mui_user_login_window_reg']//div[text()='Заполните поле \"Имя\"']")
    private WebElement loginError;

    //    @FindBy(xpath = "//input[@class='warn' and @name='p_[NikName]']/following::div[@class='l-err']")
//    @FindBy(xpath = "//input[@class='warn' and @name='p_[NikName]']/following-sibling::*[1]")
//   @FindBy(xpath = "//div[@id='mui_user_login_window_reg']/following::div[@class='l-err']")
//  @FindBy(xpath = "//div[@id='mui_user_login_window_reg']/div[1]")
//    @FindBy(xpath = "//div[@id='mui_user_login_window_reg']/div[2]")
//    @FindBy(xpath = "//div[@id='mui_user_login_window_reg']//div[text()='Заполните поле \"email\"']")
    @FindBy(xpath = "//div[@id='mui_user_login_window_reg']/div")
    private WebElement emailError;


    @FindBy(xpath = "//div[@id='mui_user_login_window_reg']/div/div")
//            @FindBy(xpath="//div[@id='mui_user_login_window_reg']//div[text()='Заполните поле \"Пароль\"']")
    private WebElement passwordError;

    private String loginErrorLink = "//body[@class='nt wide-view page-list--catalog']/div[@id='mui_user_login']/div[@id='mui_user_login_window-outer']/div[@id='mui_user_login_window']/div[@class='help_content']/div[@class='l-div']/form[@class='l-f']/div[@id='mui_user_login_window_reg']/div[1]";
    private String emailErrorLink = "//div[@id='mui_user_login_window_reg']/div";
    private String passwordErrorLink = "//div[@id='mui_user_login_window_reg']/div/div";

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    // Click register link
    public AuthPage registerLinkClick() {
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
//        waitUntilElementIsVisible(10, loginError);
        return loginErrorLink;
    }

    // Get emailErrorLink
    public String getEmailErrorLink() {
//        waitUntilElementIsVisible(10, emailError);
        return emailErrorLink;
    }

    // Get password error link
    public String getPasswordErrorLink() {
//        waitUntilElementIsVisible(10, passwordError);
        return passwordErrorLink;
    }

    // Get login error message
    public String getLoginErrorMessage() {
        return Helper.getWebElementText(loginError);
    }

    // Get email error message
    public String getEmailErrorMessage() {
        return Helper.getWebElementText(emailError);
    }

    // Get password error message
    public String getPasswordErrorMessage() {
        return Helper.getWebElementText(passwordError);
    }
}
