@login
Feature: Login
  @p1 @smoketest @automated
  Scenario: Login with correct credential
    Given I open login page
    When I enter correct "userName" and "password"
    When I click login
    Then I go to home page

  @p2 @smoketest
  Scenario Outline: Login with invalid credentail
    Given I open login page
    When I enter incorrect "<userName>" and "<password>"
    When I click login
    Then I see "<errorMessage>"
  Examples:
    |userName|password|errorMessage|
    |        |        |用户名不能为空！|
    |  test  |        |密码不能为空！|