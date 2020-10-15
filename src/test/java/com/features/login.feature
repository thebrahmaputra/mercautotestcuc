Feature: Home page verification
#  Scenario: Login page link verification
#    Given user is on login page
#    When user clicks on link SIGN-ON
#    Then verify page title is Sign-on: Mercury Tours
#    And close the browser

#  Scenario Outline: Login feature verification
#    Given user is on login page
#    When clicks on link SIGN-ON
#    And verify page title is Sign-on: Mercury Tours
#    Then enter username "<username>" and password "<password>"
#    And click on Submit button
#    Then user is on page titled abc
#
#    Examples:
#    |username|password|
#    |admin   |admin   |
#    |mercury |mercury |

  @BasicTest
  Scenario: Login page link verification
    Given user is on "http://demo.guru99.com/selenium/newtours/index.php" page
    When user clicks on link
    |homeLink|
    |flightLink|
    |hotelLink |
    Then verify page title is Sign-on: Mercury Tours

#    @BasicTest
  Scenario: Login page REGISTER link verification
    Given user is on "http://demo.guru99.com/selenium/newtours/index.php" page
    When user clicks on "REGISTER" link
    Then verify page title is Sign-on: Mercury Tours
    #Then capture screenshot
#    And close the browser
