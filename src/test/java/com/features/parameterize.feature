Feature: Home page verification
Scenario Outline:
  Given user is on "https://freecrm.co.in/index.html" page
  When user clicks on "loginLink" link
  Then verify page title is "Cogmento CRM"
  Then enter username "mepratikbidwai@gmail.com" and password "Vikas@123" and click on "loginButton"
  Then user clicks on "contacts" link
  Then user clicks on "newBtn" link
  Then enter firstname "<firstname>" and last name "<lastname>" and position "<position>"
  Then user clicks on "save" link
  And close the browser


  Examples:
  |firstname|lastname|position|
  |pratik   |kk      |TA      |
  |vicky    |dhillon |PA      |