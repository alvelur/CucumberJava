Feature: Login Functionality
  In order to do internet banking
  As a valid Para Bank customer
  I want to login successfully

  Scenario: Login Successful
    Given I am in the login page of the Para Bank Application
    When I enter valid credentials
    Then I should be taken to the Overview page
#
#  Scenario: Login Successful
#    Given I am in the login page
#    When I enter valid credentials
#    Then I should be taken to the Overview page

#  Scenario Outline: Login Successful
#    Given I am in the login page of the Para Bank Application
#    When I enter valid <username> and <password> with <userFullName>
#    Then I should be taken to the Overview page
#    Examples:
#      | username | password |userFullName|
#      |"Alejandro" | "password" |"Alejandro Velasquez"|
#      |"Jorge" | "password" |"Jorge Roldan"|

#  Scenario: Login Successful
#    Given I am in the login page of the Para Bank Application
#    When  I enter valid credentials chart
#      |Alejandro|password|
#    Then I should be taken to the Overview page




