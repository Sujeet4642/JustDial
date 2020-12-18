@ui @menu
Feature: Just Dial Application User stories Journeys
  

  Scenario Outline: User is able to navigate to left side menu links to navigate to various categories
    Given User navigated to the home application url
    When User clicks on "<SIDE_MENU_LINK_NAME>"
    Then User is navigates to the corresponding link realted to "<SIDE_MENU_LINK_NAME>"

    Examples:
    |SIDE_MENU_LINK_NAME|
    |Baby Care     |
    |Medical       |
    |Real Estate   |
    |Travel        |
    |Wedding       |