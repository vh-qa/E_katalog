#Author       :   VH
#Scenario     :   Successful and unsuccessful user registration
#Application  :   E_katalog

@UserRegistration
Feature: User Registration

  As an user of the e-katalog
  I want to user registration
  in order to use all opportunities of the e-katalog

  Background: The User starts out on the registration form

  @SuccessfulRegistration
  Scenario: Successful user registration

    Given User open the registration form
    When User click on registration link on registration form
    And User enter login some_login_34 on registration form
    And User enter email some_email_34@company.com on registration form
    And User enter password some_password_34 on registration form
    And User click on submit button on registration form
    Then User should see form with text Регистрация прошла успешно!
    And User close browser with registration form

  @UnSuccessfulRegistrationWithLogin
  Scenario Outline: Negative registration with login scenario

    Given User open the registration form
    When User click on registration link on registration form
    And User enter login <login> on registration form
    And User click on submit button on registration form
    Then User should see <error_message> error message for login on registration form
    And User close browser with registration form

    Examples:
      | login            | error_message                            |
      |                  | Заполните поле "Имя"                     |
      | !@#$%^&*(        | Поле "Имя" содержит недопустимые символы |

  @UnSuccessfulRegistrationWithEmail
  Scenario Outline: Negative registration with email scenario

    Given User open the registration form
    When User click on registration link on registration form
    And User enter email <email> on registration form
    And User click on submit button on registration form
    Then User should see <error_message> error message for email on registration form
    And User close browser with registration form

    Examples:
      | email            | error_message                               |
      |                  | Заполните поле "email"                      |
      | some_email       | Поле "e-mail" введено некорректно           |
      | 123456789        | Поле "e-mail" введено некорректно           |
      | !@#$%^&*(        | Поле "e-mail" содержит недопустимые символы |