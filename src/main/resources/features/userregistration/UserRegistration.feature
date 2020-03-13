@UserRegistration
Feature: User Registration

  As an user of the e-katalog
  I want to user registration
  in order to use all opportunities of the e-katalog

  Scenario: Successful user registration

    Given User open the home page
    When User click on sign in link
    Then User should see Или зарегистрируйтесь link on auth form
    When User click on registration link on registration form
    And User enter login some_login_20
    And User enter email some_email_20@company.com
    And User enter password some_password_20
    And User click on submit button
    Then User should see form with text Регистрация прошла успешно!

  @UnSuccessfulRegistrationWithLogin
  Scenario Outline: Negative registration with login scenario

    Given User open the home page
    When User click on sign in link
    Then User should see Или зарегистрируйтесь link on auth form
    When User click on registration link on registration form
    And User enter login <login>
    And User click on submit button
    Then User should see <error_message> error message for login

    Examples:
      | login            | error_message                            |
      |                  | Заполните поле "Имя"                     |
      | !@#$%^&*(        | Поле "Имя" содержит недопустимые символы |

  @UnSuccessfulRegistrationWithEmail
  Scenario Outline: Negative registration with email scenario

    Given User open the home page
    When User click on sign in link
    Then User should see Или зарегистрируйтесь link on auth form
    When User click on registration link on registration form
    And User enter email <email>
    And User click on submit button
    Then User should see <error_message> error message for email

    Examples:
      | email            | error_message                               |
      |                  | Заполните поле "email"                      |
      | some_email       | Поле "e-mail" введено некорректно           |
      | 123456789        | Поле "e-mail" введено некорректно           |
      | !@#$%^&*(        | Поле "e-mail" содержит недопустимые символы |