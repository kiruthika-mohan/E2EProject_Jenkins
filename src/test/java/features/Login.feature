Feature: Login into Application

Scenario Outline: Positive test validating login
Given Intialize the browser with chrome
And Navigate to "http://qaclickacademy.com" Site
And Click on Login link in home page to land on secure sign in page
When User enters <Username> and <Password> and logs in
Then Verify that user is successfully logged in 
And close browsers

Examples:
|Username                 |Password  |
|nonresticteduser@qa.com  |123456    |
|resticteduser@qa.com     |456789    |