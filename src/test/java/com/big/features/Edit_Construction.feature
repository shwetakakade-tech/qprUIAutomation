# Author is Ram Raj Pal 

Feature: User delete and add Construction Type 
	
	Background:
  		Given User login to Appian application as "CaseManager"
   		Then User navigates to Home category

@Construction
Scenario Outline: User delete and add Construction Type
When User opens a contract case from the Assigned Programs "<testCaseID>"
And User click on Edit button
Then User click on "Construction Type" Program Menu Tab
#Then User verify the deleted row from "<testCaseID>"
When User delete existing records:
|Concrete|
|Wooden Frame|
|Wire|
#When User add the new records from "<testCaseID>"
When User add new multiple row:
|RowName|RowValue|
|Concrete|16675|
|Electric Equip|4500|
|Wooden Frame|6000|
Then User click on Save button
When User navigate to Program Filing Preparation paragraphtab
#Then User click on "Program Filing / Preparation" Program Menu Tab
Then User click on "Construction Type" Program Menu Tab
#Then User validate the newly row added values from "<testCaseID>"
Then User validate the added row and its values

Examples:
|testCaseID|
|TC_012|