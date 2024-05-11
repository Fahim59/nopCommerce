@placeOrder
Feature: Nop_Station place order feature Test

  @test-3
  Scenario: User should be able to successfully place an order
    Given Go to the home page
    When Login to the site
    And Search two product from test data file and add to the shopping cart
    And Go to shopping cart and checkout
    And Place order successfully
    Then Go to the order details page and verify the order