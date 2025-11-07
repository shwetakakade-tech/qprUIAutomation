@test
Feature: This feature file will send non binding authorization email
   As a Case Manager I want to send a non‑binding authorization email.
   
#Prerequisite for this Scenario is to select case Number from Assigned Program where Legal Analyst is already being assigned*/
Background:
		Given User login to Appian application as "CaseManager"
    Then User navigates to Home category
        
@appianHome1
Scenario Outline: Send non-binding authorization email
    When  User opens a contract case from the Assigned Programs "<testCaseID>"
    Given User navigates to the "<stage>" tabmenu
    When User clicks "Send Non Binding Authorization Email" button in Actions
    Then User enters all details in Non Binding email window screen
    And  User verifies authorization email in "Negotiation Results" tab
    
     Examples:
     | stage               |testCaseID|
     |Negotiation/Quotation| TC_017  |
     
     
       
      
       
       
        
       
      
       
            