Feature: Add To Cart functionality

  Background: 
    Given browser is open

  #Scenario: Shopping cart with zero items
  #Given user clicks on shopping cart
  #Then user should be able to see your shopping cart is empty
  Scenario: Shopping cart with added products
    When user adds the prodcuts
    Then user should be able to see the products in shopping cart

  Scenario: Shopping cart when removed from the cart
    When user removes product from the cart
    Then user should be able to see the updated cart
