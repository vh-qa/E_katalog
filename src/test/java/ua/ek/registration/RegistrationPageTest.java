package ua.ek.registration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.model.User;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.DataGenerator;

public class RegistrationPageTest extends BaseTest {

    @BeforeMethod
    public void openRegistryFormBeforeTest() {
        getRegistrationStep().goAuthPage()
                        .clickRegisterLink();
    }

    // Negative scenario

    @Test
    public void loginFieldRegistrationFormTestEmptyLogin() {
        getRegistrationStep().enterLogin("")
                        .clickSubmitButton();

        AssertUtils.makeAssert(getRegistrationStep().getLoginErrorMessage(),
                "Заполните поле \"Имя\"");
    }

    @Test
    public void emailFieldRegistrationFormTestEmptyEmail() {
        getRegistrationStep().enterEmail("")
                        .clickSubmitButton();

        AssertUtils.makeAssert(getRegistrationStep().getEmailErrorMessage(),
                "Заполните поле \"email\"");
    }

    @Test
    public void emailFieldRegistrationFormTestIncorrectEmail() {
        getRegistrationStep().enterEmail("some-email")
                        .clickSubmitButton();

        AssertUtils.makeAssert(getRegistrationStep().getEmailIncorrectErrorMessage(),
                "Поле \"e-mail\" введено некорректно");
    }

    @Test
    public void passwordFieldRegistrationFormEmptyPassword() {
        getRegistrationStep().enterPassword("")
                        .clickSubmitButton();

        AssertUtils.makeAssert(getRegistrationStep().getPasswordErrorMessage(),
                "Заполните поле \"Пароль\"");
    }

    // Positive scenario

    @Test
    public void successfulUserRegistration() {
        User user = DataGenerator.getUser();

        getRegistrationStep().enterLogin(user.getLogin())
                        .enterEmail(user.getEmail())
                        .enterPassword(user.getPassword())
                        .clickSubmitButton();

        AssertUtils.makeAssert(getRegistrationStep().getSuccessfulUserRegistrationTextFromWebElement(),
                "Регистрация прошла успешно!");
    }
}