package ua.ek.registration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ek.base.BaseTest;
import ua.ek.model.User;
import ua.ek.steps.registration.RegistrationStep;
import ua.ek.utils.AssertUtils;
import ua.ek.utils.DataGenerator;
import ua.ek.utils.PropertyReader;
import ua.ek.utils.StepType;

public class RegistrationPageTest extends BaseTest {

    private RegistrationStep registrationStep;

    @BeforeMethod
    public void openRegistryFormBeforeTest() {
        registrationStep = (RegistrationStep) getStep(StepType.REGISTRATION_STEP);
        registrationStep.goAuthPage()
                        .clickRegisterLink();
    }

    // Negative scenario

    @Test(priority=1)
    public void loginFieldRegistrationFormTestEmptyLogin() {
        User user = DataGenerator.getUserDataForUnSuccessfulTestWithLogin();
        registrationStep.enterLogin(user.getLogin())
                        .clickSubmitButton();
        String errorLoginExpectedMessage = PropertyReader
                .from("/properties/messagesFromWebSite.properties",
                        "registration.form.login.error.message")
                .getProperty("registration.form.login.error.message");

        AssertUtils.makeAssert(registrationStep.getLoginErrorMessage(), errorLoginExpectedMessage);
    }

    @Test(priority=2)
    public void emailFieldRegistrationFormTestEmptyEmail() {
        User user = DataGenerator.getUserDataForUnSuccessfulTestWithEmail();
        registrationStep.enterEmail(user.getEmail())
                        .clickSubmitButton();

        String errorEmailExpectedMessage = PropertyReader
                .from("/properties/messagesFromWebSite.properties",
                        "registration.form.email.error.message")
                .getProperty("registration.form.email.error.message");

        AssertUtils.makeAssert(registrationStep.getEmailErrorMessage(), errorEmailExpectedMessage);
    }

    @Test(priority=3)
    public void emailFieldRegistrationFormTestIncorrectEmail() {

        String userIncorrectEmail = PropertyReader
                .from("/properties/common.properties",
                        "user.incorrect.email")
                .getProperty("user.incorrect.email");

        String errorIncorrectEmailExpectedMessage = PropertyReader
                .from("/properties/messagesFromWebSite.properties",
                        "registration.form.incorrect.email.error.message")
                .getProperty("registration.form.incorrect.email.error.message");

        registrationStep.enterEmail(userIncorrectEmail)
                        .clickSubmitButton();

        AssertUtils.makeAssert(registrationStep.getEmailIncorrectErrorMessage(),
                                                errorIncorrectEmailExpectedMessage);
    }

    @Test(priority=4)
    public void passwordFieldRegistrationFormEmptyPassword() {
        User user = DataGenerator.getUserDataForUnSuccessfulTestWithPassword();
        registrationStep.enterPassword(user.getPassword())
                        .clickSubmitButton();

        String errorPasswordExpectedMessage = PropertyReader
                .from("/properties/messagesFromWebSite.properties",
                        "registration.form.password.error.message")
                .getProperty("registration.form.password.error.message");

        AssertUtils.makeAssert(registrationStep.getPasswordErrorMessage(), errorPasswordExpectedMessage);
    }

    // Positive scenario

    @Test(priority=5)
    public void successfulUserRegistration() {
        User user = DataGenerator.getUser();

        registrationStep.enterLogin(user.getLogin())
                        .enterEmail(user.getEmail())
                        .enterPassword(user.getPassword())
                        .clickSubmitButton();

        String successfulRegistrationExpectedMessage = PropertyReader
                .from("/properties/expectedMessages.properties",
                        "registration.form.successful.expected.message")
                .getProperty("registration.form.successful.expected.message");

        AssertUtils.makeAssert(registrationStep.getSuccessfulUserRegistrationTextFromWebElement(),
                                                successfulRegistrationExpectedMessage);
    }
}