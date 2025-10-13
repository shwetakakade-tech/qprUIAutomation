# Author is Ram Raj Pal 

Feature: User delete and add Premium History 
	
	Background:
  		Given User login to Appian application as "CaseManager"
   		Then User navigates to Home category

@PremiumHistory
Scenario Outline: User delete and add Premium History
When User opens a contract case from the Assigned Programs "<testCaseID>"
And User click on Edit button
Then User click on "Premium History" Program Menu Tab
#When User delete existing records from "<testCaseID>"
When User delete existing records:
|2021|
|2023|
#When User add the new records from "<testCaseID>"
When User add new multiples row:
|RowName|RowValue|RowValue2|
|2021|898770|5%|
|2023|5768978|15%|
Then User click on Save button
When User navigate to Program Filing Preparation paragraphtab
#Then User click on "Program Filing / Preparation" Program Menu Tab
Then User click on "Premium History" Program Menu Tab
#Then User validate the newly row added values from "<testCaseID>"
Then User validates the added row and its values

Examples:
|testCaseID|
|TC_015|