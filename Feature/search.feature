@tag
Feature: To search valid product
  I want to use this template for my feature file

  @tSearch
  Scenario: SearchValidCredential
    Given I have browser withopencartpage
    When Isearch for the product with 'samsung'
    Then Ishould get all the search related products
