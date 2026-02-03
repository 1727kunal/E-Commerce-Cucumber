Feature: 
Login

Background:
Given User opens the browser
And Hit the URL
Then User should land on the homepage
When User clicks on MyAccount button
When User clicks on Login link
Then User should land on the login page

Scenario:
When User enters the email as "alex12345@example.com"
And password as "alex@123"
And clicks on login button
Then User should land on the my account page
And User close the browser