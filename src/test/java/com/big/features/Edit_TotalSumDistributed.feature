# Author is Ram Raj Pal

Feature: User delete and add row in Total Sum Distributed 
	
	Background:
  		Given User login to Appian application as "CaseManager"
   		Then User navigates to Home category

@totalSumDistributed
Scenario Outline: User delete and add row in Total Sum Distributed
When User opens a contract case from the Assigned Programs "<testCaseID>"
And User click on Edit button
#Then User click on Total Sum Distributed
Then User click on "Total Sum Distributed" Program Menu Tab
When User delete existing records:
|New York|
|Florida|
|Maryland|
#When User add the new records from "<testCaseID>"
When User add new multiple row:
|RowName|RowValue|
|Florida|166750|
|India|124500|
|Spain|1243400|
|New York|566100|
Then User click on Save button
When User navigate to Program Filing Preparation paragraphtab
Then User click on "Total Sum Distributed" Program Menu Tab
#Then User click on Total Sum Distributed
#Then User validate the newly row added values from "<testCaseID>"
Then User validate the added row and its values



Examples:
|testCaseID|
|TC_013|