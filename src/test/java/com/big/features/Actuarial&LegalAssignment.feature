@qa1
Feature: This feature file allow user to perform ACTUARIAL & LEGAL ASSIGNMENT Actions 
  
  
Background:
        Given User login to Appian application as "CaseManager"
        Then User navigates to Home category
      
#  sceario written by suraj umale.
#  precondition for this scenario is for the selected case id program filling preparation is completed  
  
@actuarialassignment
 Scenario Outline: User should be able to do Actuarial Assignment
       When  User opens a contract case from the Assigned Programs "<testCaseID>"
       And   User navigate to "<CaseMenu>" CaseMenu tab
       When  User navigate to "Upfront Analysis" paragraphtab 
       When  User selects the action section from "<ActionTab>"
       And   User selects from Assign Program - Actuarial and Legal Analysis popup "<testCaseID>"
       Then  Actuarial and Legal labels should display assigned values "<testCaseID>"
Examples:
 |CaseMenu|    ActionTab        | testCaseID|
 |Summary |Actuarial Assignment |  TC_002  |
 






 