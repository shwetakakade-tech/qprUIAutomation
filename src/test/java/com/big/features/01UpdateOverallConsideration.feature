@OverallConsideration
Feature: This feature file describe to add pricing structure when the user navigates to the Authorization/Refusal tab
 
 
#Prerequisite for this Scenario is to select case Number from UnAssigned Program 
#And to update the overall considerations in Authorization/Refusal tab

  
Background:
    Given User login to Appian application as "CaseManager"
    Then User navigates to Home category
  

Scenario Outline: User navigates to Home tab and add overall consideration
    When  User opens a contract case from the Assigned Programs "<testCaseID>"    
    Given User navigates to "<stage>" tab      
    And   User click UPDATE OVERALL CONSIDERATION in Actions
    And   User adds overall consideration values and click submit button
    Then  User verifies the values in "OVERALL CONSIDERATION" Tab
    

     Examples:
     | Stage                 | testCaseID |
     | Authorization/Refusal | TC_009  |  
    