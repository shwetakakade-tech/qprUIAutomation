@qa3
Feature: This feature file allow user to perform BUILDING Actions 
  
  
Background:
        Given User login to Appian application as "CaseManager"
        Then User navigates to Home category
      
#  sceario written by suraj umale.  
  
@BuildingYear
 Scenario Outline: User should be able to "<ActionsPerformed>" record from edit Popup BuildingYear and verify "<ActionsPerformed>" record under edit Popup BuildingYear
       When User opens a contract case from the Assigned Programs "<testCaseID>"
       Then User clicks on Edit button on top right corner
       And  User selects the panels displayed below the Case Details "<panelOption>" under edit Pop-up
       And  User perform "<ActionsPerformed>" building panel record with "<testCaseID>" from edit pop-up panels displayed below the Case Details
       And  User again clicks on Edit button on top right corner
       And  User selects again the panels displayed below the Case Details "<panelOption>" under edit Pop-up
       And  User verifies "<ActionsPerformed>" building panel new data from "<panelOption>" table and "<testCaseID>" under edit pop-up

Examples:
 |testCaseID| panelOption     |  ActionsPerformed  |
 |  TC_013  | Building Year   |     added       |
 |  TC_013  | Building Year   |   deleted      |
  
 
 
