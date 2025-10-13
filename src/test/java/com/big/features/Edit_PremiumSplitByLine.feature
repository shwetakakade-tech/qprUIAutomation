# Author is Ram Raj Pal

Feature: User delete and add Premium Split By Line 
	
	Background:
  		Given User login to Appian application as "CaseManager"
   		Then User navigates to Home category

@premiumSplit
Scenario Outline: User delete and add Premium Split By Line
When User opens a contract case from the Assigned Programs "<testCaseID>"
And User click on Edit button
Then User click on "Premium Split by Line" Program Menu Tab
#When User delete existing records from "<testCaseID>"
When User delete existing records:
|Dwelling Policy-1|
|Dwelling Policy-2|
|Dwelling Policy|
#When User add the new records from "<testCaseID>"
When User add new multiple row:
|RowName|RowValue|
|Dwelling Policy-1|$290000|
|Dwelling Policy-2|$340000|
|Dwelling Policy|$1200000|
Then User click on Save button
When User navigate to Program Filing Preparation paragraphtab
#Then User click on "Program Filing / Preparation" Program Menu Tab
Then User click on "Premium Split by Line" Program Menu Tab
#Then User validate the newly row added values from "<testCaseID>"
Then User validate the added row and its values

Examples:
|testCaseID|
|TC_014|