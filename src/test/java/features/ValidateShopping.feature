Feature: Validate user is able to buy items
  User should be able to add items to cart and proceed to checkout

  Background: Login as standard user
    Given I navigate to the app
    And I log in as "standard" user

  Scenario: Add items to shopping cart
    Given I am in inventory page
    When I add "Test.allTheThings() T-Shirt (Red)" to cart
    And I add "Sauce Labs Backpack" to cart
    And I go to my shopping cart
    And I click on "Checkout" button
    And I fill checkout form with following information
      | First Name      | Angel   |
      | Last Name       | Aguilar |
      | Zip/Postal Code | 97000   |
    And I click on continue button
    Then I validate items in checkout are the same I added
    When I click on "Finish" button
    Then I validate "THANK YOU FOR YOUR ORDER" message is displayed


