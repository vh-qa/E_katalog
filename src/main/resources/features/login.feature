@LoginUserProfile
Feature: Login User Profile
As an user of the e-katalog
I want to login my user profile using my credentials
in order to be able to login and logout

Scenario: Successful Login
Given I am on home page
When I click on sign in link
Then I am on Auth form
When I click on sign in link on auth form
And I enter login
And I enter password
And I click submit button
Then I should see some_login_15 link
