@LoginUserProfile
Feature: Login User Profile

  As an user of the e-katalog
  I want to login my user profile using my credentials
  in order to be able to login and logout

    @SuccessfulLogin
    Scenario: Successful Login

      Given I am on home page
      When I click on sign in link
      Then I should see 'Войти' link on auth form
      When I click on sign in link on auth form
      And I enter login "some_login_15"
      And I enter password "some_password_15"
      And I click submit button
      Then I should see "some_login_15" link
      And I close browser

    @UnSuccessfulLogin
    Scenario Outline: Negative login scenario
      Given I am on home page
      When I click on sign in link
      Then I should see 'Войти' link on auth form
      When I click on sign in link on auth form
      And I login with credentials <login> and <password>
      And I click submit button
      And I should see <error_message> error message for password
      And I close browser
      Examples:

      | login            | password                   | error_message          |
      | some_new_login   |                            | Введите пароль!        |
      | some_new_login   | some_new_password_password | Пароль указан неверно! |
      | some_new_login   | 123456789                  | Пароль указан неверно! |
      | some_new_login   | !@#$%^&*(                  | Пароль указан неверно! |

    @UnSuccessfulPassword
    Scenario Outline: Negative password scenario
      Given I am on home page
      When I click on sign in link
      Then I should see 'Войти' link on auth form
      When I click on sign in link on auth form
      And I login with credentials <login> and <password>
      And I click submit button
      And I should see <error_message> error message for login
      And I close browser
      Examples:

        | login                  | password          | error_message                              |
        |                        | some_new_password | Введите логин/email!                       |
        | some_new_login_login   | some_new_password | Логина some_new_login_login не существует! |
        | 123456789              | some_new_password | Логина 123456789 не существует!            |
        | !@#$%^&*(              | some_new_password | email !@#$%^&*( указан неверно!            |