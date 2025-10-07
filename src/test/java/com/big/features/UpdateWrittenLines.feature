@UpdateWrittenLines
  Feature: This feature file allow user to UpfrontAnalysis
  
Background:
  	Given User login to Appian application as "CaseManager"
    Then User navigates to Home category
   
 #  sceario written by Rucha Joshi.
 #Prerequisite in order to Update Written Lines from Authorization/Refusal tab, Till and  "In-depth Analysis" must be completed 
 
 Scenario Outline: User Update Written Lines 
    When  User opens a contract case from the Assigned Programs "<testCaseID>"
    When User navigate to "Authorization / Refusal" paragraphtab
    When  User selects the action section from "<ActionTab>"
    And User Enter first Written line from "<testCaseID>"
    And User Enter Second Written line from "<testCaseID>"
    And User click on Save button
    Then Written lines should be updated "<testCaseID>"
    
 Examples:
 |    ActionTab       |testCaseID| 
 |Update Written Lines|  TC_007  |

