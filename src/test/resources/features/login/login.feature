@Login
Feature: Login to Sauce homepage

  Scenario: Success login to Sauce homepage
    Given Andrea is a SauceCustomer
    When She tries to login
    Then She should see products list

  @QA
  Scenario Outline: Success login to Sauce homepage dataprovider
    Given Andrea is a SauceCustomer
    When She tries to login with username <userName> and password <password>
    Then She should see products list
    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |

  @inProgress
  Scenario: Success Logout to Sauce home page
    Given Andrea is a SauceCustomer
    When She tries to log out
    Then She should see the log in page
