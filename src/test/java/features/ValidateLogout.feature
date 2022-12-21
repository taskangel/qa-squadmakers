Feature: Validate user is able to logout

  Background: Login as standard user
    Given I navigate to the app
    And I log in as "standard" user

  Scenario: User login and then logout
    Given I am in inventory page
    When I select "Logout" option on nav bar
    Then I validate login page is displayed