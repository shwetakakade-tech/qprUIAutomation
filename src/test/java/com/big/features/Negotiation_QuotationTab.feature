@test
Feature: This feature file will send non binding refusal email
   As a Case ManagerI want to send a non‑binding refusal email.
   
#Prerequisite for this Scenario is to select case Number from Assigned Program where Legal Analyst is already being assigned*/
Background:
		Given User login to Appian application as "CaseManager"
    Then User navigates to Home category
        
@appianHome1
Scenario Outline: Send non-binding refusal email
    When  User opens a contract case from the Assigned Programs "<testCaseID>"
    And User navigates to the "<stage>" tab
    When User clicks "Send Binding Non Refusal" in Actions
    Then User sends the non-binding refusal email via Action
    And  User verifies the email in "Communiction" tab
    
     Examples:
     | stage               |testCaseID|
     |Negotiation/Quotation| TC_002  |
     
     
       
      
       
       
        
       
      
       
            