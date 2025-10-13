# Author is Ram Raj Pal 

@Appianauth
Feature: User navigates to Authorization/Refusal page
	
	#Prerequisite in order to send Authorization Email from Authorization/Refusal tab, "In-depth Analysis" must be completed
	
	Background:
  		Given User login to Appian application as "CaseManager"
   		Then User navigates to Home category

@SenthAuthorizationEmail
Scenario Outline: User Send Authorization Email
When  User opens a contract case from the Assigned Programs "<testCaseID>"
When User navigate to "Authorization / Refusal" paragraphtab
When  User selects the action section from "<ActionTab>"
And User verify Heading as Authorization Email text
When User open the recipient drop down
And User select the Recipient email from dropdown as Recipient TO
Then User check the Acknowledge checkbox
And User enter Wording Proposal text from "<testCaseID>"
And User check visibility of Send Authorization Email button
And User click on Send Authorization Email button
Then User navigate to authorization Results section
And User validate the authorization email in section
And User navigate to "<CaseMenu>" CaseMenu tab
And User validate authorization email is being sent 


Examples:
|testCaseID |ActionTab| CaseMenu|
|TC_004 |Send Authorization Email|Communication|


