#Author       :   VH
#Scenario     :   Successful select tablets using filters on the right panel of the web site
#Application  :   E_katalog

@TabletsRightPanelFilters
Feature: Tablets Filter advanced selection on the right panel of the web site

  As an user of the e-katalog
  I want to select tablet using various parameters in filters on the right panel of the web site
  in order to select and buy tablet suitable for my needs

  @ManufacturerFilter
  Scenario: Successful tablets manufacturer filter selection

    Given User open the home page
    When User go tablets page
    And User click on apple checkbox in manufacturer filter panel
    And User click on show button
    Then User should see page with text Планшеты Apple according to the selected manufacturer filter

  @DisplayDiagonalFilter
  Scenario: Successful display diagonal filter selection

    Given User open the home page
    When User go tablets page
    And User click on 10 inches checkbox in display diagonal filter panel
    And User click on show button
    Then User should see page with text Планшеты 10 дюймов according to the selected display diagonal filter

  @PriceFilter
  Scenario: Successful price filter selection

    Given User open the home page
    When User go tablets page
    And User enter 10000 in min price field
    And User enter 14999 in max price field
    And User click on show button
    Then User should see page with text in range price от 10000 до 14999 грн.

  @ManufacturerAndDisplayDiagonalFilters
  Scenario: Successful tablets manufacturer and display diagonal filters selection

    Given User open the home page
    When User go tablets page
    And User click on apple checkbox in manufacturer filter panel
    And User click on 10 inches checkbox in display diagonal filter panel
    And User click on show button
    Then User should see page with text Планшеты Apple 10" according to the selected manufacturer and display diagonal filters