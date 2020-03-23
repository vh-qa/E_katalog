#Author       :   VH
#Scenario     :   Successful select tablets using filters on the top panel of the page with list of tablets
#Application  :   E_katalog

@TabletsTopPanelFilters
Feature: Tablets Filter advanced selection on the top panel of the page with list of tablets

  As an user of the e-katalog
  I want to select tablet using various parameters in top panel of the page with list of tablets
  in order to select and buy tablet suitable for my needs

  @ManufacturerLinkTest
  Scenario: Successful tablets manufacturer link selection

    Given User go tablets page
    When User click on apple manufacturer link in the filter panel
    Then User should see page with text Планшеты Apple according to the selected manufacturer link
    And User close browser after using top panel filter

  @DisplayDiagonalLinkTest
  Scenario: Successful tablets display diagonal link selection

    Given User go tablets page
    When User click on 10 inches display diagonal link in the filter panel
    Then User should see page with text Планшеты 10 дюймов according to the selected display diagonal link
    And User close browser after using top panel filter

  @FixedPriceLinkTest
  Scenario: Successful tablets fixed price link selection

    Given User go tablets page
    When User click on 7000 — 10000 грн. link in the filter panel
    Then User should see page with text от 7000 до 10000 грн. according to the selected fixed price link
    And User close browser after using top panel filter

  @PricesTest
  Scenario Outline: Successful tablets prices test

    Given User go tablets page
    When User enter <min_price> in min price field
    And User enter <max_price> in max price field
    And User click on submit button
    Then User should see page with text in range price <expected_message>
    And User close browser after using top panel filter

    Examples:
    | min_price    | max_price    | expected_message        |
    | 5000         | 9999         | от 5000 до 9999 грн.    |
    | 10000        | 14999        | от 10000 до 14999 грн.  |
    | 15000        | 19999        | от 15000 до 19999 грн.  |
    | 20000        | 24999        | от 20000 до 24999 грн.  |
    | 25000        | 29999        | от 25000 до 29999 грн.  |