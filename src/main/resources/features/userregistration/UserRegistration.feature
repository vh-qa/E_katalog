@UserRegistration
Feature: User Registration

  As an user of the e-katalog
  I want to user registration
  in order to use all opportunities of the e-katalog

  Scenario: Successful user registration

    Given I am on home page
    When I click on sign in link
    Then I should see 'Регистрация' link on auth form
    When I click on registration link on auth form
    And I enter login "some_login_16"
    And I enter email "some_email_16@company.com"
    And I enter password "some_password_16"
    And I click submit button
    Then I should see form with text "Регистрация прошла успешно!"