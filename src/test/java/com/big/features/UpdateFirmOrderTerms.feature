@UpdateFirmOrder
Feature: Update Firm Order details when the user navigates to the Negotiation/Quotation tab

  # Prerequisite: The case must be selected from Assigned Programs 
  
  

  Background:
    Given User login to Appian application as "CaseManager"
    Then User navigates to Home category

   Scenario Outline: User updates Firm Order details and verifies status
    When  User opens a contract case from the Assigned Programs "<testCaseID>"    
    Given the user is on "<stage>" tab and clicks "Update Firm Order Terms" in Actions
    And the user adds values in the "Firm Order Terms" section
    Then the user navigates to Firm Order details in the "Firm Order Terms" tab
    And the user verifies "Firm order details" and "FOT email"
    Then the "<stage>" tab turns green

  Examples:
    | testCaseID | stage                 |
    | TC_003     | Negotiation/Quotation |
