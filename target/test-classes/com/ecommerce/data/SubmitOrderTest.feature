

Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file


  Scenario Outline: Positive test of Submitting the order
    Given Logged in with useremail<Email> and password<Password>
    When I add product <ProductName> from cart
    And Checkout <ProductName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

    Examples: 
      | Email  						| Password				 | ProductName			  |
      | anshika@gmail.com |Iamking@000    	 | ZARA COAT 3			  |
      | anshika@gmail.com |Iamking@000       | Fail						    |
