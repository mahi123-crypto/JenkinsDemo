Feature: User Login

Background:
 Given browser is open
 And user clicks on login link
 Then user is on login page
 

Scenario: User enters valid credentials
 When user enters valid email and valid password
Then user login should be successful

Scenario: User enters invalid email
When user enters invalid email and valid password
Then it should display wrong email

Scenario: User enters invalid password
When user enters valid email and invalid password
Then it should display credentials are incorrect

Scenario: User enters empty field
 When user leave fields empty
Then it should display please enter your email

Scenario: User does not exist
When user enters invalid email and invalid password
Then No customer account found
