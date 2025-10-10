@AuthorizationApprove/Reject
Feature: This feature file is to approve/reject Authorization Decision when user navigates to the Authorization/Refusal tab
 
#Author:Namita
#Prerequisite for this Scenario is to select case Number from Assigned Program where Legal Analyst is already being assigned*/

  
Background:
    Given User login to Appian application as "CaseManager"
    Then User navigates to Home category
  

Scenario Outline: User is on Home tab, opens the case and navigates to Authorization/Refusal tab
    When User opens a contract case from the Assigned Programs "<testCaseID>"
    Given the user navigates to the "<stage>" tab    
    When the user clicks AUTHORIZATION DECISION in Actions
    Then the user selects Actions: 
      | APPROVE  |
      | REJECT   |

     Examples:
    | stage                 | testCaseID |
    | Authorization/Refusal | TC_012    |
    