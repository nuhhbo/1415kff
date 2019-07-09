Feature: Search Box Functionality

@SearchBox
Scenario: Test the search box feature under the State Health Fact Page
    Given users goes to State Health Facts page
    Then verify that search box is visible
    When user types "flu" in the search box on the top and click on the search button
    Then results should include "flu" keyword 
    And results should automatically listed under State Data
  
@SearchBox1   
Scenario: Assure that keyword related results appear
 	Given user goes to State Health Facts page
 	When user scrolls down till New and Update Indicators
 	Then Verify that articles are sorted in descending order, newest being at the top