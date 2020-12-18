@ui @search
Feature: Just Dial Application User stories Journeys
  
Background: Navigation to the URL
   Given User navigated to the home application url
  
  Scenario: User is able to search the Application
    When  User enters "restaurants" in search textbox 
    And   User clicks search button
    Then  User is able to see result realated to "restaurants"
    
  Scenario: User is able to see the drop down when he keys in the text in the search box
      When User enters "resta" in search text box
      Then User is able to see the drop down under search text box with all the items with text "resta"
    
    

 