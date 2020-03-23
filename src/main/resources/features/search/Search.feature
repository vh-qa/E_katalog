#Author       :   VH
#Scenario     :   Successful search of tablets
#Application  :   E_katalog

@TabletsSearch
Feature: Tablets Search

  As an user of the e-katalog
  I want to search tablets
  in order to select and buy tablet suitable for my needs

  @SuccessfulTabletsSearch
  Scenario: Successful tablets search

    Given User go to the search panel
    When User enter search text планшеты apple in search field
    And User click on search button
    Then User should see page with text планшеты apple according to the search text
    And User close browser after tablets search