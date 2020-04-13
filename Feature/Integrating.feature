@tag
Feature: Integrating
  I want to use this template for my feature file

  @Integration
  Scenario: Integrating all the pages
    Given I had a webpage opencart
    When I enter valid credentials in login pag
    Then I have to navigate to laptop page and select product
    When I enter the credentials in Checkout page
    Then I should navigate to payment's page
    And I have to logout
