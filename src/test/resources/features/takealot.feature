Feature: shopclues Functional Test
  I want to add product to cart

  Background: 
    Given I want to navigate to "https://www.takealot.com"

  #@Test
  #Scenario: Register a user
    #Given I navigate to registration page
    #When I filled user data to registration
      #| manish | Kumar | test_1234@gmail.com | admin@123 | 7575757575 |
    #Then Verify user is registered

  @Test
  Scenario: Search a product
    Given I want to search for "watches"
    And I want to select brand "Garmin"
    When I add watches in my cart
      | Garmin Forerunner 45S Sports Watch Black |
      | Garmin Forerunner 45S Sports Watch White |
    Then Verify given products added to my cart
      | Garmin Forerunner 45S Sports Watch Black |
      | Garmin Forerunner 45S Sports Watch White |
