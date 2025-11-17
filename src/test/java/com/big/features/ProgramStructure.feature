@qa2
Feature: This feature file allow user to perform PROGRAM STRUCTURE Actions 
  
  
Background:
        Given User login to Appian application as "CaseManager"
        Then User navigates to Home category
      
#  sceario written by suraj umale.  
  
@ProgramStructure
 Scenario Outline: User should be able to "<ActionsPerformed>" record from edit Popup Program Structure and verify "<ActionsPerformed>" record under Program Filling Preparation
       When  User opens a contract case from the Assigned Programs "<testCaseID>"
       Then User clicks on Edit button on top right corner
       And  User selects the panels displayed below the Case Details "<panelOption>" under edit Pop-up
       And  User "<ActionsPerformed>" record with "<testCaseID>" from edit pop-up panels displayed below the Case Details
       When User navigate to "Program Filing / Preparation" paragraphtab 
       And  User verifies "<ActionsPerformed>" new data from "<panelOption>" table and "<testCaseID>" under Program Filling and Preparation

Examples:
 |testCaseID| panelOption  | ActionsPerformed  |
 |  TC_012  | Program Structure| added       |
 |  TC_012  | Program Structure| deleted     |
 
 

