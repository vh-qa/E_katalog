#Author       :   VH
#Scenario     :   Successful and unsuccessful login
#Application  :   E_katalog

@LoginUserProfile
Feature: Login User Profile

  As an user of the e-katalog
  I want to login my user profile using my credentials
  in order to be able to login and logout

  Background: The User starts out on the auth form

    @SuccessfulLogin
    Scenario: Successful Login

      Given User open the auth form
      When User click on sign in link on auth form
      And User enter login some_login_15 on auth form
      And User enter password some_password_15 on auth form
      And User click on submit button on auth form
      Then User should see some_login_15 link
      And User close browser with auth form

    @UnSuccessfulLogin
    Scenario Outline: Negative login scenario

      Given User open the auth form
      When User click on sign in link on auth form
      And User login with credentials <login> and <password>
      And User click on submit button on auth form
      Then User should see <error_message> error message for password on auth form
      And User close browser with auth form

      Examples:
      | login            | password                   | error_message          |
      | some_new_login   |                            | Введите пароль!        |
      | some_new_login   | some_new_password_password | Пароль указан неверно! |
      | some_new_login   | 123456789                  | Пароль указан неверно! |
      | some_new_login   | !@#$%^&*(                  | Пароль указан неверно! |

    @UnSuccessfulPassword
    Scenario Outline: Negative password scenario

      Given User open the auth form
      When User click on sign in link on auth form
      And User login with credentials <login> and <password>
      And User click on submit button on auth form
      Then User should see <error_message> error message for login on auth form
      And User close browser with auth form

      Examples:
      | login                           | password          | error_message                              |
      |                                 | some_new_password | Введите логин/email!                       |
      | some_new_login_login            | some_new_password | Логина some_new_login_login не существует! |
      | 1234567890123456789             | some_new_password | Логина 1234567890123456789 не существует!  |
      | !@#$%^&*(                       | some_new_password | email !@#$%^&*( указан неверно!            |