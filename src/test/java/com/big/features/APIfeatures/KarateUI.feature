@Smoke
Feature: Dashbooard 

  @Smoke
  Scenario: Login with Valid Credentials
	#karate.configure('driver', { type: 'geckodriver', executable: 'C:/Drivers/geckodriver' });
	  Given driver 'https://crochettech.appiancloud.com/suite/sites/health-care-solution/'
	  * delay(2000)
	  And driver.maximize()
		And input("//*[@id='un']","hcsadmin")
		And input("//*[@id='pw']","Admin@123456")
		When click("//input[@value='Sign In']") 
		* delay(5000)
		Then match driver.title == 'Home - Health Care Solution'
	
	@Smoke
	Scenario: Verify the Dashboard content of Health care solution home screen
		Given driver 'https://crochettech.appiancloud.com/suite/sites/health-care-solution/'
	  * delay(2000)
	  And driver.maximize()
		And input("//*[@id='un']","hcsadmin")
		And input("//*[@id='pw']","Admin@123456")
		When click("//input[@value='Sign In']") 
		* delay(5000)
		Then match driver.title == 'Home - Health Care Solution'
		* def mydhasboard = text(".//span[@class='ColorText---color_custom']/strong")
		Then match mydhasboard == 'My Dashboard'
		* def elements = locateAll(".//div[@data-testid='CardLayout-cardDiv']/div/div[2]//span[@class='ColorText---color_custom']")
		* match karate.sizeOf(elements) == 4
		And match text(""+elements[0]+"") == 'TOTAL JOBS'
		And match text(""+elements[1]+"") == 'COMPLETED JOBS'
		And match text(""+elements[2]+"") == 'PENDING JOBS'
		And match text(""+elements[3]+"") == 'OVERDUE JOBS1'
		
	
