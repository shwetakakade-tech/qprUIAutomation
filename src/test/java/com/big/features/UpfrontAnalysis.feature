@UpfrontAnalysis
  Feature: This feature file allow user to UpfrontAnalysis
  
Background:
  	Given User login to Appian application as "CaseManager"
    Then User navigates to Home category
   
 #  sceario written by Rucha Joshi.
 #  precondition for this scenario is for the selected case id program filling preparation should be completed  
 
 Scenario Outline: User submit Upfront Analysis 
    When  User opens a contract case from the Assigned Programs "<testCaseID>"
    When User navigate to "Upfront Analysis" paragraphtab
    When  User selects the action section from "<ActionTab>"
    And user select "<UWColor>" for the UW Guidelines category
  	And user select "<CRColor>" for the Capacity Retro category
  	And user select "<PFColor>" for the Performance category
    And user click on Upfront Analysis submit button
    Then the upfront analysis should be displayed "Action completed"

    
 Examples:
 |    ActionTab   |testCaseID| UWColor  |  CRColor |  PFColor |  
 |Upfront Analysis|  TC_006  |  Green   |  Green   |  Green   |

