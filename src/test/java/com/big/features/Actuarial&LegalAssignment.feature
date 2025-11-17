@qa1
Feature: This feature file allow user to perform ACTUARIAL & LEGAL ASSIGNMENT Actions 
  
  
Background:
        Given User login to Appian application as "CaseManager"
        Then User navigates to Home category
      
#  sceario written by suraj umale.
#  precondition for this scenario is for the selected case id program filling preparation is completed  
  
@actuarialassignment
 Scenario Outline: User should able to perform action as "<Actions>"
       When  User opens a contract case from the Assigned Programs "<testCaseID>"
       And   User navigate to "<CaseMenu>" CaseMenu tab
       When  User navigate to "Upfront Analysis" paragraphtab 
       When  User selects the action section from "<ActionTab>"
       And   User selects from Assign Program - "<Actions>" popup "<testCaseID>"
       Then  "<Actions>" labels should display assigned values "<testCaseID>"
       
Examples:
 |CaseMenu|    ActionTab        |  Actions            |testCaseID|
 |Summary |Actuarial Assignment | Actuarial Analysis  | TC_003   |
  |Summary |Legal Assignment    |    Legal Analysis   |  TC_003  |


 