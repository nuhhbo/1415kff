Feature: HomePage Labels Functionality


Background: 
	Given users goes to State Health Facts page
	Then United States map should be visible

@xyz @bg
Scenario: Make sure that correct name appears for each state
	When user hover mouse over following states
	|OH|
	|IL|
	|TX|
	|NY|
	|WY|
	|LA|
	|PA|
	|AZ|
	|FL|
	|VA|
	|AL|
	|GA|
	Then following states text should be displayed
	|OH|
	|IL|
	|TX|
	|NY|
	|WY|
@bg	
Scenario: Make sure that when each state is clicked, user is taken to that state’s page 
	When user clicks on the Ohio state on map
	Then url should be "https://www.kff.org/statedata/?state=OH"