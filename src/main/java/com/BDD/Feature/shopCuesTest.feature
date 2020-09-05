Feature: shopclues Functional Test
  I want to add product to cart

  Background: 
    Given I want to navigate to "https://www.shopclues.com"
    And Close allow notification pop-up

  @Test
  Scenario: Get course Details
    Given I navigate to "Home & Kitchen" option
    And clicked on "Curtains" product
    When i clicked on frist product
    And Click on add to cart button
    Then verify that correct message is displayed
      | Product added to cart |
