@AddQuotation
Feature: Add Quotation when the user navigates to the Negotiation/Quotation tab
 
#Name of Author:Namita
#Prerequisite for this Scenario is to select case Number from Assigned Program where Legal Analyst is already being assigned*/

  
Background:
    Given User login to Appian application as "CaseManager"
    Then User navigates to Home category
  
@addingquotation
Scenario Outline: User navigates to Home tab and adds a quotation
    When  User opens a contract case from the Assigned Programs "<testCaseID>"
    And the user navigates to the "<stage>" tab
    When the user clicks "Add Quotation" via Action
    Then the user adds quotation values in the "Quotation" section
    And the user verifies quotation values in the "Non-Binding Quotation" tab

     Examples:
     | stage               |testCaseID|
     |Negotiation/Quotation| TC_002  |
    