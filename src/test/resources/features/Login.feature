@ui @login
Feature: Just Dial Application User stories Journeys
  
Background: Navigation to the URL
   Given User navigated to the home application url
   
  Scenario: User is able to Sign up in the application
    When  User clicks on Sign up link of the application
    And   User enters name as "sujeet" and Phone number as "8871304642" and clicks on Submit Button
    Then  User is displayed with the message as "OTP is sent on number"
    
  Scenario: User receives an error message when tries to enter incorrect mobile number in the Login pop up
    When User clicks on Login-in link of the application
    And User enters name as "sujeet" and Phone number as "1234567890" and clicks on Submit Button
    Then User gets error message as "Please Enter valid Mobile number!"
    
 
    
    Scenario: User is able to enter only 10 digits in the Mobile Text box
    When User clicks on Login-in link of the application
    Then User is able to enter only "10" digits in the Mobile text field
    
    
   

 