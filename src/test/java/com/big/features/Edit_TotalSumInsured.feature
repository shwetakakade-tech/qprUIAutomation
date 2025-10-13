# Author is Ram Raj Pal

Feature: User delete and add Total Sum Insured 
	
	Background:
  		Given User login to Appian application as "CaseManager"
   		Then User navigates to Home category

@Totalsuminsured
Scenario Outline: User delete and add Total Sum Insured
When User opens a contract case from the Assigned Programs "<testCaseID>"
And User click on Edit button
Then User click on "Total Sum Insured" Program Menu Tab
#When User delete existing records from "<testCaseID>"
When User delete existing records:
|2004|
|2003|
|2027|
#When User add the new records from "<testCaseID>"
When User add new multiples row:
|RowName|RowValue|RowValue2|
|2004|8970000|50%|
|2030|12345678|10%|
|2005|456789012|20%|
Then User click on Save button
When User navigate to Program Filing Preparation paragraphtab
#Then User click on "Program Filing / Preparation" Program Menu Tab
Then User click on "Total Sum Insured" Program Menu Tab
#Then User validate the newly row added values from "<testCaseID>"
Then User validates the added row and its values

Examples:
|testCaseID|
|TC_015|