# Author is Ram Raj Pal 

@UpdateAssignedLine 
Feature: User navigates to Authorization/Refusal page
	
	#Prerequisite in order to send Authorization Email from Authorization/Refusal tab, "In-depth Analysis" must be completed
	
	Background:
  		Given User login to Appian application as "Ram"
   		Then User navigates to Home category

@updateAssignedLine 
Scenario Outline: User update signed line
When  User opens a contract case from the Assigned Programs "<testCaseID>"
When User navigate to "Authorization / Refusal" paragraphtab
When  User selects the action section from "<ActionTab>"
And User verify update singed line pop up
Then User enter layer1 and layer2 values from "<testCaseID>"
And User click on submit button
Then User navigate to Signed Lines and Signing Page tab
And User validates the layer1 and layer2 values from "<testCaseID>"

Examples:
|testCaseID |ActionTab| 
|TC_005 |Update Signed Lines|

