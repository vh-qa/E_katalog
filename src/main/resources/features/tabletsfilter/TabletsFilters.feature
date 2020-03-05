@TabletsFilters
Feature: Tablets Filter advanced selection

  As an user of the e-katalog
  I want to select tablet using various parameters
  in order to buy tablet suitable for my needs

  Scenario: Successful tablets manufacturer filter selection

    Given I am on home page
    When I go tablets page
    And I click on "apple" checkbox
    And I click on 'Показать' button
    Then I am on page with list of Apples tablets
