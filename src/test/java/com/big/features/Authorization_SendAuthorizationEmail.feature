# Author is Ram Raj Pal 

@Appianauth
Feature: User navigates to Authorization/Refusal page
	
	#Prerequisite in order to send Authorization Email from Authorization/Refusal tab, "In-depth Analysis" must be completed
	
	Background:
  		Given User login to Appian application as "Ram"
   		Then User navigates to Home category

 @Authorizationrefusal
Scenario Outline: User navigates to Authorization/Refusal section and clicked on Send Authorization Email
When User opens a contract case from the Assigned Programs "<testCaseID>"
And User navigates to paragraphtab using "<paragraphtabs>"
Then User click on the Send Auth Email action
And User verify Authorization Email text
When User open the recipient drop down
And User select the recipient "<Recipient>" from the drop down 
Then User check the Acknowledge checkbox button
And User enter Wording Proposal text from "<Wordingtext>"
And User check and click on Send Authorization Email button
Then User navigate to authorization Results section "<Sectionname>"
And User validate the authorization email in sections
Then User navigate to communication tab using "<Casetab>"
And User validate authorization email is sent "<Emailtype>"




Examples:
|testCaseID|paragraphtabs|Recipient|Wordingtext|Sectionname|Casetab|Emailtype|
|TC_004|Paragraph_Tab|Recipient_Email|Wording_Text|Section_Name|Case_Tab|Email_Type|






