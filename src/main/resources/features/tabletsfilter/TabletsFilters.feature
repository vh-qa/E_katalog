@TabletsFilters
Feature: Tablets Filter advanced selection

  As an user of the e-katalog
  I want to select tablet using various parameters
  in order to buy tablet suitable for my needs

  Scenario: Successful tablets manufacturer filter selection

    Given User open the home page
    When User go tablets page
    And User click on apple checkbox
    And User click on show button
    Then User should see page with text 'Планшеты Apple '