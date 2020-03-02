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
        registrationStep.goAuthPage(driver);
        registrationStep.clickRegisterLink();
    }

    // Negative scenario

    @Test
    public void loginFieldRegistrationFormTestEmptyLogin() {
        registrationStep.enterLogin("");
        registrationStep.clickSubmitButton();
        AssertUtils.makeAssert(registrationStep.getRegistrationPage().getLoginErrorMessage(),
                "Заполните поле \"Имя\"");
    }

    @Test
    public void emailFieldRegistrationFormTestEmptyEmail() {
        registrationStep.enterEmail("");
        registrationStep.clickSubmitButton();
        AssertUtils.makeAssert(registrationStep.getRegistrationPage().getEmailErrorMessage(),
                "Заполните поле \"email\"");
    }

    @Test
    public void emailFieldRegistrationFormTestIncorrectEmail() {
        registrationStep.enterEmail("some-email");
        registrationStep.clickSubmitButton();
        AssertUtils.makeAssert(registrationStep.getRegistrationPage().getEmailIncorrectErrorMessage(),
                "Поле \"e-mail\" введено некорректно");
    }

    @Test
    public void passwordFieldRegistrationFormEmptyPassword() {
        registrationStep.enterPassword("");
        registrationStep.clickSubmitButton();
        AssertUtils.makeAssert(registrationStep.getRegistrationPage().getPasswordErrorMessage(),
                "Заполните поле \"Пароль\"");
    }

    // Positive scenario

    @Test
    public void successfulUserRegistration() {
        User user = DataGenerator.getUser();

        registrationStep.enterLogin(user.getLogin());
        registrationStep.enterEmail(user.getEmail());
        registrationStep.enterPassword(user.getPassword());

        registrationStep.clickSubmitButton();

        AssertUtils.makeAssert(registrationStep.getSuccessfulUserRegistrationTextFromWebElement(),
                "Регистрация прошла успешно!");
    }
}