Feature: Github Repository Search and About Page Navigation

  Scenario Outline: As a guest,User visit github,search for a specific repository and navigate to About page
    Given User visit the github site
    When User search by "<searchName>"
    Then User verify the "<searchResult>"
    When User click on the About button in the landing page footer
    Then User verify the About page
    Examples:
      | searchName       | searchResult          |
      | create-react-app | facebook/create-react-app |



