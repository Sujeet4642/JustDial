@ui @customerCare
Feature: Just Dial Application User stories Journeys
  

Scenario: User is able to see the drop down in customer care service tab
    Given User navigated to the home application url
    And User navigates to Customer care page by clicking on Customer Care tab at the right-mid of the page
    When User enter "online" in the Text box
    Then User is able to see the drop down and all the items in the list must have text as "online"
