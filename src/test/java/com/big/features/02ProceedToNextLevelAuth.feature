@Proceedtonextlevelauth
Feature: This feature file allow user to login to application
  
  
Background:
  	Given User login to Appian application as "CaseManager"
    Then User navigates to Home category
  

@appianHome   
Scenario: User navigates to Home Page
    Then User should see the Reinsurance text
      


Scenario Outline: User proceeds to Program Authorization for selected contract
    When User opens a contract case from the Assigned Programs "<testCaseID>"             	
    Given User navigates to "Authorization / Refusal" paragraphtab
    And User selects action from "<ActionTab>"
    And User selects Program Authorization from dropdown
    Then User should have Authorization Status as Pending Authorization Decision   
     
 Examples:
 |testCaseID|        ActionTab                  |       
 |TC_013    |Proceed to Next Level Authorization|

    


