Feature: User Registration, Login, and Product Browsing

  Scenario: Navigate to the DemoBlaze Homepage and Sign Up
    Given I open the browser and navigate to "https://www.demoblaze.com/index.html"
    When I click on the "Sign up" button
    And I enter "testuser123" as the username
    And I enter "password123" as the password
    And I click on the "Sign up" button to submit the form
    Then I should see a confirmation message

  Scenario: Navigate to the DemoBlaze Homepage and Log In
    Given I open the browser and navigate to "https://www.demoblaze.com/index.html"
    When I click on the "Log in" button
    And I enter the registered username "testuser123"
    And I enter the password "password123"
    And I click on the "Log in" button to submit the form
    Then I should see my username displayed on the top right of the page

  Scenario: Browse and Select a Product
    Given I open the browser and navigate to "https://www.demoblaze.com/index.html"
    When I click on the "Phones" category
    And I select the product "Samsung galaxy s6"
    Then I should be taken to the product details page