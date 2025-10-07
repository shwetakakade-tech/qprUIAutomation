@createCase
Feature: Send Email using generic email ID and Verify Case is created or not

Background:
        Given User login to Appian application as "CaseManager"
        Then User navigates to Home category

Scenario: Send Email and verify case is being created or not
 		 Given User send email with attachment
    Then case is being created under Home tab.
    And verify case created and add Case ID to Excel