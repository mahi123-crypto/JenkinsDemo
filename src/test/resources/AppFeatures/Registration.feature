Feature: Ecommerce Account Registration

  Background: 
    Given user opens the browser
    When user clicks on register link
    And user is on registration page
    Then clicks on "Register" button


 # Scenario Outline: Valid user registration
   # When user enters valid user details "<gender>" "<firstname>" "<lastname>" "<date>" "<month>" "<year>" "<emailaddress>" "<companyName>" "<password>" "<confirmPass>"  in Registration form
   # Then clicks on "Register" button

   # Examples: 
      | gender | firstname | lastname | date | month  | year | emailaddress    | companyName | password | confirmPass |
      | female | mahi      | athani   |   14 | august | 1999 | mahi2@gmail.com | IVL         | mahi123  | mahi123     |
      
  Scenario: User leaves first name empty 
   When user leaves firstname  "password","password" empty
   Then user should get error message as first name is required
   
  # Scenario: user tries to register with already registered email id
   #When user enters email already registered
   #Then user should get The specified email already exists
   
  # Scenario: user enters invalid email
   #When user enters invalid email
   #Then user should get wrong email error message
   
     # Scenario: user enters wrong confirm password
  # When user enters invalid password while confirmation
  # Then user should get password do not match error message
   
  #  Scenario: user enters password length less than 6
  # When user enters password less than 6 length
   #Then user should get must have at least 6 characters error message
   