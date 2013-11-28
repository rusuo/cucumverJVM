Feature: test my Android app

Scenario: Enter a text and submit it
 Given I am on first page
 When I enter a text
 And I submit it
 Then I can see the new page with the text entered
 