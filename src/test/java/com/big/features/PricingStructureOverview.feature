@PricingStructure
Feature: This feature file describe to add pricing structure when the user navigates to the In-depth Analysis tab
 
#Name of Author : Namita 
#Prerequisite for this Scenario is to select everytime a new case Number from Assigned Program 
#And to update the pricing structure in In-depth analysis tab

  
Background:
    Given User login to Appian application as "CaseManager"
    Then User navigates to Home category
  

Scenario Outline: User navigates to Home tab and add pricing structure
    When  User opens a contract case from the Assigned Programs "<testCaseID>"    
    Given User navigate to "<Stage>" tab and click PRICING STRUCTURE OVERVIEW
    And   User adds values and click submit button
    Then  User see "<stage>" turns green and completed
    

     Examples:
     | Stage               |testCaseID|
     | In-depth Analysis   | TC_008  |  
    