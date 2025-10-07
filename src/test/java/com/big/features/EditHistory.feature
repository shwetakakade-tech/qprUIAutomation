@EditLossHistory
  Feature: This feature file allow user to Edit Loss History
  
Background:
  	Given User login to Appian application as "CaseManager"
    Then User navigates to Home category
   
 # sceario written by Rucha Joshi.  
 # Need to enter Data in TC_011 column "R" "s" and "t" Edit_LossHistory_Year, Edit_LossHistory_Description and Edit_LossHistory_LossAmount
 # Existing bug found during automation testing : user will not able to delete last row data 
 
 Scenario Outline: User Edit Loss History 
    When User opens a contract case from the Assigned Programs "<testCaseID>"
    When User clicks on Edit button
    When User Navigates to Program type "<ProgramType>"
    And  Use click on Add button 
    And User Enter Loss history Details from "<testCaseID>"
    And Use click on save button
    Then User verify loss history details "<testCaseID>" and "<ProgramType>"
    When User deletes a random row
    Then User verify previously deleted row is no longer present "<ProgramType>"


 Examples:
 |    ProgramType       |testCaseID| 
 |    Loss History      |  TC_011  |
 
 