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