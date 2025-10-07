@ReassignUnderwriter
Feature: Assign Underwriter and Underwriter Team

  #TC_001 is used for Assign Underwriter and Underwriter Team
  #Then the "<completedStage>" stage should turn green  -- Generic method to validate status of Stage / Phase
  
  Background:
  	Given User login to Appian application as "CaseManager"
   Then User navigates to Home category


  Scenario Outline: Assign Underwriter and UW Team
  	When User opens a contract case from the Home tab "<testCaseID>"
  	And User Opens "<stage>" stage under summary 
    And No Underwriter or UW Team is assigned 
    When User clicks on the ASSIGN UNDERWRITER action 
    And User selects Underwriting Team and Underwriter for "<testCaseID>"
    Then the "<completedStage>" stage should turn green 
    And available actions should include:
      | UPFRONT ANALYSIS     |
      | ACTUARIAL ASSIGNMENT |
      | LEGAL ASSIGNMENT     |
      | REFUSE PROGRAM       |
    And the UW Team and Underwriter labels should display assigned values
 Examples:
     |  stage            							| completedStage              | nextStage           |testCaseID|
     | Program Filing / Preparation  | Program Filing / Preparation | Upfront Analysis     |TC_001 |
 #    | Upfront Analysis             | In-depth Analysis    |      |
 #    | In-depth Analysis            | Negotiation & Quotation |
 #    | Negotiation & Quotation      | |
 #    | Authorization / Refusal      |  |
      

    # search case id , summary webelements , stages webelements

@ReassignUnderwriter
  Scenario Outline: Reassign Underwriter and UW Team
  	When User opens a contract case from the Home tab "<testCaseID>"
  	And User Opens "<stage>" stage under summary 
    And the UW Team and Underwriter labels should display assigned values
    When User clicks on the REASSIGN UNDERWRITER action
    And User selects Underwriting Team and Underwriter for "<testCaseID>"
        Then the "<completedStage>" stage should turn green
    And available actions should include:
      | UPFRONT ANALYSIS     |
      | ACTUARIAL ASSIGNMENT |
      | LEGAL ASSIGNMENT     |
      | REFUSE PROGRAM       |
    And the UW Team and Underwriter labels should display assigned values

  Examples:
       |  stage                        | completedStage              | nextStage           | testCaseID|
     |Program Filing / Preparation | Program Filing / Preparation | Upfront Analysis     | TC_002 |


