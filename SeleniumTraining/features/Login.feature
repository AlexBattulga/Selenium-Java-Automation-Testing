Feature: Test the login functionality on sdet university
Scenario: The user should be able to login with correct username and correct password
Given user is on the login page
When user enters correct username and correct password
Then user gets confirmation

Scenario Outline: the user should be able to login
Given user is on the login page
When user enters email <username>
And user enters password<password>
Then user gets confirmation

Examples:
| username | password |
| tim@testemail.com | trpass |
| rw@testemail.com | drpass |
| er@testemail.com | tfrpass |
