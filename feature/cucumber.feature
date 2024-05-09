Feature: Testing ShoppersStop Website

  Scenario: Verify Login functionality
    Given user is on ShoppersStop.com website
    And verifying the logo of webpage
    When Navigating to login page
    When Entering MailId as input
    When Clicking on continue at mailId input page
    Then Entering otp received at mail
    
  Scenario: Verify Search Functionality
		Then Entering keyword in search textbox
		When Clicking on search icon
		Then verifying the product
		
	Scenario: Verify sorting Functionality
		When Clicking on dropdown menu for sorting
		Then Selecting method of sort
		
	Scenario: Verifying wishlist functionality
		When Clicking on wishlist icon of the product
		When Clicking on wishlist icon
		Then Verify the product added to wishlist
		Then remove the product from wishlist
		
	Scenario: Verifying cart functionality
		When Clicking on the product
		Then add product to cart
		When Clicking on cart icon
		Then verify the product added to cart
		Then remove the product from cart